package com.example.crud_note_pika

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud_note_pika.adapter.BukuAdapter
import com.example.crud_note_pika.databinding.ActivityMainBinding
import com.example.crud_note_pika.screen.TambahDataBukuActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db : DbHelper
    private lateinit var bukuAdapter : BukuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DbHelper(this)
        bukuAdapter = BukuAdapter(db.getAllDataBuku(), this)

        binding.rvDataBuku.layoutManager = LinearLayoutManager(this)
        binding.rvDataBuku.adapter = bukuAdapter

        binding.btnPageTambahData.setOnClickListener{
            val intent = Intent(this, TambahDataBukuActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val newBuku = db.getAllDataBuku()
        bukuAdapter.refreshData(newBuku)
    }
}