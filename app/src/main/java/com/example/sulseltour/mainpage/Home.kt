package com.example.sulseltour.mainpage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sulseltour.R
import com.example.sulseltour.ui.theme.SulselTourTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

fun fetchUsername(onResult: (String?) -> Unit) {
    val auth = FirebaseAuth.getInstance()
    val firestore = FirebaseFirestore.getInstance()

    val userId = auth.currentUser?.uid
    if (userId != null) {
        firestore.collection("users").document(userId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val name = document.getString("name")
                    onResult(name)
                } else {
                    onResult(null)
                }
            }
            .addOnFailureListener {
                onResult(null)
            }
    } else {
        onResult(null)
    }
}

@Composable
fun Home() {
    val verticalScrollState = rememberLazyListState() // For vertical scrolling
    var search by remember { mutableStateOf("") }
    var activeButton by remember { mutableStateOf(1) }
    val buttons = listOf("Event", "Most Viewed", "Nearby")
    val eventList = listOf(
        EventItem(R.drawable.makasssarevent, "Makassar Event", "Makassar", "Start 24-09-2024", "End 27-09-2024"),
        EventItem(R.drawable.pantai_bira, "Bulukumba Event", "Bulukumba", "Start 10-10-2024", "End 12-10-2024"),
        EventItem(R.drawable.toraja_event, "Toraja Event", "Toraja", "Start 11-12-2024", "End 15-12-2024")
    )
    var username by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        fetchUsername { fetchedName ->
            username = fetchedName
            isLoading = false
        }
    }

    LazyColumn(
        state = verticalScrollState,
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "profile",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    if (isLoading) {
                        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                    } else {
                        Column {
                            Text(
                                text = "Hi ${username ?: "User"}",
                            )
                            Text(
                                text = "Good Afternoon",
                            )
                        }
                    }
                }
                Image(
                    painter = painterResource(R.drawable.notification),
                    contentDescription = "notification",
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier.size(30.dp)
                )
//                IconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterVertically).size(30.dp)) {
//                    Icon(
//                        painter = painterResource(R.drawable.notification),
//                        contentDescription = "notification",
//                        tint = MaterialTheme.colorScheme.primary
//                    )
//                }
            }

