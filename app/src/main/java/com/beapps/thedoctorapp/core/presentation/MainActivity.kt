package com.beapps.thedoctorapp.core.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beapps.thedoctorapp.auth.presentation.login.LoginScreenRoot
import com.beapps.thedoctorapp.auth.presentation.login.LoginViewModel
import com.beapps.thedoctorapp.ui.theme.TheDoctorAppTheme
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheDoctorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val startDestination = remember {
                        if (Util.isUserLoggedIn()) Screen.HomeScreen.route else Screen.LoginScreen.route
                    }
                    NavHost(navController = navController, startDestination = startDestination) {
                        composable(Screen.LoginScreen.route) {
                            LoginScreenRoot(navController)
                        }
                        composable(Screen.RegisterScreen.route) {

                        }
                        composable(Screen.HomeScreen.route) {

                        }
                    }
                }
            }
        }
    }
}
