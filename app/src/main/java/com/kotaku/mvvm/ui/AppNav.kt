package com.kotaku.mvvm.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kotaku.mvvm.model.Word
import com.kotaku.mvvm.ui.icons.IconCatalog
import com.kotaku.mvvm.ui.screen.DetailMedia
import com.kotaku.mvvm.ui.screen.DetailScreen
import com.kotaku.mvvm.ui.screen.HomeScreen
import com.kotaku.mvvm.ui.screen.LoginScreen
import com.kotaku.mvvm.ui.screen.SplashScreen
import com.kotaku.mvvm.ui.screen.WordDetailPagerScreen
import com.kotaku.mvvm.vm.HomeViewModel
import com.kotaku.mvvm.vm.WordsViewModel

object Routes {
    const val Splash = "splash"
    const val Login = "login"
    const val Home = "home"
    const val Detail = "detail"
    const val DetailPager = "detailpager"
    fun detail(id: Int) = "$Detail/$id"
}

@Composable
fun AppNav(
    wordsVm: WordsViewModel = hiltViewModel(),
    homeVm: HomeViewModel = hiltViewModel(),
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
            LaunchedEffect(Unit) {
                homeVm.events.collect { ev ->
                    when (ev) {
                        HomeViewModel.Event.Logout -> {
                            nav.navigate(Routes.Login) {
                                popUpTo(Routes.Home) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    }
                }
            }

            HomeScreen(
                wordsVm = wordsVm,
                // 打开详情页：跳转路由并携带 id
                onOpenDetail = { id ->
                    nav.navigate("${Routes.DetailPager}/$id")
                },
                // 登出：清理登录态并回到登录页
                onLogout = { homeVm.logout() },
                iconsOnly = false    // 底部栏仅显示图标
            )
        }

        composable(
            route = "${Routes.Detail}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable
            val word by wordsVm.wordFlow(id).collectAsState(initial = null)
            val media = word?.let { w ->
                IconCatalog.wordMediaMap[w.term.lowercase()]?.detail
            }
            DetailScreen(
                word = word,
                onBack = { nav.popBackStack() },
                onToggleFavorite = { wordsVm.toggleFavorite(id) },
                media = media
            )
        }

        composable(
            route = "${Routes.DetailPager}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable

            // 拿到全量 words（用你的 ViewModel）
            val allWords by wordsVm.words.collectAsState(initial = emptyList())

            // 你的 wordIconMap 映射器（示例：全部给默认 Rive，后面你再按词目替换）
            val mediaFor: (Word) -> DetailMedia? = { word ->
                IconCatalog.wordMediaMap[word.term.lowercase()]?.detail
            }

            WordDetailPagerScreen(
                words = allWords,
                initialWordId = id,
                onBack = { nav.popBackStack() },
                onToggleFavorite = { wordsVm.toggleFavorite(it) },
                mediaFor = mediaFor
            )
        }
    }
}