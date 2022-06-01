package com.mhs.jetpetcomposebeginner1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhs.jetpetcomposebeginner1.ui.theme.JetpetComposeBeginner1Theme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpetComposeBeginner1Theme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "Android")
                        },
                        navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Menu, contentDescription ="menu" )
                            }
                        },
                        actions = {
                            IconButton(onClick = {  }) {
                                Icon(Icons.Filled.Notifications, contentDescription ="noti" )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Search,contentDescription = "search")
                            }
                        })
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Add , contentDescription = "add")
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End
                ) {
                    Greeting("Hello World")
                    ShowSwitch()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "$name",
        color = MaterialTheme.colors.secondary
    )
}

@Preview(showBackground = true, name = "light mode")
@Preview(
    showBackground = true, name = "dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    JetpetComposeBeginner1Theme {
        Greeting("Android")
        ShowSwitch()
    }
}

@Composable
fun ShowSwitch(){
    val isChecked = remember {
        mutableStateOf(true)
    }
    Switch(checked = isChecked.value,
        onCheckedChange = {
                isChecked.value = it
        },
        modifier = Modifier.run {
            size(20.dp)
            padding(20.dp)
        }
    )
}