package com.example.jobpathway

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SetUpProfile : AppCompatActivity() {
    private lateinit var privateEmail: TextView
    private lateinit var currentAddress: TextView
    private lateinit var officialEmail: TextView
    private lateinit var phoneNumber: TextView
    private lateinit var currentJobTitle: TextView
    private lateinit var yearsOfExperience: TextView
    private lateinit var skills: TextView
    private lateinit var education: TextView
    private lateinit var preferredLocation: TextView
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_profile)

        //fetching user's name from shared preferences
        val fullname = findViewById<TextView>(R.id.userName)
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "")
        fullname.text = name

        privateEmail = findViewById(R.id.edit_text_personal_email)
        currentAddress = findViewById(R.id.edit_text_address)
        officialEmail = findViewById(R.id.edit_text_email)
        phoneNumber = findViewById(R.id.edit_text_phone)
        currentJobTitle = findViewById(R.id.edit_text_job_title)
        yearsOfExperience = findViewById(R.id.edit_text_experience)
        skills = findViewById(R.id.edit_text_skills)
        education = findViewById(R.id.edit_text_education)
        preferredLocation = findViewById(R.id.edit_text_location)
        saveButton = findViewById(R.id.button_save_profile)


        saveButton.setOnClickListener{
            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("privateEmail", privateEmail.text.toString())
            editor.putString("currentAddress", currentAddress.text.toString())
            editor.putString("officialEmail", officialEmail.text.toString())
            editor.putString("phoneNumber", phoneNumber.text.toString())
            editor.putString("currentJobTitle", currentJobTitle.text.toString())
            editor.putString("yearsOfExperience", yearsOfExperience.text.toString())
            editor.putString("skills", skills.text.toString())
            editor.putString("education", education.text.toString())
            editor.putString("preferredLocation", preferredLocation.text.toString())
            editor.apply()
            startActivity(Intent(this, HomePage::class.java))
        }

    }
}