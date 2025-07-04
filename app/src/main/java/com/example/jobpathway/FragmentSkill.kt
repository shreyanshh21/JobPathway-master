package com.example.jobpathway

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class FragmentSkill : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_skills, container, false)

        val sharedPreferences = requireContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val skillsString = sharedPreferences.getString("skills", "") ?: ""

        val skillsList: List<String> = if (skillsString.isNotBlank()) {
            skillsString.split(',').map { it.trim() }.filter { it.isNotBlank() }
        } else {
            emptyList()
        }

        val listView = view.findViewById<ListView>(R.id.skills_list_view)
        val adapter = SkillAdapter(requireContext(), skillsList)
        listView.adapter = adapter

        return view
    }
}