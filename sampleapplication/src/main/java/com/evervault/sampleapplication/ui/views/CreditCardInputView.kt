package com.evervault.sampleapplication.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.evervault.sdk.input.model.PaymentCardData
import com.evervault.sdk.input.model.description

@Composable
fun CreditCardInputView(paymentCardInput: @Composable ((PaymentCardData) -> Unit) -> Unit) {
    var cardData by remember { mutableStateOf(PaymentCardData()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Payment card input", style = MaterialTheme.typography.headlineSmall)

        paymentCardInput.invoke {
            cardData = it
        }

        Text(text = "Payment card data", style = MaterialTheme.typography.headlineSmall)
        InfoBlock(label = "Card number:", value = cardData.card.number)
        InfoBlock(label = "CVC:", value = cardData.card.cvc)
        InfoBlock(label = "Card type:", value = cardData.card.type?.brand ?: "")
        InfoBlock(label = "Exp month:", value = cardData.card.expMonth)
        InfoBlock(label = "Exp year:", value = cardData.card.expYear)
        InfoBlock(label = "Is valid:", value = if (cardData.isValid) "Yes" else "No")
        InfoBlock(label = "Is potentially valid:", value = if (cardData.isPotentiallyValid) "Yes" else "No")

        if (cardData.error != null) {
            InfoBlock(label = "Error message:", value = cardData.error?.description ?: "")
        }
    }
}

@Composable
fun InfoBlock(label: String, value: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(text = label, fontWeight = FontWeight.Bold)
        Text(text = value)
    }
}
