package ua.edu.lntu.cw_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw_2.ui.theme.IPZ_CW_2Theme

class MainActivity : ComponentActivity() {
    private var isSignedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (isSignedIn) {
                            SignedInContent()
                        } else {
                            SignIn(onSignIn = { email, password ->
                                isSignedIn = true
                            })
                        }
                    }
                }
            }
        }
    }

    private fun SignedInContent() {
        TODO("Not yet implemented")
    }
}

@Composable
fun SignIn(onSignIn: (String, String) -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSignInSuccess by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        Button(
            modifier = Modifier.padding(top = 30.dp),
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    isSignInSuccess = true
                    onSignIn(email, password)
                }
            }
        ) {
            Text("Sign In")
        }

        if (isSignInSuccess) {
            SignedInContent(email)
        }
    }
}



@Composable
fun SignedInContent(email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sign In success")
        Text("email: $email")
        Button(onClick = {  }) {
            Text("Sign Out")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IPZ_CW_2Theme {
        SignIn(onSignIn = { email, password ->
        })
    }
}