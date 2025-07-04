package com.example.jobpathway

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SkillAdapter(context: Context, private val skills: List<String>) :
    ArrayAdapter<String>(context, R.layout.skill_list_item, R.id.skill_text_view, skills) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.skill_list_item, parent, false)

        val skillTextView: TextView = view.findViewById(R.id.skill_text_view)
        skillTextView.text = skills[position]

        return view
    }
}