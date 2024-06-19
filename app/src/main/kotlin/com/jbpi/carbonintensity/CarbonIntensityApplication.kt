package com.jbpi.carbonintensity

import android.app.Application
import com.jbpi.carbonintensity.network.di.getNetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CarbonIntensityApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val combinedModules = getMainModule().plus(getNetworkModule())

        startKoin{
            androidLogger()
            androidContext(this@CarbonIntensityApplication)
            modules(combinedModules)
        }
    }
}
