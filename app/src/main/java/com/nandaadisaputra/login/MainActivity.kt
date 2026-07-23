package com.nandaadisaputra.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nandaadisaputra.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPrefs: SharedPrefsHelper
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inisialisasi ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = SharedPrefsHelper(this)
        //Menggunakan ViewBinding untuk tombol logout
        binding.btnLogout.setOnClickListener {
            // Hapus sesi login
            sharedPrefs.setLoggedIn(false)

            // Kembali ke halaman Login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Tutup MainActivity
        }
    }
}