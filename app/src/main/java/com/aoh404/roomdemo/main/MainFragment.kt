package com.aoh404.roomdemo.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aoh404.roomdemo.*
import com.aoh404.roomdemo.weddinginfo.WeddingInfoActivity

class MainFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_navigate)
                .setOnClickListener {
                    startActivity(Intent(this@MainFragment.context, WeddingInfoActivity::class.java))
                }

        val tvDate = view.findViewById<TextView>(R.id.tv_date)
        ViewModelProvider(this, ViewModelFactory()).get(WeddingViewModel::class.java)
                .loadWeddingProfile()
                .observe(viewLifecycleOwner, Observer {
                    tvDate.text = it?.weddingDate ?: "Some time"
                })
    }
}