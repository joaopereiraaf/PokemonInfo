package com.example.pokemoninfo.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemoninfo.R
import com.example.pokemoninfo.ui.theme.fontItalic
import com.google.accompanist.coil.rememberCoilPainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

sealed class DrawerScreens(val title: String) {
    object Home : DrawerScreens("Home")
    object Pokemon : DrawerScreens("Account")
    object Moves : DrawerScreens( "Help")
}

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.Pokemon,
    DrawerScreens.Moves
)

@Composable
fun ContentForDrawer() {
    PicForTopDrawer()
    Surface(
        modifier = Modifier
            .padding(horizontal = 13.dp)
            .padding(top = 25.dp)
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Pokemon Info",
                    style = TextStyle(
                        fontSize = 35.sp,
                        fontFamily = fontItalic
                    )
                )
            }
            Column() {
                screens.forEach{ screen ->
                    CardsForPokemonDrawer(screen.title)
                }
            }
        }
    }
}

@Composable
fun CardsForPokemonDrawer(str: String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column() {
                Image(
                    painter = painterResource(id = R.drawable.dotted),
                    contentDescription = "something here",
                    modifier = Modifier
                        .size(50.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = str,
                    fontFamily = fontItalic,
                )
            }
        }
    }
}

@Composable
fun PicForTopDrawer() {
    Image(
        painter = painterResource(id = R.drawable.eevee),
        contentDescription = "Some Image",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PreviewPokemon() {
    ContentForDrawer()
}

@Preview(showBackground = true)
@Composable
fun ShowPic() {
    PicForTopDrawer()
}