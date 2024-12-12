package com.example.sulseltour.mainpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sulseltour.R
import com.example.sulseltour.ui.theme.SulselTourTheme


@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Informasi Tempat Wisata",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.image1), // Replace with your image
            contentDescription = "Featured Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )

        // Buttons Section
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* Navigate to Popular Destinations */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Destinasi Populer", color = MaterialTheme.colorScheme.primary)
            }

            Button(
                onClick = { /* Navigate to Nearby Locations */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Dekat Saya", color = MaterialTheme.colorScheme.primary)
            }
        }

        // Additional Information
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Jelajahi tempat wisata terbaik dan temukan keindahan tersembunyi di sekitar Anda.",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
//        elevation = 4.dp
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                // Gambar lokasi wisata
                Image(
                    painter = painterResource(id = R.drawable.image2),
                    contentDescription = stringResource(id = R.string.favorite_image),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                )

                // Informasi wisata
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "Wisata 1",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Luwu",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                // Gambar lokasi wisata
                Image(
                    painter = painterResource(id = R.drawable.image3),
                    contentDescription = stringResource(id = R.string.favorite_image),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                )

                // Informasi wisata
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "Wisata 2",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Maros",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(12.dp),
//        elevation = 4.dp
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                // Gambar lokasi wisata
                Image(
                    painter = painterResource(id = R.drawable.image4),
                    contentDescription = stringResource(id = R.string.favorite_image),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                )

                // Informasi wisata
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "Wisata 3",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Makassar",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        }

    }
}


@Preview
@Composable
fun HomePreview() {
    SulselTourTheme {
        Home()
    }
}