package com.github.dlweatherhead.pomodorotimer.view

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.github.dlweatherhead.pomodorotimer.R
import com.github.dlweatherhead.pomodorotimer.databinding.ActivityMainBinding
import com.github.dlweatherhead.pomodorotimer.utility.TimeFormatUtility
import com.github.dlweatherhead.pomodorotimer.view.preference.PreferenceActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: PomodoroTimerViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    private val showToastOnPropertyChangedCallback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            Toast.makeText(applicationContext, getString(R.string.pomodoro_finished_toast_text), Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        binding.viewModel = viewModel
        binding.timeFormatter = TimeFormatUtility()
        binding.timerButton.setOnClickListener { viewModel.handleTimerButtonClicked() }
        viewModel.showToastTrigger.addOnPropertyChangedCallback(showToastOnPropertyChangedCallback)

        PreferenceManager.setDefaultValues(this, R.xml.app_preferences, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_preferences) {
            startActivity(Intent(this, PreferenceActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
