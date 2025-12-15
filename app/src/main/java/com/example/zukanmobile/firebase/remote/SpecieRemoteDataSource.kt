package com.example.zukanmobile.firebase.remote

import android.util.Log
import com.example.zukanmobile.firebase.data.Specie
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

// =================================================================================================
// FirestoreのSpeciコレクションにアクセスしてデータを取得するクラス
// =================================================================================================
class SpecieRemoteDataSource @Inject constructor(
    private val db: FirebaseFirestore
) {

    private val specie = db.collection("species")


    // Specie内のデータ全件を取得する関数
    suspend fun fetchSpecies(): List<Specie> {
        return try {
            val snapshot = specie.get().await()
            snapshot.documents.mapNotNull { doc ->
                doc.toObject(Specie::class.java)?.copy(id = doc.id)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    // SpecieコレクションのIDを取得する関数
    suspend fun fetchSpecieId(id: String): Specie? {
        return try {
            val doc = specie.document(id).get().await()
            doc.toObject(Specie::class.java)?.copy(id = doc.id)
        } catch (e: Exception) {
            null
        }
    }
}
