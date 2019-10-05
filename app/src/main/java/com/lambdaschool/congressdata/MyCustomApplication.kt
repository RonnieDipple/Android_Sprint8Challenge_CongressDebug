package com.lambdaschool.congressdata

import android.app.Application
import android.content.Context

import androidx.core.content.ContextCompat.getSystemService
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher


class MyCustomApplication: Application (){

    lateinit var refWatcher: RefWatcher

    fun getRefWatcher(context: Context): RefWatcher {
        val application = context.getApplicationContext() as MyCustomApplication
        return application.refWatcher
    }

    override fun onCreate() {
        super.onCreate()
        refWatcher = LeakCanary.install(this)
    }


}