package com.se7en.myindianexpress.screens.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.se7en.myindianexpress.screens.onboarding.MyDimentions.MediumPadding1
import com.se7en.myindianexpress.screens.onboarding.MyDimentions.MediumPadding2
import com.se7en.myindianexpress.screens.onboarding.Page
import com.se7en.myindianexpress.screens.onboarding.pages
import com.se7en.myindianexpress.ui.theme.MyIndianExpressTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier,
    page: Page
) {
    Column(
        modifier = modifier
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
                .size(400.dp),
            painter = painterResource(id = page.image),
            contentDescription = "On boarding Image",
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            text = page.title,
            modifier = Modifier
                .padding(horizontal = MediumPadding2),
            fontSize = 22.sp,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = page.description,
            modifier = Modifier
                .padding(horizontal = MediumPadding2, vertical = 12.dp),
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )

    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    MyIndianExpressTheme {
        OnBoardingPage(modifier = Modifier, page = pages[2])
    }
}