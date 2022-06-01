package com.mhs.jetpetcomposebeginner1.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import com.mhs.jetpetcomposebeginner1.ui.Main.MainActivity
import com.mhs.jetpetcomposebeginner1.ui.theme.JetpetComposeBeginner1Theme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpetComposeBeginner1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // LoginScreen()
                    MyScreen()
                }
            }
        }
    }


    @Composable
    fun LoginScreen() {
        val userName = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome To My App!",
                color = Color.Blue,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 5.dp)
            )
            Text(
                text = "Login Page",
                color = Color.Blue,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 5.dp)
            )
            OutlinedTextField(
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = { FocusDirection.Down }
                ),
                value = userName.value, onValueChange = {
                    userName.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "person")
                },
                label = {
                    Text(text = "Username")
                },
                placeholder = {
                    Text(text = "Enter Username")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                singleLine = true,
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "info")
                },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Enter Password")
                },
                modifier = Modifier.fillMaxWidth(),

                )

            OutlinedButton(
                onClick = {
                    logged(userName = userName.value, password = password.value)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(60.dp)
            ) {
                Text(text = "Login")
            }
        }
    }

    @Composable
    fun MyScreen() {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val (text, setText) = remember { mutableStateOf("") }
            val (text1, setText1) = remember { mutableStateOf("") }
            MyTextField(label = "Enter Name", value = text, onValueChanged = setText)
            MyTextField(
                label = "Enter Password", visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                value = text1, onValueChanged = setText1,
            )
            Button(
                onClick = {
                    logged(userName = text, password = text1)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                enabled = text.isNotBlank() && text1.isNotBlank()
            ) {
                Text(text = "Submit")
            }
        }

    }

    fun logged(userName: String, password: String) {
        if (userName == "James" && password == "12345") {
            val navigate = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(navigate)
        } else
            Toast.makeText(this@LoginActivity, "Login Fail", Toast.LENGTH_SHORT).show()

    }

    @Composable
    fun MyTextField(
        label: String,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        value: String,
        onValueChanged: (String) -> Unit
    ) {

        OutlinedTextField(
            value = value, onValueChange = onValueChanged,
            label = { Text(text = label) },
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions


        )
    }
}