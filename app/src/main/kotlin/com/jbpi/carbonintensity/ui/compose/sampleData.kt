package com.jbpi.carbonintensity.ui.compose

import com.jbpi.carbonintensity.model.display.DisplayFuel
import com.jbpi.carbonintensity.model.display.DisplayIntensity
import com.jbpi.carbonintensity.model.display.DisplayRegion

internal fun getDisplayRegion() = DisplayRegion(
    name = "North Scotland",
    intensity = DisplayIntensity(
        index = "very low",
        forecast = "255"
    ),
    fuels = listOf(
        displayFuelBiomass,
        displayFuelCoal,
        displayFuelImports,
        displayFuelGas,
        displayFuelNuclear,
        displayFuelOther,
        displayFuelHydro,
        displayFuelSolar,
        displayFuelWind
    )
)

internal val displayFuelBiomass = DisplayFuel(
    name = "biomass",
    percentage = "0.0%"
)
internal val displayFuelCoal = DisplayFuel(
    name = "coal",
    percentage = "0.0%"
)
internal val displayFuelImports = DisplayFuel(
    name = "imports",
    percentage = "0.0%"
)
internal val displayFuelGas = DisplayFuel(
    name = "gas",
    percentage = "0.0%"
)
internal val displayFuelNuclear = DisplayFuel(
    name = "nuclear",
    percentage = "0.0%"
)
internal val displayFuelOther = DisplayFuel(
    name = "other",
    percentage = "0.0%"
)
internal val displayFuelHydro = DisplayFuel(
    name = "hydro",
    percentage = "15.8%"
)
internal val displayFuelSolar = DisplayFuel(
    name = "solar",
    percentage = "0.0%"
)
internal val displayFuelWind = DisplayFuel(
    name = "wind",
    percentage = "84.2%"
)
