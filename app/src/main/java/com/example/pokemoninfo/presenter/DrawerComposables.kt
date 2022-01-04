package com.example.pokemoninfo.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokemoninfo.R
import com.example.pokemoninfo.ui.theme.fontItalic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ContentForDrawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
    PicForTopDrawer()
    Surface(
        modifier = Modifier
            .padding(horizontal = 13.dp)
            .padding(top = 25.dp)
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        Column() {
            Text(
                text = "Pokemon Info",
                style = TextStyle(
                    fontSize = 35.sp,
                    fontFamily = fontItalic
                )
            )

            screens.forEach { drawer ->
                Content(drawer = drawer, onDestinationClicked = {
                    navController.navigate(drawer.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route = route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                })
            }
        }
    }
}

@Composable
fun Content(drawer: DrawerScreens, onDestinationClicked: (DrawerScreens) -> Unit) {
    Column() {
        Card(
            elevation = 10.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clickable { onDestinationClicked(drawer) },
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
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = drawer.title,
                        fontFamily = fontItalic,
                    )
                }
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

@Preview(showBackground = true)
@Composable
fun LetsTry() {
    Content(drawer = DrawerScreens.Pokemon, onDestinationClicked = {})
}

@Preview(showBackground = true)
@Composable
fun ShowPic() {
    PicForTopDrawer()
}