package com.example.footballmatches.presentation

import android.app.Application
import com.onesignal.OneSignal

class MatchApp : Application() {
    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.promptForPushNotifications()
    }

    companion object {
        private const val ONESIGNAL_APP_ID = "ba62102d-01c8-43ad-ad95-32fab8ae2759"
    }
}