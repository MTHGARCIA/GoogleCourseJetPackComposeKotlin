package com.example.businesscard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()
                ){
                    Screen()
            }
            }
        }
    }
}
@Composable
fun BoxTop (title: String, desc: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Image(
            painter = image,
            null,
            modifier = Modifier
                .background(Color(0xff073042))
                .size(120.dp)
                .padding(bottom = 8.dp)

        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            )
        Text(
            text = desc,
            textAlign = TextAlign.Center,
            color = Color(0xFF177848)
        )
    }



}

@Composable
fun BoxBottom(contact: String, socialMedia: String, mail: String, modifier: Modifier = Modifier){

    Column (

    ){

        Row {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = null,

                )
            Text(
                text = contact,
                modifier = modifier
                    .padding(start = 6.dp)
            )
        }

        Row {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = null,
            )

            Text(
                text = socialMedia,
                modifier = modifier
                    .padding(start = 6.dp)
            )
        }

        Row {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = null,
            )

            Text(
                text = mail,
                modifier = modifier
                    .padding(start = 6.dp)
            )
        }
    }
}

@Composable
fun Screen (modifier: Modifier = Modifier){

    Column (modifier = Modifier
        .background(Color(0xFFD2E8D4))
        .fillMaxSize()
        .padding(top = 250.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box (
            modifier = modifier
                .padding(16.dp)
                .weight(1f)

        ){
            BoxTop(
                title = "Matheus Garcia",
                desc = "Android Developer Extraodinaire",
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
        }
        Box (
            modifier = modifier
                .padding(top = 155.dp)
                .weight(1f)


        ) {
            BoxBottom(
                contact = "+55 (55) 9999-9999",
                socialMedia = "@mthgarcia",
                mail = "Mthgarcia012@gmail.com",
                modifier = Modifier
                    .align(Alignment.BottomCenter)

            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Screen()
    }
}