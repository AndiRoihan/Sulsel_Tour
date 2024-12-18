package com.example.sulseltour.ui.screen.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sulseltour.data.OnboardingModel
import com.example.sulseltour.ui.component.ButtonUi
import com.example.sulseltour.ui.component.IndicatorUI
import com.example.sulseltour.ui.component.OnboardingGraphUI
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val pages = listOf(
        OnboardingModel.FirstPage, OnboardingModel.SecondPage, OnboardingModel.ThirdPages
    )
    val pagerState = rememberPagerState(initialPage = 0) { pages.size }
    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                2 -> listOf("Back", "Start")
                else -> listOf("", "")
            }
        }
    }
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(state = pagerState) { index ->
            OnboardingGraphUI(onboardingModel = pages[index])
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (buttonState.value[0].isNotEmpty()) {
                        ButtonUi(
                            text = buttonState.value[0],
                            backgroundColor = Color.Transparent,
                            textColor = Color.Gray
                        ) {
                            scope.launch {
                                if (pagerState.currentPage > 0) {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    IndicatorUI(pageSize = pages.size, currentPage = pagerState.currentPage)
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    ButtonUi(
                        text = buttonState.value[1],
                        backgroundColor = Color.Black,
                        textColor = MaterialTheme.colorScheme.onPrimary
                    ) {
                        scope.launch {
                            if (pagerState.currentPage < pages.size - 1) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            } else {
                                navController.navigate("Login") {
                                    popUpTo("Onboarding") { inclusive = true }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview(showBackground = true)
fun OnboardingScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController() // NavController palsu untuk preview
        OnboardingScreen(navController = navController)
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun OnboardingScreenPreview() {
//    OnboardingScreen {
//
//    }
//}