package com.midterm.anythingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.midterm.anythingapp.ui.theme.AnythingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnythingAppTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = { TopBar()},
                    bottomBar = { BottomNavigation(navController = navController)}
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Music.route) {
            MusicScreen()
        }
        composable(NavigationItem.Movie.route) {
            MovieScreen()
        }
        composable(NavigationItem.Books.route) {
            BooksScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
        composable(NavigationItem.Tip.route) {
            TipScreen()
        }
        composable(NavigationItem.Portfolio.route) {
            PortfolioScreen()
        }
        composable(NavigationItem.Tap.route) {
            TapScreen()
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        contentColor = Color.White,
        backgroundColor = colorResource(R.color.colorPrimary)
    ) {

    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    var items = listOf(
        NavigationItem.Home,
        NavigationItem.Tip,
        NavigationItem.Tap,
        NavigationItem.Books,
        NavigationItem.Portfolio,
    )

    BottomNavigation(
        contentColor = Color.White,
        backgroundColor = colorResource(id = R.color.colorPrimary)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(painter = painterResource(id = item.icon), contentDescription = item.title)},
                    selected = item.route == currentRoute,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState=true
                            }
                            launchSingleTop=true
                            restoreState=true
                        }
                    },
                    label = { Text(text = item.title) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(.4f),
                    alwaysShowLabel = true)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnythingAppTheme {
    }
}