package com.example.sulseltour.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingGraphUI(onboardingModel: OnboardingModel) {
    Box(
        modifier = Modifier
            .fillMaxSize() // Layar penuh
    ) {
        // Gambar latar belakang dengan contentScale
        Image(
            painter = painterResource(id = onboardingModel.backgroundImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Konten onboarding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = onboardingModel.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                alignment = Alignment.Center
            )

            Spacer(modifier = Modifier.size(50.dp))

            Text(
                text = onboardingModel.title,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.size(15.dp))

            Text(
                text = onboardingModel.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.size(60.dp))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview1() {
    OnboardingGraphUI(OnboardingModel.FirstPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview2() {
    OnboardingGraphUI(OnboardingModel.SecondPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingGraphUIPreview3() {
    OnboardingGraphUI(OnboardingModel.ThirdPages)
}