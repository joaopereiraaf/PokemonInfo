//package com.example.pokemoninfo.presenter
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.pokemoninfo.data.Pokemon
//import com.example.pokemoninfo.data.pokemons
//import com.example.pokemoninfo.ui.theme.fontItalic
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//
//@Composable
//fun ContentForDrawer(scope: CoroutineScope, scaffoldState: ScaffoldState) {
//    Surface(
//        modifier = Modifier
//            .padding(horizontal = 13.dp)
//            .padding(top = 25.dp)
//    ) {
//        Column() {
//            Row(
//                modifier = Modifier
//                    .padding(bottom = 15.dp),
//                verticalAlignment = Alignment.CenterVertically,
//            ) {
//                Column(modifier = Modifier.padding(start = 15.dp)) {
//                    Text(
//                        text = "List of pokemon",
//                        style = TextStyle(
//                            fontSize = 35.sp,
//                            fontFamily = fontItalic
//                        ),
//                    )
//                }
//                Column(
//                    horizontalAlignment = Alignment.End,
//                    modifier = Modifier.weight(1f)
//                ) {
//                    IconButton(
//                        onClick = { scope.launch { scaffoldState.drawerState.close() } },
//                    ) {
//                        Icon(
//                            imageVector = Icons.Filled.ArrowBack,
//                            contentDescription = "Back to Screen"
//                        )
//                    }
//                }
//            }
//            DrawerPokemon()
//        }
//    }
//}
//
//@Composable
//fun DrawerPokemon() {
//    LazyColumn (
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        items (pokemons) { pokemons->
//            CardsForPokemonDrawer(pokemons)
//        }
//    }
//}
//
//@Composable
//fun CardsForPokemonDrawer(pokemon: Pokemon) {
//
//    var selectedPokemon by remember {
//        mutableStateOf<Pokemon?>(null)
//    }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .clickable { selectedPokemon = pokemon },
//        elevation = 10.dp,
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//            Column() {
//                Image(
//                    painter = painterResource(id = pokemon.image!!),
//                    contentDescription = "${pokemon.name}",
//                    modifier = Modifier
//                        .size(90.dp)
//                        .padding(5.dp)
//                )
//            }
//            Column(
//                modifier = Modifier
//                    .padding(start = 10.dp)
//                    .fillMaxWidth(),
//            ) {
//                Text(
//                    text = pokemon.name!!,
//                    fontFamily = fontItalic,
//                    modifier = Modifier.padding(5.dp)
//                )
//            }
//        }
//    }
//}
//
//@ExperimentalMaterialApi
//@Preview(showBackground = true)
//@Composable
//fun PreviewPokemon() {
//    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
//    val scope = rememberCoroutineScope()
//    ContentForDrawer(scope = scope, scaffoldState = scaffoldState)
//}
//
//@ExperimentalMaterialApi
//@Preview(showBackground = true)
//@Composable
//fun PreviewDrawerPokemonList() {
//    DrawerPokemon()
//}
//
//@ExperimentalMaterialApi
//@Preview(showBackground = true)
//@Composable
//fun PreviewCardsForPokemons(){
//    CardsForPokemonDrawer(pokemon = pokemons[0])
//}