package com.jbpi.carbonintensity.model.display

import android.content.res.Resources
import com.jbpi.carbonintensity.R

internal class FuelPercentageFormatter(
    private val resources: Resources
) {
    fun format(percentage: Double): String =
        String.format(resources.getString(R.string.fuel_percentage_format), percentage)
}
