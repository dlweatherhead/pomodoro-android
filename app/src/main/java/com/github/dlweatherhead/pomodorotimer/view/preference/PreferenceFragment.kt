package com.github.dlweatherhead.pomodorotimer.view.preference

import android.os.Bundle
import com.github.dlweatherhead.pomodorotimer.R
import com.takisoft.fix.support.v7.preference.PreferenceFragmentCompat

/**
 * Note: We are extending this fix class instead of the standard PreferenceFragmentCompat
 *  because we cannot access the edit text directly to set style. This fix allows the edit text
 *  style to be set within the layout file.
 *  The future solution, to remove this dependency, would be to create custom Preferences, or create dialogs for entry.
 *  TODO: Investigate custom Preferences, dialogs, etc. for capturing preferences.
 */
class PreferenceFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferencesFix(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.app_preferences)
    }

}