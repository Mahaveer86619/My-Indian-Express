package com.se7en.myindianexpress.screens.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.se7en.myindianexpress.screens.MyDimensions.IndicatorSize
import com.se7en.myindianexpress.ui.theme.BlueGray

@Composable
fun PageIndicator(
    modifier: Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = BlueGray
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(
                        color = if (page == selectedPage) selectedColor else unselectedColor
                    )
            )
        }

    }

}