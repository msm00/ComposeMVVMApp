package com.msm.composemvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msm.composemvvmapp.model.User
import com.msm.composemvvmapp.ui.theme.ComposeMVVMAppTheme
import com.msm.composemvvmapp.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMVVMAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    viewModel: UserViewModel
) {
    val users by viewModel.user.observeAsState(User(name = "Hokyn", age = 18))

    Column(
        Modifier.padding(16.dp)
    ) {
        Text(text = "Name: ${users.name}")
        Text(text = "Age: ${users.age}")
        Button(
            onClick = { viewModel.updateUser(name = "Kokos", age = 25) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Update User")

        }
    }
}



@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    ComposeMVVMAppTheme {
        UserScreen(viewModel = UserViewModel())
    }
}