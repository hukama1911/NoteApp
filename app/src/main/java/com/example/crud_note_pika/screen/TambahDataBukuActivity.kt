package com.example.crud_note_pika.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_note_pika.DbHelper
import com.example.crud_note_pika.R
import com.example.crud_note_pika.databinding.ActivityTambahDataBukuBinding
import com.example.crud_note_pika.model.Modelbuku

class TambahDataBukuActivity : AppCompatActivity() {
    //binding : cara ringkas untuk kita deklarasi variable dan widget
    private lateinit var binding : ActivityTambahDataBukuBinding
    private lateinit var db: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahDataBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DbHelper(this)
        binding.btnTambahData.setOnClickListener{
            val judul = binding.txtInputJudul.text.toString()
            val penulis = binding.txtInputPenulis.text.toString()
            val isi = binding.txtInputIsi.text.toString()

            //karena nim--> int jadi kita perlu convert dari string ke int
            //toInt()
            val dataBuku = Modelbuku(0, judul, penulis, isi)
            db.insertDataBuku(dataBuku)
            finish();
            Toast.makeText(this, "Berhasil Tambah Data",
                Toast.LENGTH_LONG).show()
        }

    }
}