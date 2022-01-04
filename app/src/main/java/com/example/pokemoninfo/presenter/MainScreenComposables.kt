package com.example.pokemoninfo.presenter

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemoninfo.R
import com.google.accompanist.coil.rememberCoilPainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScreenWithAppBar() {

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(
            title = { Text(
                text = "Pokemon App",
                color = Color.White
            ) },
            backgroundColor = Color.Black,
            navigationIcon = {
                IconWithActionToDrawer(scope = scope, scaffoldState = scaffoldState) },
        ) },
        drawerContent = {
            ContentForDrawer(scope = scope, scaffoldState = scaffoldState, navController = navController) },
    )
    {
        Navigation(navController = navController)
    }
}

@Composable
fun IconWithActionToDrawer(scope: CoroutineScope, scaffoldState: ScaffoldState) {
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
fun HomeScreen() {
    Image(
        painter = rememberCoilPainter(request = R.drawable.pikachu),
        contentDescription = "Home",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize(),
        )
}

@Composable
fun PokemonScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Pokemon Screen",
            fontSize = 50.sp,
        )
    }
}

@Composable
fun MovesScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Moves Screen",
            fontSize = 50.sp,
        )
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = DrawerScreens.Home.route) {
        composable(DrawerScreens.Home.route) {
            HomeScreen()
        }
        composable(DrawerScreens.Pokemon.route) {
            PokemonScreen()
        }
        composable(DrawerScreens.Moves.route) {
            MovesScreen()
        }
    }
}

@ExperimentalMaterialApi
@Preview(
    name = "Dark Theme",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)

//@Composable
//@Preview(showBackground = true)
//fun PreviewScreen() {
//    ScreenWithAppBar(DrawerScreens.Home)
//}

@Preview(showBackground = true)
@Composable
fun ShowPokemonScreen() {
    PokemonScreen()
}

@Preview(showBackground = true)
@Composable
fun ShowMovesScreen() {
    MovesScreen()
}