package com.mhs.jetpetcomposebeginner1.ui.Main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhs.jetpetcomposebeginner1.R
import com.mhs.jetpetcomposebeginner1.model.User
import com.mhs.jetpetcomposebeginner1.model.dumpData
import com.mhs.jetpetcomposebeginner1.ui.theme.JetpetComposeBeginner1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpetComposeBeginner1Theme {
                Surface(color = MaterialTheme.colors.background) {
                    RecyclerView(dumpData())
                }
            }
        }
    }
    @Composable
    fun EachRow(user: User){
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
         //   backgroundColor = Color(Color.White),
            elevation = 2.dp,
        ){
            Row(modifier = Modifier.padding(4.dp)) {
                Image(painter = painterResource(id = R.drawable.dwm_feat) ,
                    contentDescription ="image",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(80.dp)
                        .scale(1.0f, 1.0f)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(10.dp))
                    )
                Column(modifier = Modifier.padding(4.dp)) {
                    Text(text = user.description,modifier = Modifier.padding(5.dp),
                    color = Color.Red,
                    fontSize = 18.sp)
                    Text(text = "James",modifier = Modifier.padding(5.dp))
                }


            }
        }
    }

    @Composable
    fun RecyclerView(data:List<User>){
        LazyColumn{
            items(data){user->
              EachRow(user = user)
            }
        }
    }
}