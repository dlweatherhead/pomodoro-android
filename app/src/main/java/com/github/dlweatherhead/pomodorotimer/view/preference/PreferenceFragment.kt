package com.github.dlweatherhead.pomodorotimer.view.preference

import android.os.Bundle
import com.github.dlweatherhead.pomodorotimer.R
import com.takisoft.fix.support.v7.preference.PreferenceFragmentCompat

class PreferenceFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferencesFix(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.app_preferences)
    }

}