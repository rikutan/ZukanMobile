package com.example.zukanmobile.ui.screen.s2_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zukanmobile.ui.components.ModelItem
import com.example.zukanmobile.ui.components.PullToComponent
import com.example.zukanmobile.ui.components.SearchTopBar
import com.example.zukanmobile.ui.theme.DeepTealBlue

@Composable
fun ListScreen(
    onClickItem: (String) -> Unit,
    vm: ListViewModel = hiltViewModel()
) {
    // ViewModelから取得 ----------------------------------------------------------------------------
//    val species by vm.species.collectAsState()
    val query by vm.query.collectAsState()
    val list by vm.filteredSpecies.collectAsState(initial = emptyList())
    val isRefreshing by vm.isRefreshing.collectAsState()
    // ---------------------------------------------------------------------------------------------

    val focusManager = LocalFocusManager.current


    Scaffold(
        topBar = {
            SearchTopBar(
                query = query,
                onValueChange = { vm.onQueryChange(it) },
                onClear = vm::onQueryClear
            )
        },
        containerColor = DeepTealBlue,
        contentWindowInsets = WindowInsets(0),
        modifier = Modifier.clickable(
            onClick = { focusManager.clearFocus() },
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        )
    ) { paddingValues ->

        PullToComponent(
            modifier = Modifier
                .padding(paddingValues),
            isRefreshing = isRefreshing,
            onRefresh = vm::onRefresh
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)

            ) {

                items(list) { item ->
                    ModelItem(
                        model = item.imageUrl ?: "",
                        id = item.id,
                        name = item.speciesName
                    ) {
                        onClickItem(item.id)
                    }
                }

                item { Spacer(Modifier.height(32.dp)) }
            }
        }
    }
}

@Preview
@Composable
private fun ListScreenPreview() {
    ListScreen(onClickItem = {})
}