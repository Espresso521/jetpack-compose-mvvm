// data/SessionManager.kt
package com.kotaku.mvvm.data

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    private val prefs: SharedPreferences
) {
    companion object {
        private const val KEY_LOGGED_IN = "logged_in"
        private const val KEY_LAST_ACTIVE = "last_active"
        private const val SESSION_TIMEOUT = 30 * 60 * 1000L // 30 分钟
    }

    fun setLoggedIn(loggedIn: Boolean) {
        prefs.edit { putBoolean(KEY_LOGGED_IN, loggedIn) }
        if (loggedIn) {
            updateLastActive()
        }
    }

    fun isLoggedIn(): Boolean {
        val loggedIn = prefs.getBoolean(KEY_LOGGED_IN, false)
        if (!loggedIn) return false

        val lastActive = prefs.getLong(KEY_LAST_ACTIVE, 0)
        val now = System.currentTimeMillis()
        return if (now - lastActive > SESSION_TIMEOUT) {
            clear()
            false
        } else {
            true
        }
    }

    fun updateLastActive() {
        prefs.edit { putLong(KEY_LAST_ACTIVE, System.currentTimeMillis()) }
    }

    fun clear() {
        prefs.edit { clear() }
    }
}