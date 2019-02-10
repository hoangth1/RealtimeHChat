package com.example.mychat.screen.ui.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mychat.R
import com.example.mychat.screen.ui.fragment.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            add(
                R.id.activity_container,
                MainFragment.newInstance(),
                MainFragment.TAG
            )
            commit()
        }
    }
}
