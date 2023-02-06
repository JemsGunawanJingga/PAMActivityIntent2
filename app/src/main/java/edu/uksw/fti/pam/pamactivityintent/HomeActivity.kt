package edu.uksw.fti.pam.pamactivityintent


import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pamactivityintent.ui.theme.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAMActivityIntentTheme {
                val painter = painterResource(id = R.drawable.laundry)
                val description = "1 KG Hanya 2k "
                val title = "1 KG Hanya 2k "
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                ) {

                    SearchInput()
                    ListItem()
                    ListItem2()
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {
                        ImageCard(
                            painter = painter,
                            contentDescription = description,
                            title = title
                        )
                    }
                    service()
                }
            }
        }
    }

}
    @Preview(showBackground = true)
    @Composable
    fun SearchInput() {
        TopAppBar(backgroundColor = Color.Green,
                modifier = Modifier
                    .height(100.dp)) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 15.dp, 15.dp, 0.dp)
                    .background(Color.Green)


            ) {
                Row(
                    modifier = Modifier.background(Color.White)

                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        shape = RoundedCornerShape(8.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon"
                            )
                        },
                    )
                }
                    val description = "user"
                Image(painter = painterResource(id = R.drawable.user),
                    contentDescription = description,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(0.dp, 5.dp, 0.dp, 0.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                    )
            }
        }
    }



@Composable
fun ImageCard (
    painter : Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)){
            Image(painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
                )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.Black), fontSize =  16.sp)
            }
        }

    }
}


@Composable
fun ListItem() {

    Row(
        modifier = Modifier
            .padding(50.dp, 20.dp, 50.dp, 0.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .padding(10.dp, 2.dp, 25.dp, 0.dp)
        ) {
            val description = "Pakaian"
            Image(painter = painterResource(id = R.drawable.vector),
                contentDescription = description,

                modifier = Modifier
                    .size(48.dp),

            )
            Text(text = "Pakaian",
                modifier = Modifier
                    .padding(0.dp, 50.dp)
            )
        }
        Card(
            modifier = Modifier
                .padding(25.dp, 2.dp, 25.dp, 0.dp)
        ) {
            val description = "Sepatu"

            Image(painter = painterResource(id = R.drawable.shoes),
                contentDescription = description,
                modifier = Modifier
                    .size(48.dp),
            )
            Text(text = "Sepatu",
                modifier = Modifier
                    .padding(0.dp, 50.dp)
            )
        }
        Card(
            modifier = Modifier
                .padding(25.dp, 2.dp, 10.dp, 0.dp),

        ) {
            val description= "Selimut"


            Image(painter = painterResource(id = R.drawable.blanket),
                contentDescription = description,
                modifier = Modifier
                    .size(48.dp),
            )
            Text(text = "Selimut",
                modifier = Modifier
                    .padding(0.dp, 50.dp)
            )
        }
    }

}

@Composable
fun ListItem2() {

    Row(
        modifier = Modifier
            .padding(50.dp, 0.dp, 50.dp, 0.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .padding(10.dp, 0.dp, 27.dp, 0.dp)
        ) {
            val description = "Bantal"

            Image(painter = painterResource(id = R.drawable.pillow),
                contentDescription = description,

                modifier = Modifier
                    .size(48.dp),

                )
            Text(text = "Bantal",
                modifier = Modifier
                    .padding(0.dp, 50.dp)
            )
        }
        Card(
            modifier = Modifier
                .padding(27.dp, 0.dp, 27.dp, 0.dp)
        ) {
            val description = "Handuk"

            Image(painter = painterResource(id = R.drawable.towel),
                contentDescription = description,
                modifier = Modifier
                    .size(48.dp),
            )
            Text(text = "Handuk",
                modifier = Modifier
                    .padding(0.dp, 50.dp)
            )
        }
        Card(
            modifier = Modifier
                .padding(25.dp, 0.dp, 10.dp, 0.dp),

            ) {
            val description= "Lainnya"


            Image(painter = painterResource(id = R.drawable.bold),
                contentDescription = description,
                modifier = Modifier
                    .size(48.dp),
            )
            Text(text = "Lainnya",
                modifier = Modifier
                    .padding(0.dp, 50.dp)
            )
        }
    }

}

@Composable
fun service() {
    Row(
        modifier = Modifier
            .padding(330.dp, 0.dp, 10.dp, 0.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .padding(10.dp)
        ) {
            val description = "service"
            Image(
                painter = painterResource(id = R.drawable.service),
                contentDescription = description,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                )
        }
    }
}


