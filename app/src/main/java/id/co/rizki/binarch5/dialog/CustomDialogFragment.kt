package id.co.rizki.binarch5.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import id.co.rizki.binarch5.R


/**
 * Created by Rizky Putra on 06/06/22.
 */
class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // untuk inflate dan bind xml ke dialog
        return inflater.inflate(R.layout.dialog_custom, container, false)
    }


    override fun onResume() {
        super.onResume()
        // untuk mastiin layout dialog kita ga full screen
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnClose = view.findViewById<Button>(R.id.btn_close)

        btnClose.setOnClickListener {
            dialog?.dismiss()
        }

    }
}