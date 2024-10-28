package com.example.textedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.textedu.ui.theme.TextEduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextEduTheme {
                MarqueeText("Please subscribe and like")
            }
        }
    }
}

@Composable
fun BasicText(message: String){
    TextEduTheme {
        Surface (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = message,
                fontSize = 32.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                lineHeight = 50.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis //얼립시스라고 생략이라는 뜻입니다.
            )
        }
    }
}

@Composable
fun ShadowText(message: String){
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = message,
        fontSize = 24.sp,
        style = TextStyle(
            shadow = Shadow(
                color = Color.Blue,
                offset = offset,
                blurRadius = 3f //흐리게 처리되는 정도
            )
        )
    )
}

@Composable
fun MultipleText(message: String){
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(color = Color.Blue)
            ){
                append("H")
            }
            append("ello ")
            withStyle(
                style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)
            ){
                append("W")
            }
            append("orld")
        }
    )
}

@Composable
fun BrushText(message: String){
    Text(
        text = message,
        style = TextStyle(
            fontSize = 24.sp,
            brush = Brush.linearGradient(
                colors = listOf(Color.Cyan, Color.Yellow, Color.DarkGray),
            ),
            alpha = .5f
        )
    )
}

//마키(큰 천막)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MarqueeText(message: String){
    Column (
        modifier = Modifier.width(200.dp)
    ){
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier.basicMarquee()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BasicTextPreview() {
    TextEduTheme {
        BasicText("Hello World".repeat(10))
    }
}

@Preview(showBackground = true)
@Composable
fun ShadowTextPreview() {
    TextEduTheme {
        ShadowText("Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun MultipleTextPreview() {
    TextEduTheme {
        MultipleText("Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun BrushTextPreview() {
    TextEduTheme {
        BrushText("Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun MarqueePreview(){
    TextEduTheme {
        MarqueeText("Please subscribe and like")
    }
}