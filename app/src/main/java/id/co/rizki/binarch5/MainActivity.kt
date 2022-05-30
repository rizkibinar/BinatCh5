package id.co.rizki.binarch5

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var imageBinar : ImageView
    lateinit var btnLoad : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageBinar = findViewById(R.id.iv_binar)
        btnLoad = findViewById(R.id.btn_load)

        btnLoad.setOnClickListener {

            requestLocationPermission()
            // berfungsi untuk me-load gambar dari Url
            Glide.with(this)
                .load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
                .circleCrop() // optional, untuk membuat gambar jadi bulat
                .into(imageBinar)
        }

        // men-check apakah permission location sudah di allow atau belom
        val permissionLocationStatus = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)

        if(permissionLocationStatus == PackageManager.PERMISSION_GRANTED) {
            getLatLong()
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
        } else {
            requestLocationPermission()
            Toast.makeText(this, "Permission not Granted", Toast.LENGTH_SHORT).show()
        }

    }

    // kepanggil saat usernya klik allow/deny
    // berfungsi untuk merespon hasil klik user
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 201) {
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLatLong()
                Toast.makeText(this, "Permission Granted onRuntime", Toast.LENGTH_SHORT).show()
            } else {
                requestLocationPermission()
                Toast.makeText(this, "Permission Denied onRuntime", Toast.LENGTH_SHORT).show()
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    // fungsi tampilin prompt untuk minta permission ke user, hasilnya akan masuk ke onRequestPermissionsResult
    private fun requestLocationPermission() {
        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 201)
    }

    // fungsi untuk ambil LatLong/kordinat dari user (pastiin sudah dapat permission Location sebelum manggil fungsi ini)
    @SuppressLint("MissingPermission")
    private fun getLatLong() {

        val locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        Toast.makeText(
            this,
            "lat : ${location?.latitude} long : ${location?.longitude}",
            Toast.LENGTH_SHORT
        ).show()

    }
}