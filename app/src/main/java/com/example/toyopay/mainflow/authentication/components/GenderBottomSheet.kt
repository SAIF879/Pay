package com.example.toyopay.mainflow.authentication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GenderUi(genderIndex: MutableIntState, genderValue: MutableState<String>) {

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    val onValueChange:(Int)->Unit={
        genderValue.value=GenderTypes.entries[it - 1].title
    }

    GenerateFillUpBox(detailText = genderValue , placeHolder ="Gender" , trailingIcon = Icons.Default.ArrowForwardIos, enabled = false){
        showBottomSheet = true
    }

    GenderBottomSheetSelector(selectedOption = genderIndex.intValue,
        onStateChange = {
            onValueChange(it)
            showBottomSheet = !showBottomSheet
        },
        showBottomSheet = showBottomSheet,
        onDismissRequest = {
            showBottomSheet = !showBottomSheet
        })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderBottomSheetSelector(
    selectedOption: Gender,
    onStateChange: (Gender) -> Unit,
    onDismissRequest: () -> Unit = {},
    showBottomSheet: Boolean = false
) {
    AppModalBottomSheet(
        sheetVisible = showBottomSheet,
        onDismissRequest = onDismissRequest) {
        GenderSelector(selectedOption = selectedOption,
            onStateChange = onStateChange)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppModalBottomSheet(
    sheetVisible: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = appRememberModalBottomSheetState(),
    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,
    shape: Shape = BottomSheetDefaults.ExpandedShape,
    containerColor: Color = BottomSheetDefaults.ContainerColor,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = BottomSheetDefaults.Elevation,
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    dragHandle: @Composable() (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    windowInsets: WindowInsets = WindowInsets.navigationBars,
    properties: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties(),
    content: @Composable() (ColumnScope.() -> Unit)
) {
    if (sheetVisible) {

        val context = LocalContext.current
        var isKeyboardOpen by remember { mutableStateOf(false) }
        val ime = WindowInsets.ime
        val navbar = WindowInsets.navigationBars
        val localDensity = LocalDensity.current

        LaunchedEffect(localDensity.density) {
            snapshotFlow { ime.getBottom(localDensity) - navbar.getBottom(localDensity) }
                .collect {
                    val currentKeyboardHeightDp = (it / localDensity.density).dp
                    isKeyboardOpen = currentKeyboardHeightDp > 0.dp
                }
        }

        ModalBottomSheet(
            modifier = modifier
                .fillMaxWidth() //Adjust if needed (e.g., .fillMaxHeight(0.8f))
                .navigationBarsPadding()
                .imePadding(),
            sheetState = sheetState,
            onDismissRequest = onDismissRequest,
            dragHandle = dragHandle,
            sheetMaxWidth = sheetMaxWidth,
            shape = shape,
            contentColor = contentColor,
            tonalElevation = tonalElevation,
            scrimColor = scrimColor,
            properties = properties,
            windowInsets = windowInsets.add(WindowInsets.ime),
            content = content
        )
    }
}

@Composable
fun GenderSelector(
    selectedOption: Gender,
    onStateChange: (Gender) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "GENDER",
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GenderTypes.entries.forEachIndexed { idx, genderTypes ->
                ScrollableItems(
                    name = GenderTypes.entries[idx].name, index = GenderTypes.entries[idx].gender,
                    checked = selectedOption ==  GenderTypes.entries[idx].gender,
                    onIndexChange = onStateChange
                )
            }

        }
    }
}

typealias Gender = Int

enum class GenderTypes(val gender: Gender, val title: String) {
    MALE(1, "Male"),
    FEMALE(2, "Female"),
    OTHER(3, "Other")
}
@Composable
fun ScrollableItems(
    name: String,
    checked: Boolean = false,
    index: Int,
    onIndexChange: (Int) -> Unit
) {
    ElevatedCard(
        onClick = { onIndexChange(index) },
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = name)
            if (checked) {
                Icon(
                    imageVector = Icons.Default.Check, contentDescription = null
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun appRememberModalBottomSheetState(
    skipPartiallyExpanded: Boolean = false,
    confirmValueChange: (SheetValue) -> Boolean = { true }
): SheetState {
    return rememberModalBottomSheetState(
        skipPartiallyExpanded,
        confirmValueChange
    )
}

