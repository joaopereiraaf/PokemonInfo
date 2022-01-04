package com.example.pokemoninfo.data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// icon to go back to main page
//
//Column(
//horizontalAlignment = Alignment.End,
//modifier = Modifier.weight(1f)
//) {
//    IconButton(
//        onClick = { scope.launch { scaffoldState.drawerState.close() } },
//    ) {
//        Icon(
//            imageVector = Icons.Filled.ArrowBack,
//            contentDescription = "Back to Screen"
//        )
//    }
//}

@Composable
fun BoxWithShadowOnBot() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    Color.Transparent,
                    Color.Black
                ),
                startY = 300f
            )
        )
    )
}