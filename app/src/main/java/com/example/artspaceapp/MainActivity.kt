package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtImageWithTitle(
    imageResource: Int,
    titleAlbumResource: String,
    nameResource: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = imageResource), contentDescription = titleAlbumResource,
            modifier = modifier
                .padding(20.dp)
                .border(BorderStroke(1.dp, Color.Gray), RectangleShape)
                .height(350.dp)
                .width(300.dp)
                .shadow(4.dp, shape = RectangleShape)
        )

        Card(modifier = modifier.padding(horizontal = 20.dp, vertical = 80.dp)) {
            Column(modifier = modifier.padding(16.dp)) {

                Text(
                    text = titleAlbumResource,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = nameResource,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }

    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var item by remember { mutableStateOf(0) }

    when (item) {
        0 -> ArtImageWithTitle(
            imageResource = R.drawable.dom,
            titleAlbumResource = stringResource(R.string.dom),
            nameResource = stringResource(R.string.scrip_2015)
        )
        1 -> ArtImageWithTitle(
            imageResource = R.drawable.prazdnik,
            titleAlbumResource = stringResource(R.string.prazdnik),
            nameResource = stringResource(R.string.scrip_2017)
        )

        2 -> ArtImageWithTitle(
            imageResource = R.drawable.uroboros,
            titleAlbumResource = stringResource(R.string.uroboros),
            nameResource = stringResource(R.string.scrip_2018)
        )

        3 -> ArtImageWithTitle(
            imageResource = R.drawable._004,
            titleAlbumResource = stringResource(R.string.dva004),
            nameResource = stringResource(R.string.scrip_2019)
        )

        4 -> ArtImageWithTitle(
            imageResource = R.drawable.svist,
            titleAlbumResource = stringResource(R.string.svistki),
            nameResource = stringResource(R.string.scrip_2021)
        )

        5 -> item = 0
        -1 -> item = 4
    }

    Row(
        horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom,
        modifier = modifier.padding(bottom = 30.dp)
    ) {
        Button(onClick = { item-- }, modifier = modifier.padding(start = 30.dp, end = 50.dp)) {
            Text(
                text = stringResource(id = R.string.prv_btn),
                modifier = modifier.padding(horizontal = 10.dp)
            )
        }
        Button(onClick = { item++ }, modifier = modifier.padding(end = 30.dp)) {
            Text(text = stringResource(id = R.string.next_btn),
            modifier = modifier.padding(horizontal = 25.dp))

        }
    }
}





@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}