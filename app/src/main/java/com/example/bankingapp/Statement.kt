package com.example.bankingapp

import android.os.Bundle
import com.example.bankingapp.components.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.ui.theme.BankingAppTheme

data class Transaction(
    val date: String,
    val description: String,
    val amount: String
)

@Composable
fun StatementScreen() {
    val context = LocalContext.current
    val profile = remember { loadProfile(context) }

    val transactions = listOf(
        Transaction("24 OCT", "Anerkeyo Maestro", "- R$ 29,61"),
        Transaction("18 OCT", "Starting Maestro", "- R$ 19,81"),
        Transaction("18 OCT", "GutEare", "- R$ 259,87"),
        Transaction("16 OCT", "Paypal", "- R$ 204,27"),
        Transaction("16 OCT", "Masto card", "- R$ 147,27"),
        Transaction("14 OCT", "Benkcontact", "- R$ 29,61")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        //Header(title = "Bank Statement", onIconClick = {}, actions = {
        //    IconButton(onClick = { /* ação da lupa */ }) {
        //        Icon(
        //            imageVector = Icons.Default.Search,
        //            contentDescription = "Search",
        //            tint = Color.White
        //        )
        //    }
        //})

        // Spacer(modifier = Modifier.height(8.dp))

        // Card com saldo e usuário
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("${profile.firstName} ${profile.lastName}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(profile.email, fontSize = 14.sp, color = Color.Gray)
                }
                Text("R$ 293,42", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFF1976D2))
            }
        }

        // Lista de transações
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(transactions) { transaction ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(transaction.date, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                        Text(transaction.description, color = Color.Gray, fontSize = 14.sp)
                    }
                    Text(transaction.amount, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                }
                HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
            }
        }

        // Spacer(modifier = Modifier.weight(1f))

        // NavBar()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStatementScreen() {
    StatementScreen()
}
