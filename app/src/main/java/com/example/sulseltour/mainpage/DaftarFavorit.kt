package com.example.sulseltour.mainpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
fun DaftarFavorit() {
    // Simulasi data untuk daftar favorit
    val favoritList = listOf(
        FavoritItem(R.drawable.favorit_image1, "Wisata 1", "Deskripsi wisata 1", "Makassar"),
        FavoritItem(R.drawable.favorit_image2, "Wisata 2", "Deskripsi wisata 2", "Luwu"),
        FavoritItem(R.drawable.favorit_image3, "Wisata 3", "Deskripsi wisata 3", "Maros")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(favoritList.size) { index ->
            FavoritCard(item = favoritList[index])
        }
    }
}

@Composable
fun FavoritCard(item: FavoritItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp),
//        elevation = 4.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Gambar wisata dengan ikon favorit di pojok kanan atas
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = stringResource(id = R.string.favorite_image),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.icon_favorite),
                    contentDescription = stringResource(id = R.string.favorite_icon),
                    tint = Color.Red,
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                )
            }

            // Informasi wisata di bawah gambar
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_location),
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = item.location,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarFavoritPreview() {
    SulselTourTheme {
        DaftarFavorit()
    }
}

// Data class untuk item favorit
data class FavoritItem(
    val imageRes: Int,
    val title: String,
    val description: String,
    val location: String
)
