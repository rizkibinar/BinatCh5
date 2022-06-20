package id.co.rizki.binarch5.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import id.co.rizki.binarch5.R
import id.co.rizki.binarch5.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentData = intent

        // tangkap data dari IntentActivity, dengan tipe data String dan KEY "DATA_NAMA_USER"
        val namaUser = intentData.getStringExtra("DATA_NAMA_USER")


        binding.tvWelcome.text = "Selamat datang $namaUser, selamat bermain"


        binding.btnShare.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Ayo mainkan game suit dari saya $namaUser")
                type = "text/plain"
            }

            startActivity(intent)
        }

    }
}