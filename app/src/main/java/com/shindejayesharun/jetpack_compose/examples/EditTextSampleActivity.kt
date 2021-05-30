package com.shindejayesharun.jetpack_compose.examples

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shindejayesharun.jetpack_compose.examples.ui.theme.Jetpack_composeTheme


class EditTextSampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                simpleTextField()
                numberTextField()
                passwordTextField()
                searchTextField()
                labelPlaceholderTextField()
                leadingIconTextField()
                errorTextField()


            }
        }
    }
}

@Composable
fun simpleTextField() {
    Surface(Modifier.padding(16.dp)) {
        Text("This textfield is normal")
        var textValue = remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(value = textValue.value,
            onValueChange = {
                textValue.value = it
            })
        Divider()
    }
}

@Composable
fun numberTextField() {
    Surface(Modifier.padding(16.dp)) {
        //number keyboard textfield
        Text("Password textfield")
        var textValue = remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(value = textValue.value,
            //below line is used for keyboard type number
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { it ->
                textValue.value = it
            })
        Divider()
    }
}

@Composable
fun passwordTextField(){
    Surface(Modifier.padding(16.dp)) {
        //password textfield
        Text("Textfield Password")
        var textValue = remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(value = textValue.value,
            //below line is used for keyboard type password
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { it ->
                textValue.value = it
            })
        Divider()
    }
}

@Composable
fun searchTextField(){
    Surface(Modifier.padding(16.dp)) {
        //search keyboard
        Text("TextField on show search keyboard type and tap on search button keyboard hide")
        var textValue = remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(value = textValue.value,
            //below line is used for keyboard type search
            // Changing the imeAction allows you to change the primary icon of the keyboard which
            // is typically shown in the bottom right corner of the keyboard. Some examples of
            // ImeActions are search, send, done, go, etc.
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search.apply {
                    Log.d(
                        "search",
                        "--${textValue.value}"
                    )
                },
            ),
            // Update value of textValue with the latest value of the text field
            onValueChange = { it ->
                textValue.value = it
            }
        )
        Divider()
    }
}

@Composable
fun labelPlaceholderTextField(){
    Surface(Modifier.padding(16.dp)) {
        //label and placeholder
        Text("Textfield with label and placeholder")
        var textValue = remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(value = textValue.value,
            label = { Text("Please enter name") },
            placeholder = { Text("") },
            onValueChange = { it ->
                textValue.value = it
            }

        )
        Divider()
    }
}

@Composable
fun leadingIconTextField(){
    Surface(Modifier.padding(16.dp)) {
        //leading icon
        Text("Textfield with label , placeholder & leading icon")
        var textValue = remember {
            mutableStateOf(TextFieldValue())
        }
        TextField(value = textValue.value,
            label = { Text("Please enter mobile") },
            placeholder = { Text("+91") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Phone,
                    contentDescription = "phone"
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "Done"
                )
            },
            onValueChange = { it ->
                textValue.value = it
            }
        )
        Divider()
    }
}

@Composable
fun errorTextField(){
    Surface(Modifier.padding(16.dp)) {
        //error
        Text("Textfield with error show")
        var textValue = remember {
            mutableStateOf(TextFieldValue())
        }
        val isValidPhoneNumber = textValue.value.text.count() == 10
        TextField(
            value = textValue.value,
            label = { Text("Please enter mobile") },
            placeholder = { Text("+91") },
            trailingIcon = {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "Done"
                )
            },
            onValueChange = { it ->
                textValue.value = it
            },
            isError = !isValidPhoneNumber,


            )
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Jetpack_composeTheme {
        Column {
            simpleTextField()
            numberTextField()
            passwordTextField()
            searchTextField()
            labelPlaceholderTextField()
            leadingIconTextField()
            errorTextField()


        }
    }
}