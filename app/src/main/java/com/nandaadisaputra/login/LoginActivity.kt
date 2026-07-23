package com.nandaadisaputra.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nandaadisaputra.login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPrefs: SharedPrefsHelper
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPrefs = SharedPrefsHelper(this)

        // CEK AUTO-LOGIN: Jika true, langsung pindah ke MainActivity
        if (sharedPrefs.isLoggedIn()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Tutup halaman login agar tidak bisa di-back
            return
        }

        //inisialisasi ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Menggunakan ViewBinding
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Validasi statis sederhana
            if (username == "admin" && password == "1234") {
                // Simpan sesi login
                sharedPrefs.setLoggedIn(true)

                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

                // Pindah ke halaman utama
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}