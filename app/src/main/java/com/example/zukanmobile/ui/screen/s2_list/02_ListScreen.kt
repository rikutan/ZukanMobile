package com.example.zukanmobile.ui.screen.s2_list

import android.R.attr.name
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zukanmobile.R
import com.example.zukanmobile.ui.components.ModelItem
import com.example.zukanmobile.ui.components.SearchTopBar
import com.example.zukanmobile.ui.theme.DeepTealBlue

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    onClickItem: (String) -> Unit,
    vm: ListViewModel = hiltViewModel()
) {
    // ViewModelから取得 ----------------------------------------------------------------------------
    val species by vm.species.collectAsState()
    // ---------------------------------------------------------------------------------------------

    val focusManager = LocalFocusManager.current
    var text by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        vm.loadSpecies()
    }


    Scaffold(
        topBar = {
            SearchTopBar(query = text, onValueChange = { text = it }, onClear = { text = "" })
        },
        containerColor = DeepTealBlue, modifier = Modifier.clickable(
            onClick = { focusManager.clearFocus() },
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        )
    ) { paddingValues ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {

            items(species) { item ->
                ModelItem(
                    model = item.imageUrl ?: "",
                    id = item.id,
                    name = item.speciesName
                ) { onClickItem(item.id) }
            }

        }
    }
}

@Preview
@Composable
private fun
        ListScreenPreview() {
    ListScreen(onClickItem = {})
}