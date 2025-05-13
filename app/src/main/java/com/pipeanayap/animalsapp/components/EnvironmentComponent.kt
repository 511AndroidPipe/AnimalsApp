package com.pipeanayap.animalsapp.components

import com.pipeanayap.animalsapp.models.Environment

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.pipeanayap.animalsapp.R
import com.pipeanayap.animalsapp.models.Animal

@Composable
fun EnvironmentComponent( environment: Environment, onClick : (Environment) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
            .clickable { onClick(environment) },
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        AsyncImage(
            model =  environment.image,
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error =  painterResource(R.drawable.no_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(175.dp)
                .clip(CircleShape)
        )

        Text(
            text = environment.name.split(" ").first(),
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
    }
}