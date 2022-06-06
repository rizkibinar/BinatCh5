package id.co.rizki.binarch5.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import id.co.rizki.binarch5.R

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        val btnDialog = findViewById<Button>(R.id.btn_dialog)
        val btnDialogWithAction = findViewById<Button>(R.id.btn_dialog_action)
        val btnDialogCustom = findViewById<Button>(R.id.btn_dialog_custom)
        val btnDialogFragment = findViewById<Button>(R.id.btn_dialog_fragment)

        btnDialog.setOnClickListener {

            val dialog = AlertDialog.Builder(this)

            // set judul dari dialog
            dialog.setTitle("Contoh Dialog Standar")

            // set isi pesan dari dialog
            dialog.setMessage("Ini adalah contoh dialog standar tanpa action")

            // set dialog bisa di cancel/hilangkan saat click di luar dialog
            // true => bisa di hilangkan
            // cancel => tidak bisa di hilangkan
            dialog.setCancelable(true)

            // method untuk tampilkan dialog, tanpa ini dialog tidak akan muncul
            dialog.show()

        }

        btnDialogWithAction.setOnClickListener {

            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Contoh Dialog Standar Dengan Aksi")
            dialog.setMessage("Ini adalah contoh dialog standar dengan action")
            dialog.setCancelable(false)

            dialog.setPositiveButton("Ok") { dialogInterface, p1 ->
                Toast.makeText(this, "Tombol ok di click", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("Cancel") { dialogInterface, p1 ->
                Toast.makeText(this, "Tombol Cancel di click", Toast.LENGTH_SHORT).show()
            }
            dialog.setNeutralButton("Dont Remind") { dialogInterface, p1 ->
                Toast.makeText(this, "Tombol Dont Remind di click", Toast.LENGTH_SHORT).show()
            }

            dialog.show()
        }

        btnDialogCustom.setOnClickListener {

            // inflate layout xml custom yang sebelumnya kita buat ke kotlin
            val viewCustom = LayoutInflater.from(this).inflate(R.layout.dialog_custom, null, false)

            // buat 1 dialog builder untuk ngeset view yang sudah di inflate ke dialog kita
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(viewCustom)

            // bikin dialog jadi object, dengan memanggil dialogBuilder.create()
            val dialog = dialogBuilder.create()

            // binding/deklarasi view XML
            val btnClose = viewCustom.findViewById<Button>(R.id.btn_close)
            val btnCross = viewCustom.findViewById<TextView>(R.id.btn_cross)

            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            btnCross.setOnClickListener {
                dialog.dismiss()
            }


            dialog.show()

        }

        btnDialogFragment.setOnClickListener {
            val dialogFragment = CustomDialogFragment()
            dialogFragment.show(supportFragmentManager, CustomDialogFragment::class.java.simpleName)
        }

    }
}