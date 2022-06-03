package id.co.rizki.binarch5

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var imageBinar : ImageView
    lateinit var btnLoad : Button
    lateinit var btnNext : Button
    lateinit var btnViewPager : Button

    private val TAG = "MainActivity"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: ")

        imageBinar = findViewById(R.id.iv_binar)
        btnLoad = findViewById(R.id.btn_load)
        btnNext = findViewById(R.id.btn_next)
        btnViewPager = findViewById(R.id.btn_view_pager)

        btnLoad.setOnClickListener {

            requestLocationPermission()
            // berfungsi untuk me-load gambar dari Url
            Glide.with(this)
                .load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
                .circleCrop() // optional, untuk membuat gambar jadi bulat
                .into(imageBinar)
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            intent.putExtra("DATA_NAMA_USER", "Sabrina Binar")
            intent.putExtra("DATA_UMUR_USER", 19)
//            intent.putExtra("DATA_GAJI_USER", 10000000f)
            startActivity(intent)
        }

        btnViewPager.setOnClickListener {
            startActivity(Intent(this, ViewPagerActivity::class.java))
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

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause: ")
        // save notes user yang belum kelar waktu pindah activity
    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: ")
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
    @RequiresApi(Build.VERSION_CODES.M)
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