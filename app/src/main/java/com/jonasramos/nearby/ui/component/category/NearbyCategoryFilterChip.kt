package com.jonasramos.nearby.ui.component.category

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jonasramos.nearby.data.model.Category
import com.jonasramos.nearby.data.model.mock.mockCategories
import com.jonasramos.nearby.ui.theme.Gray300
import com.jonasramos.nearby.ui.theme.Gray400
import com.jonasramos.nearby.ui.theme.GreenBase
import com.jonasramos.nearby.ui.theme.Typography

@Composable
fun NearbyCategoryFilterChip(
    modifier: Modifier = Modifier,
    category: Category,
    isSelected: Boolean = false,
    onClick: (isSelected: Boolean) -> Unit
) {
    FilterChip(
        modifier = modifier
            .padding(2.dp)
            .heightIn(min = 36.dp),
        selected = isSelected,
        elevation = FilterChipDefaults.filterChipElevation(
            elevation = 8.dp
        ),
        leadingIcon = {
            category.icon?.let {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = it),
                    tint = if(isSelected) Color.White else Gray400,
                    contentDescription = "Icone de filtro de categoria"
                )
            }
        },
        border = FilterChipDefaults.filterChipBorder(
            enabled = false,
            selected = isSelected,
            disabledBorderColor = Gray300,
            borderWidth = 1.dp,
            selectedBorderWidth = 0.dp,
            selectedBorderColor = Color.Transparent
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            selectedContainerColor = GreenBase,
        ),
        onClick = { onClick(!isSelected) },
        label = {
            Text(
                text = category.name,
                style = Typography.bodyMedium,
                color = if (isSelected) Color.White else Gray400
            )
        }
    )
}

@Preview
@Composable
private fun NearbyCategoryFilterChipSelectedPreview() {
    NearbyCategoryFilterChip(
        onClick = {},
        category = mockCategories.first(),
        isSelected = true
    )
}

@Preview
@Composable
private fun NearbyCategoryFilterChipNotSelectedPreview() {
    NearbyCategoryFilterChip(
        onClick = {},
        category = mockCategories.first(),
        isSelected = false
    )
}