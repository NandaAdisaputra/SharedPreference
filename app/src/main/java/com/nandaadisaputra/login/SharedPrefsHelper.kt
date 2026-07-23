package com.nandaadisaputra.login

import android.content.Context
import android.content.SharedPreferences

class SharedPrefsHelper(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)

    // Menyimpan status login (true/false)
    fun setLoggedIn(isLoggedIn: Boolean) {
        prefs.edit().putBoolean("IS_LOGGED_IN", isLoggedIn).apply()
    }

    // Mengecek apakah user sedang login
    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("IS_LOGGED_IN", false)
    }
}