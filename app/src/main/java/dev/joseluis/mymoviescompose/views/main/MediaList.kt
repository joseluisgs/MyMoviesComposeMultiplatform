package dev.joseluis.mymoviescompose.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import dev.joseluis.mymoviescompose.R
import dev.joseluis.mymoviescompose.models.MediaItem
import dev.joseluis.mymoviescompose.models.getMediaItems
import dev.joseluis.mymoviescompose.views.shared.Thumb

@Composable
fun MediaList(
    onMediaClick: (MediaItem) -> Unit, // Devuelve un MediaItem
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)), // Variables  // GridCells.Fixed(2), // Celdas fijas
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getMediaItems()) { item ->
            MediaListItem(
                item = item,
                onClick = { onMediaClick(item) },
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall))
            )
        }
    }
}

@Composable
fun MediaListItem(
    item: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    // Card
    Card(
        modifier = modifier
            .clickable(onClick = onClick),
        //elevation = 0.dp,
        //shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_small))
        // border = BorderStroke(1.dp, Color.LightGray),
        // backgroundColor = MaterialTheme.colors.primary,
        // contentColor = MaterialTheme.colors.secondary
    ) {
        // Una columna
        Column {
            Thumb(item)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary)
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(
                    text = item.title,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = MaterialTheme.typography.h6.fontWeight,
                )
            }
        }
    }
}


@Preview
@Composable
fun MediaListPreview() {
    MediaList(onMediaClick = {})
}
