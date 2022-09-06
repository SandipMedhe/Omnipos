package com.example.task.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.util.AppColor


@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    androidx.compose.material.Button(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(AppColor.buttonColor)
    ) {
        Text(text, fontSize = 20.sp, color = Color.White)

    }

}