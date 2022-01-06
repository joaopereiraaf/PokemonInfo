package com.example.pokemoninfo.presenter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemoninfo.R

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun PokemonScreen(){
    val list = listOf("pokemon1", "pokemon2", "pokemon3", "pokemon4")
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = lightLightGray
    ) {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(150.dp),

            // content padding
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            content = {
                items(list.size) { pokemonName ->
                    Card(
                        modifier = Modifier
                            .padding(5.dp),
                        elevation = 8.dp,
                        shape = RoundedCornerShape(10.dp),
                        onClick = {  }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.eevee),
                                contentDescription = "pokemon",
                                modifier = Modifier.size(200.dp),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(12.dp),
                                contentAlignment = Alignment.BottomStart
                            )
                            {
                                Text(
                                    text = list[pokemonName],
                                    fontSize = 20.sp,
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun PokemonScreenPreview() {
    PokemonScreen()
}