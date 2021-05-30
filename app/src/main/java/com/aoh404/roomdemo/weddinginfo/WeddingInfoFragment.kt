package com.aoh404.roomdemo.weddinginfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aoh404.roomdemo.WeddingViewModel
import com.aoh404.roomdemo.R
import com.aoh404.roomdemo.ViewModelFactory

class WeddingInfoFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wedding_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activityViewModel = activity?.let {
            ViewModelProvider(it).get(WeddingInfoActivityViewModel::class.java)
        }
        view.findViewById<Button>(R.id.btn_edit)
            .setOnClickListener { activityViewModel?.navigateToEditingWeddingInfoFragment() }

        val tvDate = view.findViewById<TextView>(R.id.tv_date)
        ViewModelProvider(this, ViewModelFactory()).get(WeddingViewModel::class.java)
            .loadWeddingProfile()
            .observe(viewLifecycleOwner, Observer {
                tvDate.text = it?.weddingDate ?: "Some time"
            })

    }


}