package com.example.pokemoninfo.presenter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.example.pokemoninfo.R

@ExperimentalFoundationApi
@Composable
fun PokemonScreen(){
    val list = (1..10).map { it.toString() }

    LazyVerticalGrid(
        cells = GridCells.Adaptive(100.dp),

        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size) { index ->
                Card(
                    backgroundColor = Color.Black,
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxWidth(),
                    elevation = 8.dp,
                ) {
                    Image(
                        painter = rememberCoilPainter(
                            request = R.drawable.eevee
                        ), contentDescription = "lol")
                    Text(
                        text = list[index],
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    )
}


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun PokemonScreenPreview() {
    PokemonScreen()
}