package com.example.jetpack_navegation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpack_navegation.screens.LoginScreen
import com.example.jetpack_navegation.screens.ProfileScreen
import com.example.jetpack_navegation.ui.theme.Jetpack_NavegationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_NavegationTheme {
                App()
            }
        }
    }
}


@Composable
fun App(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "login" ){
        composable("login"){LoginScreen(navController)}
        composable("profile/{email}/{pass}", arguments = listOf(
            navArgument("email"){type=NavType.StringType},
            navArgument("pass"){type=NavType.StringType}
        )){
            entry->
            val email= entry.arguments?.getString("email")
            val pass= entry.arguments?.getString("pass")
            ProfileScreen(navController, email, pass)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpack_NavegationTheme {
        App()
    }
}

@Preview
@Composable
fun LoginPreview(){
    Jetpack_NavegationTheme {
        LoginScreen()
    }
}

@Preview
@Composable
fun ProfilePreview(){
    Jetpack_NavegationTheme {
        ProfileScreen()
    }
}