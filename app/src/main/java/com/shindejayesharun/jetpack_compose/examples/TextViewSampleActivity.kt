package com.shindejayesharun.jetpack_compose.examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shindejayesharun.jetpack_compose.examples.ui.theme.Jetpack_composeTheme

class TextViewSampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextViewExampleComposable()
        }
    }
}

@Composable
fun TextViewExampleComposable() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        //simple text with Hello world
        Text(text = "This is default text style")

        //TextStyle allows you to specify styling configuration for a `Text`
        Text(
            "This text is in blue color",
            style = TextStyle(color = Color.Blue)
        )

        Text("This is has 30sp text size", style = TextStyle(fontSize = 30.sp))

        Text("This text is bold", style = TextStyle(fontWeight = FontWeight.Bold))

        Text("This text is italic", style = TextStyle(fontStyle = FontStyle.Italic))

        Text(
            "This text is using cursive font family",
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )

        Text(
            "This text has an underline",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )

        Text(
            "This text has an text through line",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )

        Text(
            "This text is an overflow eclipse so that so automatic resize of them on maximum content greater than one line",
            overflow = TextOverflow.Ellipsis, maxLines = 1
        )

        Text(
            "This text has an shadow", style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    blurRadius = 10F,
                    offset = Offset(0.5F, 1F)
                )
            )
        )

        Text(
            "This text is example of justify property so that required more content and that paragraph is justify from start or left.",
            textAlign = TextAlign.Justify
        )

        Text(
            "This text is example of justify left property so that required more content and that paragraph is justify left and paragraph first line space on lef side by textIndent 30.sp .",
            textAlign = TextAlign.Justify,
            style = TextStyle(
                textIndent = TextIndent(firstLine = 30.sp)
            )
        )

        Text(
            "This text is example of justify center property so that required more content and that paragraph is justify center .",
            textAlign = TextAlign.Center
        )

        Text(
            "This paragraph on line spacing modified to 20.sp so that space between line will be increased check that on this paragraph",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
        )

        Text(buildAnnotatedString {
            append("This text is span annotated String ")
            addStyle(style = SpanStyle(color = Color.Red),start = 0,end = 3)
            addStyle(style = SpanStyle(color = Color.Yellow),start = 4,end = 8)
            addStyle(style = SpanStyle(color = Color.Green),start = 9,end = 13)
            addStyle(style = SpanStyle(color = Color.Red),start = 14,end = 20)
        })

        Surface(color = Color.Yellow) {
            Text("This text is surface yellow example")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    TextViewExampleComposable()
}