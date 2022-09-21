package com.example.task.presentation.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String,
    isError:Boolean = false,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        isError =isError,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.Transparent,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor =Color.Gray,
            cursorColor = Color.Gray,
            placeholderColor = Color.LightGray
        ),
        maxLines = maxLine,
        shape = RoundedCornerShape(50.dp),

        label = { Text(text = label, color = Color.Gray) },
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()

        }),
        modifier = modifier
    )

}
