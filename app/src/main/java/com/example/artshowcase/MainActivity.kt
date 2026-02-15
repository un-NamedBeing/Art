package com.example.artshowcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artshowcase.ui.theme.ArtShowCaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtShowCaseTheme {
                Scaffold (Modifier.fillMaxSize()) {innerPadding->
                    ArtApp(
                        DataSource().loadData(),
                        Modifier
                            .fillMaxSize()
                            .padding(horizontal = 18.dp)
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun ArtApp(
    pageList: List<Page>,
    modifier: Modifier= Modifier
){
    val listLastIndex =pageList.size-1
    var currentIndex by remember { mutableIntStateOf(0) }
    Box(modifier) {
        Column(
            Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtImage(
                pageList[currentIndex].image,
                )
            Spacer(Modifier.height(32.dp))
            DescriptionOfImage(
                pageList[currentIndex].description0,
                pageList[currentIndex].name,
                pageList[currentIndex].date,
                Modifier.fillMaxWidth()
            )


        }
        ButtonRow(
            {
                if(currentIndex>0){
                    currentIndex--
                }
            },
            {
                if(currentIndex< listLastIndex){
                    currentIndex++
                }
            },
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
        )
    }
}

@Composable
fun ArtImage(
    @DrawableRes image:Int,
    modifier: Modifier= Modifier
){
    Surface(
        modifier.border(width = 16.dp,Color.White),
//        tonalElevation = 30.dp,//test with these two pro
        shadowElevation = 30.dp,//make surface appear as it is placed on top background

    ) {
        Image(
            painterResource(image),
            null,
            Modifier.size(height =  280.dp, width =260.dp),
            contentScale = ContentScale.Crop
        )

    }
}
@Composable
fun DescriptionOfImage(
    @StringRes des0: Int,
    @StringRes name:Int,
    @StringRes date:Int,
    modifier: Modifier= Modifier
){
    Surface(
        modifier,
        tonalElevation = 20.dp,
//        shadowElevation = 20.dp,


    ) {
        Column(
            Modifier.padding(18.dp)

        ) {

            Text(
                stringResource(des0),
                fontWeight = FontWeight.Light,
                fontSize = 24.sp

            )
            Row() {
                Text(
                    stringResource(name)+" ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp
                )
                Text(
                    stringResource(date),
                    fontWeight = FontWeight.Light,
                    fontSize = 10.sp
                )
            }

        }
    }
}
@Composable
fun ButtonRow(
    onClick0:()-> Unit,
    onClick1:()-> Unit,
    modifier: Modifier
){
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),

    ){

            Button(
                onClick0,
                Modifier.weight(1f)

            ) {
                Text(stringResource(R.string.previous))
            }
            Button(
                onClick1,
                Modifier.weight(1f)



            ) {
                Text(stringResource(R.string.next),


                )
            }

    }
}


@Preview(showBackground = true)
@Composable
fun ArtPreview() {
    ArtShowCaseTheme {
        ArtApp( DataSource().loadData(),
            Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp)
        )
    }
}