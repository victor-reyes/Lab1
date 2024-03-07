package com.example.lab1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab1.databinding.ActivityAboutBinding
import com.google.android.material.snackbar.Snackbar

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContactUs.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:") // Only email apps handle this.
                putExtra(Intent.EXTRA_EMAIL, arrayOf("info@barcelonafc.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Barcelona")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Snackbar.make(
                    binding.root,
                    "There is no email app on your phone",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}