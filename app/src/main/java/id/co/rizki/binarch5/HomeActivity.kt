package id.co.rizki.binarch5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val intentData = intent

        // tangkap data dari IntentActivity, dengan tipe data String dan KEY "DATA_NAMA_USER"
        val namaUser = intentData.getStringExtra("DATA_NAMA_USER")

        val txtWelcome = findViewById<TextView>(R.id.tv_welcome)

        txtWelcome.text = "Selamat datang $namaUser, selamat bermain"
    }
}