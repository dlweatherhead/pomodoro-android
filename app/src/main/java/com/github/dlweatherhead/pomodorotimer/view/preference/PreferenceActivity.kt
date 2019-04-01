package com.github.dlweatherhead.pomodorotimer.view.preference

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.dlweatherhead.pomodorotimer.R

class PreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PreferenceFragment())
                .commit()
        }

    }
}