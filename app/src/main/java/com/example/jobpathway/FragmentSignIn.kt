package com.example.jobpathway

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.content.edit

class FragmentSignIn : Fragment() {
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSignIn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_sign_in, container, false)
        etName = view.findViewById<EditText>(R.id.fullname)
        etEmail = view.findViewById<EditText>(R.id.email)
        btnSignIn = view.findViewById<Button>(R.id.btnSignUp)
        btnSignIn.setOnClickListener {
            saveUserData()
            startActivity(Intent(requireContext(), SetUpProfile::class.java))
        }
        return view
    }
    private fun saveUserData(){
        val name = etName.text.toString()
        val email = etEmail.text.toString()

        //validation
        if(name.isEmpty() || email.isEmpty()){
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
        }

        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs",Context.MODE_PRIVATE)
        sharedPreferences.edit() {
            putString("name", name)
            putString("email", email)
        }
        Toast.makeText(requireContext(), "User data saved", Toast.LENGTH_SHORT).show()
    }
}