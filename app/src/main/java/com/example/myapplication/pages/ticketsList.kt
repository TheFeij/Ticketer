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

@Composable
fun TicketsPage(navController: NavHostController, modifier: Modifier = Modifier) {
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
        items(loadTickets()) { ticket ->
            TicketsCard(
                ticket = ticket,
                modifier = modifier.padding(6.dp)
            )
        }
    }
}

@Composable
fun TicketsCard(ticket: Ticket, modifier: Modifier = Modifier) {
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
                        text = "مسافر:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall // You can adjust the style as needed
                    )
                    Text(
                        text = ticket.ownerId,
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
                        text = "شناسه بلیط:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall // You can adjust the style as needed
                    )
                    Text(
                        text = ticket.ticketId,
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
                        text = "مبدا:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall // You can adjust the style as needed
                    )
                    Text(
                        text = ticket.src,
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
                        text = "مقصد:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall // You can adjust the style as needed
                    )
                    Text(
                        text = ticket.dst,
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
                        text = "تاریخ حرکت:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall // You can adjust the style as needed
                    )
                    Text(
                        text = ticket.date,
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
                        text = "ساعت حرکت:",
                        modifier = modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall // You can adjust the style as needed
                    )
                    Text(
                        text = ticket.time,
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
                    onClick = { },
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


fun loadTickets(): List<Ticket> {
    return listOf<Ticket>(
        Ticket("تهران", "قم", "1402/09/14", "11:30", "co43380g", "ابوالفضل مرادی"),
        Ticket("تهران", "قم", "1402/09/14", "11:30", "co43380g", "ابوالفضل مرادی"),
        Ticket("تهران", "قم", "1402/09/14", "11:30", "co43380g", "ابوالفضل مرادی"),
        Ticket("تهران", "قم", "1402/09/14", "11:30", "co43380g", "ابوالفضل مرادی"),
    )
}

data class Ticket(
    val src: String,
    val dst: String,
    val date: String,
    val time: String,
    val ticketId: String,
    val ownerId: String,
)
