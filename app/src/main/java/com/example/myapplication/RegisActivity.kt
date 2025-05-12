package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityRegisBinding
import com.google.firebase.auth.FirebaseAuth

class RegisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button3.setOnClickListener {
            val email = binding.EmailRegis.text.toString().trim()
            val password = binding.PassRegis.text.toString().trim()
            val repassword = binding.RepassRegis.text.toString().trim()

            if (email.isEmpty()) {
                binding.EmailRegis.error = "Input Email"
                binding.EmailRegis.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.EmailRegis.error = "Invalid email"
                binding.EmailRegis.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                binding.PassRegis.error = "Password must be more than 6 characters"
                binding.PassRegis.requestFocus()
                return@setOnClickListener
            }

            if (password != repassword) {
                binding.RepassRegis.error = "Password must match"
                binding.RepassRegis.requestFocus()
                return@setOnClickListener
            }

            registerUser(email, password)
        }

        binding.textView5.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                startActivity(Intent(this, PageActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(this, PageActivity::class.java))
            finish()
        }
    }
}
