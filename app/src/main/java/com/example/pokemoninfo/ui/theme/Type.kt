package com.example.pokemoninfo.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pokemoninfo.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val fontBlack = FontFamily(Font(R.font.lato_black))
val fontBold = FontFamily(Font(R.font.lato_bold, weight = FontWeight.Bold))
val fontThin = FontFamily(Font(R.font.lato_thin, weight = FontWeight.Thin))
val fontItalic = FontFamily(Font(R.font.lato_italic, weight = FontWeight.Normal, style = FontStyle.Italic))