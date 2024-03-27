package com.jjcr11.challengekosmos.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jjcr11.challengekosmos.model.Character

@Composable
fun Card(character: Character) {
    val (detail, setDetail) = rememberSaveable { mutableStateOf(false) }
    val (buttonText, seButtonText) = remember { mutableStateOf("Ver detalle") }
    Column(
        modifier = Modifier
            .padding(top = 10.dp)
            .border(BorderStroke(2.dp, SolidColor(Color.Black)))
            .padding(start = 10.dp, end = 10.dp)

    ) {
        //La primera parte del componente muestra la imagen, nombre y boton para ver los detaller
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            AsyncImage(
                model = character.image,
                contentDescription = null,
            )
            Column(
                horizontalAlignment = Alignment.End,
            ) {
                Text(
                    text = character.name.take(12),
                    fontSize = 20.sp,
                    minLines = 2
                )
                Button(
                    onClick = {
                        val aux = detail
                        setDetail(!aux)
                        if (detail) seButtonText("Ver detalle") else seButtonText("Ocultar detalle")
                    }
                ) {
                    Text(text = buttonText)
                }

            }
        }
        //La segunda parte muestra los detalles con una aniacion fade
        AnimatedVisibility(
            visible = detail,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Column {
                DetailInfo(tag = "Status", info = character.status)
                DetailInfo(tag = "Species", info = character.species)
                DetailInfo(tag = "Type", info = character.type)
                DetailInfo(tag = "Gender", info = character.gender)
                DetailInfo(tag = "Origin", info = character.origin.name)
                DetailInfo(tag = "Location", info = character.location.name)
            }
        }
    }
}