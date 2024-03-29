package com.se7en.myindianexpress.screens.onboarding

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.se7en.myindianexpress.navigation.Screen
import com.se7en.myindianexpress.presentation.commonUiComponents.NewsButton
import com.se7en.myindianexpress.presentation.commonUiComponents.NewsTextButton
import com.se7en.myindianexpress.screens.MyDimensions.MediumPadding2
import com.se7en.myindianexpress.screens.MyDimensions.PageIndicatorWidth
import com.se7en.myindianexpress.screens.onboarding.components.OnBoardingPage
import com.se7en.myindianexpress.screens.onboarding.components.PageIndicator
import com.se7en.myindianexpress.viewmodels.OnBoardingViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            val pagerState = rememberPagerState(initialPage = 0) {
                pages.size
            }

            val buttonState = remember {
                derivedStateOf {
                    when(pagerState.currentPage) {
                        0 -> listOf("", "Next")
                        1 -> listOf("Back", "Next")
                        2 -> listOf("Back", "Get Started")
                        else -> listOf("", "")
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                HorizontalPager(
                    modifier = Modifier.weight(20f),
                    state = pagerState
                ) { index ->

                    OnBoardingPage(modifier = Modifier, page = pages[index])

                }

                Spacer(modifier = Modifier.weight(0.5f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MediumPadding2)
                        .navigationBarsPadding(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    PageIndicator(
                        modifier = Modifier
                            .width(PageIndicatorWidth),
                        pageSize = pages.size,
                        selectedPage = pagerState.currentPage
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        val scope = rememberCoroutineScope()

                        if (buttonState.value[0].isNotEmpty()) {
                            NewsTextButton(
                                text = buttonState.value[0],
                                onClick = {
                                    scope.launch {
                                        pagerState.animateScrollToPage(
                                            page = pagerState.currentPage - 1
                                        )
                                    }
                                }
                            )
                        }
                        NewsButton(
                            text = buttonState.value[1],
                            onClick = {
                                scope.launch {
                                    if (pagerState.currentPage == 2) {

                                        Log.d("Dev", "Moving to Home Screen")

                                        onBoardingViewModel.saveOnBoardingState(completed = true)
                                        navController.popBackStack()
                                        navController.navigate(Screen.Home.route)

                                    } else {
                                        pagerState.animateScrollToPage(
                                            page = pagerState.currentPage + 1
                                        )
                                    }
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(0.5f))

            }
        }
    }

}