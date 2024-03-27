package com.jjcr11.challengekosmos.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleOwner
import com.jjcr11.challengekosmos.model.Page
import com.jjcr11.challengekosmos.viewmodel.ListCharactersViewModel

@Composable
fun ListCharacters(
    viewModel: ListCharactersViewModel,
    context: LifecycleOwner,
) {
    val (page, setPage) = remember { mutableStateOf(Page(mutableListOf())) }
    viewModel.page.observe(context) {
        setPage(it)
    }
    viewModel.fetchPage()
    if (page.results.isEmpty()) {
        //Mientras se hace el fetch de los datos se muestra una pantalla de carga
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(page.results) { result ->
                Card(character = result)
            }
        }
    }
}