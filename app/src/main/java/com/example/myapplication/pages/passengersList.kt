import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.models.Gender
import com.example.myapplication.models.Passenger

@Composable
fun PassengersPage(
    navController: NavHostController,
    passengers: ArrayList<Passenger>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .background(Color.Black)
    ) {
        item {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(horizontal = 32.dp),
            )
        }
        items(passengers) { passenger ->
            PassengersCard(
                passenger = passenger,
                passengers = passengers,
                navController = navController,
                modifier = modifier.padding(6.dp)
            )
        }
        item {
            Column {
                Button(
                    onClick = {
                        navController.navigate("addPassenger/new")
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .padding(8.dp)
                ) {
                    Text("افزودن مسافر")
                }
            }

        }
    }
}

@SuppressLint("NewApi")
@Composable
fun PassengersCard(
    passenger: Passenger,
    passengers: ArrayList<Passenger>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val gender: String = if (passenger.gender == Gender.MALE) {
        "مرد"
    } else {
        "زن"
    }

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                        .background(
                            color = Color.Cyan,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = "نام:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = passenger.name,
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                        .background(
                            color = Color.Cyan,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = "جنسیت:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = gender,
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                        .background(
                            color = Color.Cyan,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = "تولد:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = passenger.birthDate,
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                        .background(
                            color = Color.Cyan,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = "کد ملی:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = passenger.nationalCode,
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(
                    onClick = {
                        navController.navigate("addPassenger/${passenger.nationalCode}")
                    },
                    modifier = Modifier.size(40.dp),
                    content = {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "Edit",
                            tint = Color.Blue
                        )
                    }
                )
                IconButton(
                    onClick = {
                        passengers.remove(passenger)
                        navController.navigate("passengersList")
                    },
                    modifier = Modifier.size(40.dp),
                    content = {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = Color.Red
                        )
                    }
                )
            }
        }
    }
}
