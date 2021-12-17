package com.example.pokemoninfo.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemoninfo.data.pokemons
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.example.pokemoninfo.data.Pokemon
import com.example.pokemoninfo.ui.theme.fontItalic
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun ScreenWithAppBar() {

    //hardcoded
    val pokemon = pokemons

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val materialBlue= Color(0xFF1976D2)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(
            title = { Text(
                text = "Pokemon App",
                color = Color.White
            ) },
            backgroundColor = materialBlue,
            navigationIcon = {
                IconWithClickAction(
                    scope = scope, scaffoldState = scaffoldState
                ) },
        ) },
        drawerContent = { ContentForDrawer(
            scope = scope,
            scaffoldState = scaffoldState
        ) },
        content = {
            ShowAPokemon(pokemon = pokemon[5])
        }
    )
}

@Composable
fun IconWithClickAction(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    IconButton(
        modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
        onClick = { scope.launch { scaffoldState.drawerState.open() } },
    ) {
        Icon(imageVector = Icons.Default.Menu,
            contentDescription = "Drawer",
            tint = Color.White,
        )
    }
}

@Composable
fun ShowAPokemon(pokemon: Pokemon) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Column(
            modifier = Modifier.wrapContentSize()
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = pokemon.name!!,
                    fontFamily = fontItalic,
                    style = TextStyle(fontSize = 25.sp),
                )
            }
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = pokemon.image!!),
                    contentDescription = "${pokemon.name}",
                    modifier = Modifier
                        .size(300.dp)
                )
            }
            ContentOfMainScreen(pokemon = pokemon)
        }
    }
}

@Composable
fun ContentOfMainScreen(pokemon: Pokemon) {

    val rememberState = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(rememberState)
    ) {
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Description: ")
                    }
                    append(pokemon.description!!)
                }
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Type: ")
                    }
                    val pokemonType = pokemon.typeOfPokemon.toString().substring(1, length - 1)
                    append(pokemonType)
                },
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Category: ")
                    }
                    append(pokemon.category!!)
                }
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("HP: ")
                    }
                    append(pokemon.hp!!.toString())
                }
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Attack: ")
                    }
                    append(pokemon.attack!!.toString())
                }
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Defense: ")
                    }
                    append(pokemon.defense!!.toString())
                }
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Special Attack: ")
                    }
                    append(pokemon.specialAttack!!.toString())
                }
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Special Defense: ")
                    }
                    append(pokemon.specialDefense!!.toString())
                }
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Speed: ")
                    }
                    append(pokemon.speed!!.toString())
                }
            )
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Total: ")
                    }
                    append(pokemon.total!!.toString())
                }
            )
        }
    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    ScreenWithAppBar()
}