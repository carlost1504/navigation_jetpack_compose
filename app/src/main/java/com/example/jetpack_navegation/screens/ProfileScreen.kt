package com.example.jetpack_navegation.screens

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen (navController:NavController = rememberNavController(), email: String?="NO_EMAIL", pass: String?="NO_EMAIL"){
    Scaffold (modifier = Modifier.fillMaxSize(), 
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black //color para diferente caso  MaterialTheme.colorScheme.primaryContainer
                ), 
                title = { Text(text = email?:"NO_VALUE", color = Color.White) }
            )
        }
    ){ innerPaddig-> 
        Column(modifier = Modifier.padding(innerPaddig)) {
            Text(text = "Body del Scaffold")
        }
        
    }
}