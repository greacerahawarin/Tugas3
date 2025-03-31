package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    private lateinit var makeupRecyclerView: RecyclerView
    private lateinit var makeupAdapter: MyAdapter
    private lateinit var listMakeup : ArrayList<ItemData>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        makeupRecyclerView = findViewById(R.id.makeupRV)
        listMakeup = ArrayList()

        listMakeup.add(ItemData(R.drawable.moist, nama = "Skin Preparation", desc = "Moisturizer"))
        listMakeup.add(ItemData(R.drawable.ss, nama = "Skin Preparation", desc = "Sunscreen"))
        listMakeup.add(ItemData(R.drawable.com, nama = "Complexion", desc = "Foundation, Cushion, Skintint"))
        listMakeup.add(ItemData(R.drawable.blush, nama = "Cheek", desc = "Cream Blush"))
        listMakeup.add(ItemData(R.drawable.loose, nama = "Powder", desc = "Loose Powder"))
        listMakeup.add(ItemData(R.drawable.eyeshadow, nama = "Eye Makeup", desc = "Eyeshadow"))
        listMakeup.add(ItemData(R.drawable.eyeliner, nama = "Eye Makeup", desc = "Eyeliner"))
        listMakeup.add(ItemData(R.drawable.highlighter, nama = "Highlighter", desc = "Highlighter"))
        listMakeup.add(ItemData(R.drawable.lipbalm, nama = "Lippies", desc = "Lipbalm"))
        listMakeup.add(ItemData(R.drawable.lippies, nama = "Lippies", desc = "Lipcream, Liptint, Lipgloss"))
        listMakeup.add(ItemData(R.drawable.setspray, nama = "Setting Spray", desc = "Setting Spray"))


        makeupRecyclerView.layoutManager = LinearLayoutManager(this)
        makeupRecyclerView.setHasFixedSize(true)
        makeupAdapter = MyAdapter(listMakeup)
        makeupRecyclerView.adapter = makeupAdapter
    }
}