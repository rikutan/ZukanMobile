package com.example.zukanmobile.ui.screen.s2_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zukanmobile.firebase.repository.SpecieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repo: SpecieRepository
) : ViewModel() {

    // Specieのリストを保持する変数
    private val _species = MutableStateFlow<List<SpecieListItem>>(emptyList())
    val species = _species.asStateFlow()

    // ローディング状態を管理する変数
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    // 検索クエリ変数
    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()


    // ViewModel生成時に実行されるブロック
    init {
        loadSpecies()
//        loadSpeciesEx()
    }


    // 検索処理変数
    val filteredSpecies = combine(
        flow = _query,
        flow2 = _species
    ) { query, list ->
        if (query.isBlank()) {
            list
        } else {
            list.filter { specie ->
                specie.speciesName.contains(query, ignoreCase = true) ||
                        specie.id.contains(query, ignoreCase = true)
            }
        }
    }

    // 文字を入力するための関数
    fun onQueryChange(text: String) {
        _query.value = text
    }

    // 入力中の文字をクリアする関数
    fun onQueryClear() {
        _query.value = ""
    }

    // リストを更新する関数
    fun onRefresh() {
        loadSpecies()
    }


    // Specieコレクションから全件を取得する関数
    fun loadSpecies() {
        viewModelScope.launch {
            Log.d("02_ListViewModel", "ローディング開始")
            _isRefreshing.value = true

            Log.d("02_ListViewModel", "ローディング中")
            _species.value = repo.fetchSpecieListItems()


            Log.d("02_ListViewModel", "ローディング終了")
            _isRefreshing.value = false

        }
    }

//    // 番外編：data classにstateを持たせたリストとローディングの実装方法 =====================================
//    private val _uiState = MutableStateFlow(ListUiState())
//    val uiState = _uiState.asStateFlow()
//
//    fun loadSpeciesEx() {
//        viewModelScope.launch {
//            // 更新開始
//            _uiState.value = _uiState.value.copy(isRefreshing = true)
//
//            // データ取得
//            val list = repo.fetchSpecieListItems()
//
//            // 更新完了
//            _uiState.value = ListUiState(
//                items = list,
//                isRefreshing = false
//            )
//        }
//    }
}