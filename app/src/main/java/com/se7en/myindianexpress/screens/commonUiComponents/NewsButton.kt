package com.se7en.myindianexpress.presentation.commonUiComponents

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.se7en.myindianexpress.ui.theme.MyIndianExpressTheme
import com.se7en.myindianexpress.ui.theme.WhiteGray

@Composable
fun NewsButton(
    text: String,
    onClick:() -> Unit
) {
    
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ) {
        
        Text(
            text = text,
            style = MaterialTheme.typography.button.copy(fontWeight = FontWeight.SemiBold)
        )
        
    }
    
}

@Composable
fun NewsTextButton(
    text: String,
    onClick:() -> Unit
) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.button.copy(fontWeight = FontWeight.SemiBold),
            color = WhiteGray
        )
    }
}

@Preview
@Composable
fun PreviewNewsButton() {
    
    MyIndianExpressTheme {
        NewsButton(text = "Next") {

        }
    }
    
}