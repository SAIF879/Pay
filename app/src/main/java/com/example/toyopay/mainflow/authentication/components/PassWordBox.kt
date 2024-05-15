package com.example.toyopay.mainflow.authentication.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDatePicker(
    openDialog: Boolean,
    onDismiss: () -> Unit,
    onDone: (localDate: LocalDate?) -> Unit
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli(),
        initialDisplayMode = DisplayMode.Picker,
    )
    if (openDialog) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false
            )
        ) {
            Card(
                Modifier
                    .padding(20.dp)
            ) {
                Column (Modifier.padding(bottom =20.dp)){
                    DatePicker(
                        state = datePickerState,
                        title = {
//                            HeadlineTexts.Medium(text = "Hello")
                        }
//                        modifier = Modifier.padding(horizontal = AppTheme.spacing.level2)
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {
                        Button(onClick = {
                            onDone(getLocalDateFromMillis(datePickerState.selectedDateMillis))
                            onDismiss()
                        }) {
                           Text(text = "Confirm")
                        }
                    }
                }
            }
        }
    }
}

fun getLocalDateFromMillis(millis: Long?): LocalDate? {
    val instant = Instant.ofEpochMilli(millis ?: 0)
    return instant.atZone(ZoneId.systemDefault()).toLocalDate()
}


@Composable
fun ClickableTextBox(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    leadingIcon: ImageVector,
    showDescription: Boolean = false,
    descriptionText: String = "",
    isValid: Boolean = false,
    isMandatory: Boolean = false,
    trailingIcon: ImageVector? = Icons.Default.Edit,
    onClick: (() -> Unit)? = null,
) {

    val colors = listOf(
        Color(0xFF007EEC), // Blue
        Color(0xFF0B9B8A), // Green
        Color(0xFFA71666), // Pink shades
        Color(0xFF315098), // Light Blue
        Color(0xFF96B23C), // Green shades
        Color(0xFF9B6F89), // Purple shades
        // Add more colors as needed
    )
    val randomColor = colors.random()

    Card(
        modifier = modifier.clickable {
                                      onClick?.invoke()
        },
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    if (isValid) {
                        drawLine(
                            color = Color(0xFF315098),
                            start = Offset(16f, size.width),
                            end = Offset(16f, size.height),
                            strokeWidth = 30f
                        )
                    } else if (isMandatory) {
                        drawLine(
                            color = Color.Red,
                            start = Offset(16f, size.width),
                            end = Offset(16f, size.height),
                            strokeWidth = 30f
                        )
                    }
                },
            verticalAlignment = Alignment.CenterVertically
        ) {}
        Row(
            modifier = Modifier
                .padding(20.dp)
                .height(IntrinsicSize.Max),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Icon(imageVector = leadingIcon , contentDescription = null)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Text(
                    text = label,
                    maxLines = 1
                )
                Text(
                    text = value,
                    maxLines = 1
                )
                if (showDescription) {
                    Text(
                        text = descriptionText,
                        style = TextStyle(textMotion = TextMotion.Animated)
                    )
                }
            }
            trailingIcon?.let {
                    Icon(imageVector = trailingIcon , contentDescription = null )
            }
        }
    }
}