//            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                placeholder = {
                    Text( text= "Search destination") },
                shape = RoundedCornerShape(24.dp),
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedTextColor = Color.Black,
//                    unfocusedTextColor = Color.Black
//                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().height(32.dp).padding(horizontal = 24.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth().padding(start = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp) // Jarak antar tombol
            ) {
                items(buttons.size) { index ->
                    val buttonId = index + 1 // id tombol (1, 2, 3, ...)
                    OutlinedButton(
                        onClick = { activeButton = buttonId }, // Ubah state saat tombol diklik
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (activeButton == buttonId) Color.Black else Color.White // Warna tombol aktif dan tidak aktif
                        ),
                        modifier = Modifier
                            .padding(vertical = 8.dp).width(130.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = buttons[index],
                            fontSize = 12.sp,
                            color = if (activeButton == buttonId) Color.White else Color.Black // Warna teks tombol
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(start = 24.dp)
            ) {
                items(eventList) { event ->
                    EventItemCard(event)
                }
            }

            Spacer(modifier = Modifier.height((24.dp)))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
//                    .height(140.dp)
                    .padding(horizontal = 24.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(24.dp))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Categories",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable{}) {
//                            IconButton(onClick = {}) {
//                                Icon(
//                                    painter = painterResource(R.drawable.event_icon),
//                                    contentDescription = "event_icon",
////                                    tint = Color.White
//                                )
//                            }
                            Image(
                                painter = painterResource(R.drawable.event_icon),
                                contentDescription = "event_icon",
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Event",
                                fontSize = 12.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable{}) {
                            Image(
                                painter = painterResource(R.drawable.beach_icon),
                                contentDescription = "beach_icon",
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Beach",
                                fontSize = 12.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable{}) {
                            Image(
                                painter = painterResource(R.drawable.mountain_icon),
                                contentDescription = "montain_icon",
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Mountain",
                                fontSize = 12.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable{}) {
                            Image(
                                painter = painterResource(R.drawable.attraction_icon),
                                contentDescription = "attraction_icon",
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Attraction",
                                fontSize = 12.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable{}) {
                            Image(
                                painter = painterResource(R.drawable.cuisine_icon),
                                contentDescription = "cuisine_icon",
                                modifier = Modifier.size(50.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Cuisine",
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Destinations",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Show all",
                        color = Color.Gray,
                        modifier = Modifier.clickable{}
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Box {
                        Image(
                            painter = painterResource(R.drawable.pantai_losari),
                            contentDescription = "pantai_losari",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(width = 165.dp, height = 165.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                        IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
                            Icon(
                                painter = painterResource(R.drawable.favorite_icon),
                                contentDescription = "favorite_icon",
                                tint = Color.White
                            )
                        }
                        // Overlay Card
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .size(width = 135.dp, height = 60.dp)
                                .align(Alignment.BottomCenter)
                        ) {
                            Box(Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(id = R.drawable.pane),
                                    modifier = Modifier.fillMaxSize(),
                                    contentDescription = "pane",
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .padding(6.dp)
                                        .fillMaxSize()
                                ) {
                                    Text(
                                        text = "Pantai Losari",
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                    Row(modifier = Modifier.fillMaxSize()) {
                                        Row(
                                            verticalAlignment = Alignment.Bottom,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.location_icon),
                                                contentDescription = "location_icon",
                                                modifier = Modifier.padding(bottom = 2.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = "Makassar",
                                                color = Color.White,
                                                fontSize = 10.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Box {
                        Image(
                            painter = painterResource(R.drawable.puncak_rantemario),
                            contentDescription = "puncak_rantemario",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(width = 165.dp, height = 165.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                        IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
                            Icon(
                                painter = painterResource(R.drawable.favorite_icon),
                                contentDescription = "favorite_icon",
                                tint = Color.White
                            )
                        }
                        // Overlay Card
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .size(width = 135.dp, height = 60.dp)
                                .align(Alignment.BottomCenter)
                        ) {
                            Box(Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(id = R.drawable.pane),
                                    modifier = Modifier.fillMaxSize(),
                                    contentDescription = "pane",
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .padding(6.dp)
                                        .fillMaxSize()
                                ) {
                                    Text(
                                        text = "Puncak Rantemario",
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                    Row(modifier = Modifier.fillMaxSize()) {
                                        Row(
                                            verticalAlignment = Alignment.Bottom,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.location_icon),
                                                contentDescription = "location_icon",
                                                modifier = Modifier.padding(bottom = 2.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = "Luwu",
                                                color = Color.White,
                                                fontSize = 10.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Box {
                        Image(
                            painter = painterResource(R.drawable.taman_bantimurung),
                            contentDescription = "taman_bantimurung",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(width = 165.dp, height = 165.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                        IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
                            Icon(
                                painter = painterResource(R.drawable.favorite_icon),
                                contentDescription = "favorite_icon",
                                tint = Color.White
                            )
                        }
                        // Overlay Card
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .size(width = 135.dp, height = 60.dp)
                                .align(Alignment.BottomCenter)
                        ) {
                            Box(Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(id = R.drawable.pane),
                                    modifier = Modifier.fillMaxSize(),
                                    contentDescription = "pane",
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .padding(6.dp)
                                        .fillMaxSize()
                                ) {
                                    Text(
                                        text = "Pantai Losari",
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                    Row(modifier = Modifier.fillMaxSize()) {
                                        Row(
                                            verticalAlignment = Alignment.Bottom,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.location_icon),
                                                contentDescription = "location_icon",
                                                modifier = Modifier.padding(bottom = 2.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = "Maros",
                                                color = Color.White,
                                                fontSize = 10.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Box {
                        Image(
                            painter = painterResource(R.drawable.fort_rotterdam),
                            contentDescription = "fort_rotterdam",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(width = 165.dp, height = 165.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                        IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
                            Icon(
                                painter = painterResource(R.drawable.favorite_icon),
                                contentDescription = "favorite_icon",
                                tint = Color.White
                            )
                        }
                        // Overlay Card
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .size(width = 135.dp, height = 60.dp)
                                .align(Alignment.BottomCenter)
                        ) {
                            Box(Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(id = R.drawable.pane),
                                    modifier = Modifier.fillMaxSize(),
                                    contentDescription = "pane",
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .padding(6.dp)
                                        .fillMaxSize()
                                ) {
                                    Text(
                                        text = "Fort Rotterdam",
                                        color = Color.White,
                                        fontSize = 12.sp
                                    )
                                    Row(modifier = Modifier.fillMaxSize()) {
                                        Row(
                                            verticalAlignment = Alignment.Bottom,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.location_icon),
                                                contentDescription = "location_icon",
                                                modifier = Modifier.padding(bottom = 2.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = "Makassar",
                                                color = Color.White,
                                                fontSize = 10.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }


        }
    }
}


@Composable
fun EventItemCard(event: EventItem) {
    Box {
        // Main image
        Image(
            painter = painterResource(event.imageRes),
            contentDescription = event.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 240.dp, height = 360.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        IconButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd)) {
            Icon(
                painter = painterResource(R.drawable.favorite_icon),
                contentDescription = "favorite_icon",
                tint = Color.White
            )
        }
        // Overlay Card
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = Modifier
                .padding(bottom = 17.dp)
                .size(width = 200.dp, height = 90.dp)
                .align(Alignment.BottomCenter)
        ) {
            Box(Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.pane),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "pane",
                    contentScale = ContentScale.Crop
                )

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        text = event.title,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Row(modifier = Modifier.fillMaxSize()) {
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Image(
                                painter = painterResource(R.drawable.location_icon),
                                contentDescription = "location_icon",
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = event.location,
                                color = Color.White,
                                fontSize = 12.sp
                            )
                        }

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                text = event.startDate,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                            Text(
                                text = event.endDate,
                                color = Color.White,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SulselTourTheme {
        Home()
    }
}
