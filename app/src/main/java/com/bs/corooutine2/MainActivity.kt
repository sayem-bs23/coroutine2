package com.bs.corooutine2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.user.observe(this, Observer{
            Log.d("dbg_resp", it.dayList[0].main?.temp.toString())
            Log.d("dbg", "abc")
        })

        viewModel.setUserId("1")
    }
}
