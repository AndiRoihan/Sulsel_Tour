package com.example.sulseltour.ui.screen.mainpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sulseltour.R
import com.example.sulseltour.ui.theme.SulselTourTheme

@Composable
fun Explore() {
    val exploreList = listOf(
        ExploreItem(R.drawable.image1, "Wisata 1", "Makassar"),
        ExploreItem(R.drawable.image2, "Wisata 2", "Luwu"),
        ExploreItem(R.drawable.image3, "Wisata 3", "Maros"),
        ExploreItem(R.drawable.image4, "Wisata 4", "Makassar"),
        ExploreItem(R.drawable.image5, "Wisata 5", "Bulukumba")
    )

    Column(modifier = Modifier.fillMaxSize()) {
        // Search bar di bagian atas halaman
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(
                text = "Explore",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                modifier = Modifier.align(Alignment.CenterStart)
            )
        }

        // Daftar gambar lokasi wisata
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(exploreList.size) { index ->
                ExploreCard(
                    imageRes = exploreList[index].imageRes,
                    title = exploreList[index].title,
                    location = exploreList[index].location
                )
            }
        }
    }
}

@Composable
fun ExploreCard(imageRes: Int, title: String, location: String) {
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
                painter = painterResource(id = imageRes),
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
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = location,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    SulselTourTheme {
        Explore()
    }
}

// Data class untuk setiap item Explore
data class ExploreItem(
    val imageRes: Int,
    val title: String,
    val location: String
)