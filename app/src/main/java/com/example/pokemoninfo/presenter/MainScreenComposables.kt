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
import com.example.pokemoninfo.R
import com.google.accompanist.coil.rememberCoilPainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScreenWithAppBar() {

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
            backgroundColor = Color.LightGray,
            navigationIcon = {
                IconWithActionToDrawer(scope = scope, scaffoldState = scaffoldState) },
        ) },
        drawerContent = { ContentForDrawer() },
        content = {
            HomeScreen()
        }
    )
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


@ExperimentalMaterialApi
@Preview(
    name = "Dark Theme",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewScreen() {
    ScreenWithAppBar()
}