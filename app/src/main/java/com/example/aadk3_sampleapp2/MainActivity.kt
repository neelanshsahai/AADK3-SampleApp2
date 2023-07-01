package com.example.aadk3_sampleapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aadk3_sampleapp2.ui.theme.AADK3SampleApp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Declare our entire UI
            AADK3SampleApp2Theme {
                // Add my UI Components
                List()
            }
        }
    }
}

@Composable
fun List() {
    Column {
        ListItem(content = "ABC")
        ListItem(content = "MNO")
        ListItem(content = "XYZ")
    }
}

// TODO 1: How to add Margin in Compose
// TODO 2: Arrangements vs Alignments in Rows and Columns
// We add a state variable
// After which the Composable keeps an Eye on that State, and whenever the state is changed
// The composable is refreshed / recreated. This is known as Recomposition
@Composable
fun ListItem(
    content: String
) {
    // State Variable (Remember and MutableState)
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding = if (isExpanded) 56.dp else 0.dp
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(Companion.Blue)
            .padding(16.dp)
            .padding(extraPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = content,
            color = Companion.White,
            fontSize = if (isExpanded) 36.sp else 18.sp
        )
        Button(onClick = {
            isExpanded = !isExpanded
        }) {
            Text(text = if (isExpanded) "Show Less" else "Show More")
        }
    }
}

// A composable is the new View (which we used earlier, viz. TextView -> Text, Button -> Button,
// LinearLayout -> Rows and Columns, RelativeLayout -> Box and so on)

//@Composable
//fun WelcomeScreen(
//    backgroundColor: Color
//) {
//    Column(
//        modifier = Modifier
//            .background(color = backgroundColor)
//            .fillMaxWidth()
//    ) {
//        Text(
//            text = "Hello World!",
//            color = Companion.Magenta,
//            fontSize = 18.sp,
//            fontStyle = FontStyle.Italic
//        )
//        Text(
//            text = "Geeks For Geeks",
//            color = Companion.DarkGray,
//            fontSize = 22.sp,
//            fontStyle = FontStyle.Normal
//        )
//        Text(
//            text = "AADK 3",
//            color = Companion.Black,
//            fontSize = 36.sp,
//            fontFamily = FontFamily.Monospace
//        )
//    }
//}
//
@Preview
@Composable
fun MainScreenPreview() {
    AADK3SampleApp2Theme {
        List()
    }
}

/*

List
 |
ListItem <-
 |
Column
 |
Button
 |
Text <-

*/
