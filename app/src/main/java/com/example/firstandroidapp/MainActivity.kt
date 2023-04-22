package com.example.firstandroidapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstandroidapp.ui.theme.FirstAndroidAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    lateinit var randomNumberText: TextView
    lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            FirstAndroidAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    Greeting("Android")
//                    GenerateRandomNumber()
//                }
//            }
//        }
        setContentView(R.layout.main_activity)

        randomNumberText = findViewById(R.id.randomNumberText)
        startButton = findViewById(R.id.startButton)
        startButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val random = Random(System.currentTimeMillis()) // создание экземпляра класса Random с начальным значением, основанным на текущем времени
                val randomNumber = random.nextInt(1, 101)
                randomNumberText.text = "$randomNumber"
            }
        })
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    FirstAndroidAppTheme {
//        Greeting("World")
        GenerateRandomNumber()
    }
}

@Composable
fun GenerateRandomNumber(modifier: Modifier = Modifier){
    val random = Random(System.currentTimeMillis()) // создание экземпляра класса Random с начальным значением, основанным на текущем времени
    val randomNumber = random.nextInt(1, 101)
    Text(
        text = "Generated random number = $randomNumber",
        modifier = modifier,
    )
}