package com.example.zukanmobile.firebase.repository

import com.example.zukanmobile.firebase.data.Specie
import com.example.zukanmobile.firebase.remote.SpecieRemoteDataSource
import com.example.zukanmobile.firebase.remote.StorageRemoteDataSource
import com.example.zukanmobile.ui.screen.s2_list.SpecieListItem
import javax.inject.Inject

class SpecieRepository @Inject constructor(
    private val specieRemote: SpecieRemoteDataSource,
    private val storageRemote: StorageRemoteDataSource
) {

    // 一覧画面に表示するデータをまとめた関数
    suspend fun fetchSpecieListItems(): List<SpecieListItem> {
        val species = specieRemote.fetchSpecies()

        return species.map { specie ->
            val image = storageRemote.getSpecieImageUrl(specie.id)
            SpecieListItem(
                id = specie.id,
                speciesName = specie.speciesName,
                status = specie.status,
                imageUrl = image
            )
        }
    }


    // IDを取得する関数
    suspend fun fetchSpecieId(id: String): Specie? = specieRemote.fetchSpecieId(id)


}