package com.example.lab1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab1.databinding.ActivitySignInBinding
import com.google.android.material.snackbar.Snackbar

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val usersWithPassword = listOf("Messi" to "GOAT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSignIn.setOnClickListener {
            val name = binding.name.text.toString()
            val password = binding.password.text.toString()
            if (usersWithPassword.contains(name to password)) {
                val intent = Intent(this, LoggedInActivity::class.java)
                    .apply { putExtra("name", name) }
                startActivity(intent)
            } else {
                Snackbar.make(binding.btnSignIn, "Wrong username or password", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }
}