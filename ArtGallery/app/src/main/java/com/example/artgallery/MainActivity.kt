package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme


data class ArtistInfo(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val year : String
)
val artInfo = listOf(
    ArtistInfo(R.drawable.image11,"ubatua pier","ubatubanews","2022"),
    ArtistInfo(R.drawable.image22,"Beach of Portugues","NewPicture","2017"),
    ArtistInfo(R.drawable.image33,"Ubatuba City","DroneIM","2022"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                ScreenApp()

            }

        }
    }
}

@Composable
fun ScreenApp (

    modifier: Modifier = Modifier

){

    var currentStep by remember { mutableStateOf( 0) }

    val onPrevious = {
        currentStep = if (currentStep == 0 ) artInfo.lastIndex else currentStep  - 1
    }
    val onNext = {
        currentStep = if (currentStep == artInfo.lastIndex) 0 else currentStep + 1
    }

    val art = artInfo[currentStep]


    Box (modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ){
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            ShowTitle(art.title, art.artist, art.year)

            Spacer(modifier = Modifier.height(10.dp))

            ButtonNextPrev(onPreviousClick = onPrevious, onNextClick = onNext)
        }

    Column (modifier = Modifier
             .align(Alignment.Center)
             .padding(bottom = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ImagenPrev(art.imageRes,Modifier.weight(1f, fill = false))

     }
    }

}




@Composable
fun ImagenPrev (art: Int,
                modifier: Modifier = Modifier){
    Surface(
        color = Color.White,
        shadowElevation = 8.dp,
        modifier = modifier
            .widthIn(max = 400.dp)
            .fillMaxWidth()
    ){


        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        )

        {
            Image(
                painter = painterResource(art),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth()


            )
        }
    }
}
@Composable
fun ShowTitle (title: String,
               artist: String,
               year: String,
               modifier: Modifier = Modifier){

    Surface(
        color = Color(0xFFECEBF4),
        modifier = modifier
            .widthIn(max = 400.dp)
            .fillMaxWidth()
    ){


        Column (modifier = Modifier
            .padding(15.dp),
        )
            {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )



            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
            Text(
                text = artist,
                fontWeight = FontWeight.Light
            )

            Text(
                text = "($year)",
                fontWeight = FontWeight.Bold
            )
            }
        }
    }
}


@Composable
fun ButtonNextPrev(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
){


        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(0.9f)

        ) {

            Button(onClick = onPreviousClick) {
                Text(text = "Previous")
            }
            Button(onClick = onNextClick) {
                Text(text = "Next")
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        ScreenApp()
    }
}