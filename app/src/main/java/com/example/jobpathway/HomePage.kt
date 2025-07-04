package com.example.jobpathway

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val profileBtn = findViewById<ImageButton>(R.id.profileImageButton)
        profileBtn.setOnClickListener {
            val intent = Intent(this, MyProfile::class.java)
            startActivity(intent)
        }

        val jobBtn = findViewById<ImageButton>(R.id.jobsImageButton)
        jobBtn.setOnClickListener {
            val intent = Intent(this, JobListActivity::class.java)
            startActivity(intent)
        }

    }
}