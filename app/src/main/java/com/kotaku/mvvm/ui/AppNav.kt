package com.kotaku.mvvm.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kotaku.mvvm.ui.screen.DetailScreen
import com.kotaku.mvvm.ui.screen.HomeScreen
import com.kotaku.mvvm.ui.screen.LoginScreen
import com.kotaku.mvvm.ui.screen.SplashScreen
import com.kotaku.mvvm.vm.WordsViewModel

object Routes {
    const val Splash = "splash"
    const val Login = "login"
    const val Home = "home"
    const val Detail = "detail/{id}"
}

@Composable
fun AppNav(
    vm: WordsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Routes.Splash, modifier = modifier) {
        composable(Routes.Splash) {
            SplashScreen(
                onFinished = { isLoggedIn ->
                    nav.navigate(if (isLoggedIn) Routes.Home else Routes.Login) {
                        popUpTo(Routes.Splash) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.Login) {
            LoginScreen(
                onLoginSuccess = {
                    nav.navigate(Routes.Home) {
                        popUpTo(Routes.Login) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.Home) {
            HomeScreen(
                vm = vm,
                onOpenDetail = { id -> nav.navigate("detail/$id") }
            )
        }

        composable(
            route = Routes.Detail,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable
            val vm: WordsViewModel = hiltViewModel()
            val word by vm.wordFlow(id).collectAsState(initial = null)
            DetailScreen(
                word = word,
                onToggleFavorite = { vm.toggleFavorite(id) }
            )
        }
    }
}