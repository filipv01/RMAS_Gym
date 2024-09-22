package elfak.mosis.rmasfilipvidojkovic18108

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import elfak.mosis.rmasfilipvidojkovic18108.ui.theme.RMASFilipVidojkovic18108Theme
import android.widget.TextView
import androidx.navigation.compose.rememberNavController
import elfak.mosis.rmasfilipvidojkovic18108.screens.NavGraph

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            RMASFilipVidojkovic18108Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }


    }
}
