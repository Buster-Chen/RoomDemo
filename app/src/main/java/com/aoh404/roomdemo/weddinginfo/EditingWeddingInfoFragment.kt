package com.aoh404.roomdemo.weddinginfo

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aoh404.roomdemo.R
import com.aoh404.roomdemo.ViewModelFactory
import com.aoh404.roomdemo.model.WeddingProfile


class EditingWeddingInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_editing_wedding_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this, ViewModelFactory())
            .get(EditingWeddingInfoViewModel::class.java)

        val edtWeddingDate = view.findViewById<EditText>(R.id.edt_wedding_date)
        viewModel.loadWeddingProfile()
            .observe(viewLifecycleOwner, Observer { weddingProfile ->
                weddingProfile?.let {
                    edtWeddingDate.setText(it.weddingDate)
                }
            })

        view.findViewById<Button>(R.id.btn_submit)
            .setOnClickListener {
                val weddingDate = edtWeddingDate.text
                if (weddingDate.isEmpty()) return@setOnClickListener
                viewModel.addWeddingProfile(WeddingProfile(1, weddingDate.toString()))
            }

        val datePickerDialog = DatePickerDialog(view.context).apply {
            setOnDateSetListener { _, year, month, dayOfMonth ->
                edtWeddingDate.setText("$year-$month-$dayOfMonth")
            }
        }
        edtWeddingDate.setOnClickListener {
            datePickerDialog.show()
        }
    }

}