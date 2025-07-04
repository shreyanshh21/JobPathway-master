package com.example.jobpathway

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentProfessional : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_professional, container, false)

        val sharedPreferences = requireContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val officialEmailTextView = view.findViewById<TextView>(R.id.display_official_email)
        val currentJobTextView = view.findViewById<TextView>(R.id.display_current_job)
        val yearsOfExperienceTextView = view.findViewById<TextView>(R.id.display_years_of_experience)
        val educationTextView = view.findViewById<TextView>(R.id.display_education)
        val skillsTextView = view.findViewById<TextView>(R.id.display_skils)

        officialEmailTextView.text = sharedPreferences.getString("officialEmail", "")
        currentJobTextView.text = sharedPreferences.getString("currentJobTitle", "")
        yearsOfExperienceTextView.text = sharedPreferences.getString("yearsOfExperience", "")
        educationTextView.text = sharedPreferences.getString("education", "")
        skillsTextView.text = sharedPreferences.getString("skills", "")

        return view
    }
}