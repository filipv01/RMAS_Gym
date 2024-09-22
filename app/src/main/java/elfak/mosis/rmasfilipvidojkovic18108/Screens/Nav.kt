package elfak.mosis.rmasfilipvidojkovic18108.screens



import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import elfak.mosis.rmasfilipvidojkovic18108.MapsScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "login") {
        composable("login") { Login(navController) }
        composable("register") { Register(navController) }
        composable("main") { MainScreen(navController) }
        composable("map") { MapsScreen() }
        composable("add_object") { AddObjectScreen(navController) }
        composable("leaderboard") { LeaderboardScreen() }
    }
}
