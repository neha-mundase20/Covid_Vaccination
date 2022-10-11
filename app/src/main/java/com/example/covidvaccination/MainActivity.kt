package com.example.covidvaccination

import android.media.ImageReader.OnImageAvailableListener
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.covidvaccination.ui.theme.CovidVaccinationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CovidVaccinationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Vaccines()
                }
            }
        }
    }
}

@Composable
fun Vaccines() {
    var status by remember {
        mutableStateOf(1)
    }
    when (status) {
        1 -> Column(modifier = Modifier)
        {
            Box() {
                Image(
                    painter = painterResource(id = R.drawable._386938),
                    contentDescription = "main screen",
                    modifier = Modifier.fillMaxSize()
                )
                Spacer(modifier = Modifier.height(18.dp))
                Button(onClick = { status = 2 }, modifier = Modifier.padding(start=50.dp,top=500.dp)) {
                    Text(text = stringResource(id = R.string.button_name))
                }
            }
        }

            2-> dataList(loadData = dataSource().loadData(), modifier = Modifier)
        }
    }

@Composable
fun dataCard(d:VaccinationData,modifier: Modifier=Modifier){
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Column() {
            Image(painter = painterResource(id = d.imageId), contentDescription ="subscreens"
            ,modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop)
            Text(text = stringResource(id = d.stringResourceId)
                ,modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6)
        }
    }
}

@Composable
fun dataList(loadData:List<VaccinationData>,modifier: Modifier) {
    LazyColumn {
        items(loadData) { VaccinationData ->
            dataCard(VaccinationData)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CovidVaccinationTheme {
        Vaccines()
    }
}