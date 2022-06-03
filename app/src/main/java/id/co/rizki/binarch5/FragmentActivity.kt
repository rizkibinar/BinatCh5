package id.co.rizki.binarch5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        // code untuk bikin fragment
        val firstFragment = FirstFragment()

        // code untuk ambil fragment manager dari activity
        val fragmentManager = supportFragmentManager
        // code untuk ambil fragment transaction dari fragment manager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // code untuk pasang fragment ke ViewGroup yang kira mau
        fragmentTransaction.add(R.id.layout_fragment, firstFragment)
        // code untuk eksekusi perubahan
        fragmentTransaction.commit()

        val ivHome = findViewById<ImageView>(R.id.iv_home)
        val ivSearch = findViewById<ImageView>(R.id.iv_search)

        val intentDariMain = intent

        val namaDariMain = intentDariMain.getStringExtra("DATA_NAMA_USER")
        val umurDariMain = intentDariMain.getIntExtra("DATA_UMUR_USER", 0)
        val gajiDariMain = intentDariMain.getFloatExtra("DATA_GAJI_USER", 0f)

//        tangkap intent melalui bundle
//        val bundle = intentDariMain.extras

//        val namaDariMain = bundle?.getString("DATA_NAMA_USER")
//        val umurDariMain = bundle?.getInt("DATA_UMUR_USER", 0)
//        val gajiDariMain = bundle?.getFloat("DATA_GAJI_USER", 0f)

        Toast.makeText(this, "$namaDariMain $umurDariMain $gajiDariMain", Toast.LENGTH_LONG).show()

        ivHome.setOnClickListener {
            // code untuk bikin fragment
            val firstFragment = FirstFragment()

            // code untuk ambil fragment transaction dari fragment manager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // code untuk pasang fragment ke ViewGroup yang kira mau
            fragmentTransaction.replace(R.id.layout_fragment, firstFragment)
            // code untuk eksekusi perubahan
            fragmentTransaction.commit()
        }

        ivSearch.setOnClickListener {
            // code untuk bikin fragment
            val secondFragment = SecondFragment()

            // code untuk ambil fragment transaction dari fragment manager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // code untuk pasang fragment ke ViewGroup yang kira mau
            fragmentTransaction.replace(R.id.layout_fragment, secondFragment)
            // code untuk eksekusi perubahan
            fragmentTransaction.commit()
        }
    }
}