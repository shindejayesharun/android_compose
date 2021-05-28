package com.shindejayesharun.jetpack_compose.examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shindejayesharun.jetpack_compose.examples.ui.theme.Jetpack_composeTheme

/**
 * ComponentActivity is base activity of component building, this class extends with
 * androidx.core.app.ComponentActivity
 * with implemented ContextAware, LifecycleOwner, ViewModelStoreOwner,
 * HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner,
 * ActivityResultRegistryOwner, ActivityResultCaller
 */
class SimpleTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * this is replace of set content of xml file by setContentView(R.layout.activity_main)
         * by setContent you set this layout is parent of this activity
         */
        setContent {
            /**
             * jetpack theme used by them include color, shape, type
             */
            Jetpack_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting is composable function part of the activity and act as a widget
                    Greeting("Android")
                }
            }
        }
    }
}

/**
 * @Composable function is called within scope of the composable function
 * this contains textview with @param name as a parameter of function
 */
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

/**
 * This is best way to preview your layout without build code and waiting for gradle build and
 * emulator to setup them. Composable used used for transformation of application data to tree
 * or hierarchy,
 * composable preview not accept any parameter if you want to pass some data to preview within
 * composable you need to overlap composable function with another composable function
 */
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jetpack_composeTheme {
        Greeting("Android")
    }
}