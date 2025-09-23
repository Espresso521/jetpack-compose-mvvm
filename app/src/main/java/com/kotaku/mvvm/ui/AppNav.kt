package com.kotaku.mvvm.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.kotaku.mvvm.ui.screen.*
import com.kotaku.mvvm.vm.WordsViewModel

object Routes {
    const val Splash = "splash"
    const val Login = "login"
    const val Home = "home"
    const val Detail = "detail/{id}"
}

@Composable
fun AppNav(
    vm: WordsViewModel,
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
            arguments = listOf(navArgument("id"){ type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable
            DetailScreen(
                word = vm.getById(id),
                onToggleFavorite = { vm.toggleFavorite(id) }
            )
        }
    }
}