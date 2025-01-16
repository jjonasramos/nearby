package com.jonasramos.nearby.data.model.mock

import com.jonasramos.nearby.data.model.Rule

val mockRules = listOf(
    Rule(
        id = "123",
        description = "Disponível até 31/12/2024",
        marketId = "abc"
    ),
    Rule(
        id = "124",
        description = "Válido apenas para consumo no local",
        marketId = "abc"
    )
)