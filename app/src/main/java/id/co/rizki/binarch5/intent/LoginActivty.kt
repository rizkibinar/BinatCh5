package id.co.rizki.binarch5.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import id.co.rizki.binarch5.R

class LoginActivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etNamaUser = findViewById<EditText>(R.id.et_nama_user)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            // ambil nama user dari edit text
            val namaUser = etNamaUser.text.toString()

            // buat object intent menuju HomeActivity
            val intentToMain = Intent(this, HomeActivity::class.java)

            // tambahkan nama user yang telah di input ke intent, dengan KEY/"RESI" DATA_NAMA_USER
            intentToMain.putExtra("DATA_NAMA_USER", namaUser)

            // pindah ke HomeActivity
            startActivity(intentToMain)

        }

    }
}