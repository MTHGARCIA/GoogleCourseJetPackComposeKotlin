package com.example.taskmanagercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagercompose.ui.theme.TaskManagerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ){
                    taskImg(
                        text = stringResource(R.string.text_one),
                        textTwo = stringResource(R.string.text_two),
                    )
                }
            }
        }
    }
}




@Composable
fun taskText(text: String, textTwo: String, modifier : Modifier = Modifier) {

        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)


        )
        Text(
            text = textTwo,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,

        )
    }

@Composable
fun taskImg (text: String, textTwo: String, modifier : Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        Image(
            painter = image,
            contentDescription = null,
        )
        taskText(
            text = text,
            textTwo = textTwo,

        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerComposeTheme {
        taskImg(
            text = stringResource(R.string.text_one),
            textTwo = stringResource(R.string.text_two),
        )
    }
}

