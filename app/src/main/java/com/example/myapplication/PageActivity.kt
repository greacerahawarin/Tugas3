package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.databinding.ActivityPageBinding

class PageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val intentMain = Intent(this, HomeActivity::class.java)
            startActivity(intentMain)
        }

        binding.button2.setOnClickListener{
            val intentMain = Intent(this, RecyclerActivity::class.java)
            startActivity(intentMain)
        }

        binding.btnBack.setOnClickListener{
            val intentMain = Intent(this, LoginActivity::class.java)
            startActivity(intentMain)
        }
    }
}