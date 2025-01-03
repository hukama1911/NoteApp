package com.example.crud_note_pika.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crud_note_pika.DbHelper
import com.example.crud_note_pika.R
import com.example.crud_note_pika.databinding.ActivityUpdateDataBukuBinding
import com.example.crud_note_pika.model.Modelbuku

class UpdateDataBukuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateDataBukuBinding
    private lateinit var db : DbHelper
    private var bukuId : Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateDataBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DbHelper(this)

        bukuId = intent.getIntExtra("id_buku", -1)
        if(bukuId == -1){
            finish()
            return
        }
        //proses menampilkan data ke edit text di edit view

        val buku = db.getBukuById(bukuId)
        binding.etEditJudul.setText(buku.judul)
        binding.etEditPenulis.setText(buku.penulis)
        binding.etEditIsiBuku.setText(buku.isi)

        //update dari button
        binding.btnEditBuku.setOnClickListener(){
            val newJudul = binding.etEditJudul.text.toString()
            val newPenulis =binding.etEditPenulis.text.toString()
            val newIsi = binding.etEditIsiBuku.text.toString()

            val updatedBuku = Modelbuku(bukuId, newJudul, newPenulis, newIsi)
            db.updateBuku(updatedBuku)
            finish()
            Toast.makeText(this, "Update Success", Toast.LENGTH_LONG).show()
        }
    }
}