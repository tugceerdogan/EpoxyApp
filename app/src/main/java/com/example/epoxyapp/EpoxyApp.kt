package com.example.epoxyapp

import android.app.Application
import com.airbnb.epoxy.Carousel
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EpoxyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }
}