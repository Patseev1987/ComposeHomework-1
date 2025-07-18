package ru.otus.marketsample.ui.promo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.otus.marketsample.ViewModelFactory
import ru.otus.marketsample.promo.feature.PromoListViewModel

@Composable
fun PromoList(
    modifier: Modifier = Modifier,
    factory: ViewModelFactory
) {
    val viewModel: PromoListViewModel = viewModel(factory = factory)
    val state = viewModel.state.collectAsState().value
    Box(modifier = modifier) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(items = state.promoListState, key = { it.id }) { promoState ->
                PromoItem(
                    modifier = Modifier.fillMaxWidth(),
                    promoState = promoState,
                )
            }
        }
        if (state.isLoading)
            CircularProgressIndicator(
                modifier = Modifier.fillMaxSize()
            )
    }
}
