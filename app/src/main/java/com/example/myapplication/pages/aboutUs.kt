package com.example.myapplication.pages

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R

@Composable
fun AboutUsPage(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        item {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(horizontal = 32.dp),
            )
        }
        items(loadAboutUsTexts()) { aboutUs ->
            AboutUsCard(
                navController = navController,
                aboutUs = aboutUs,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AboutUsCard(navController: NavHostController, aboutUs: AboutUs, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .padding(horizontal = 8.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Text(
            text = LocalContext.current.getString(aboutUs.titleResourceId),
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = LocalContext.current.getString(aboutUs.textResourceId),
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

fun loadAboutUsTexts(): List<AboutUs> {
    return listOf<AboutUs>(
        AboutUs(R.string.AboutUsText1, R.string.AboutUsTitle1),
        AboutUs(R.string.AboutUsText2, R.string.AboutUsTitle2),
        AboutUs(R.string.AboutUsText3, R.string.AboutUsTitle3),
    )
}

data class AboutUs(
    @StringRes val textResourceId: Int,
    @StringRes val titleResourceId: Int
)
