package com.example.jobpathway

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentPersonal : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal, container, false)

        val sharedPreferences = requireContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val privateEmailTextView = view.findViewById<TextView>(R.id.display_private_email)
        val currentAddressTextView = view.findViewById<TextView>(R.id.display_current_address)
        val phoneNumberTextView = view.findViewById<TextView>(R.id.display_phone_number)

        privateEmailTextView.text = sharedPreferences.getString("privateEmail", "")
        currentAddressTextView.text = sharedPreferences.getString("currentAddress", "")
        phoneNumberTextView.text = sharedPreferences.getString("phoneNumber", "")

        return view
    }
}