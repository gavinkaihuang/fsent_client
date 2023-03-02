package com.mcoc.fsent.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.mcoc.fsent.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}