package com.example.bankingapp


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TelaPerfil(){

}


@Preview
@Composable
fun Cabecalho(){
    Card(
        colors = CardDefaults.cardColors(Color.LightGray),
        modifier = Modifier.height(100.dp).fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.padding(20.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            /*Surface(
                modifier = Modifier.size(50.dp, 50.dp),
                color = Color.Blue
            ){}*/

            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "",
                modifier = Modifier.size(40.dp),
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Text("Nome do Ser Humano", style = MaterialTheme.typography.headlineSmall)
                Text("Programador >.<", style = MaterialTheme.typography.bodySmall)
            }

        }

    }
}