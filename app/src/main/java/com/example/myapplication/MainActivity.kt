package com.example.myapplication

import com.example.myapplication.models.*
import PassengersPage
import TicketsPage
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.models.Gender
import com.example.myapplication.pages.*

class MainActivity : ComponentActivity() {
    private var passengers = ArrayList<Passenger>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create our initial passengers
        passengers.add(
            Passenger("ابوالفضل مرادی فیجانی", "0520389721", Gender.MALE, "1380/01/14"),
        )
        passengers.add(
            Passenger("ابوالفضل مرادی فیجانی", "0520389721", Gender.MALE, "1380/01/14"),
        )
        passengers.add(
            Passenger("ابوالفضل مرادی فیجانی", "0520389721", Gender.MALE, "1380/01/14"),
        )

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "startup"
            ) {
                composable("startup") {
                    StartupPage(navController)
                }
                composable("signup") {
                    SignupPage(navController)
                }
                composable("login") {
                    LogInPage(navController)
                }
                composable("followUp") {
                    FollowUp(navController)
                }
                composable("aboutUs") {
                    AboutUsPage(navController)
                }
                composable("passengersList") {
                    PassengersPage(navController, passengers)
                }
                composable("addPassenger/{id}") {backStackEntry ->
                    val passengerId = backStackEntry.arguments?.getString("id")
                    val passenger = passengers.find { it.nationalCode == passengerId }

                    AddPassengerPage(navController, passengers, passenger)
                }
                composable("reserve") {
                    TicketReservationPage(navController)
                }
                composable("home") {
                    HomePage(navController)
                }
                composable("charge") {
                    ChargePage(navController)
                }
                composable("ticketsList") {
                    TicketsPage(navController)
                }
            }
        }
    }
}
