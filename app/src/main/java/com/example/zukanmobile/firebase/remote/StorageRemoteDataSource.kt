package com.example.zukanmobile.firebase.remote

import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

// FirebaseのStorageにアクセスしてデータを取得するクラス --------------------------------------------------
class StorageRemoteDataSource @Inject constructor(
    private val storage: FirebaseStorage
) {


    // 画像を読み込む関数
    suspend fun getSpecieImageUrl(id: String): String? {
        return try {
            val ref = storage.reference.child("t_${id}.png")
            ref.downloadUrl.await().toString()
        } catch (e: Exception) {
            null
        }
    }


    // .glbを読み込む関数
    suspend fun getSpecieModelUrl(id: String): String? {
        return try {
            val ref = storage.reference.child("${id}.glb")
            ref.downloadUrl.await().toString()
        } catch (e: Exception) {
            null
        }
    }
}