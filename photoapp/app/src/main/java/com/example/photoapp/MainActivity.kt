package com.example.photoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photoapp.adapter.PhotoAdapter
import com.example.photoapp.database.PhotoEntity
import com.example.photoapp.databinding.ActivityMainBinding
import com.example.photoapp.viewmodel.PhotoViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mAdapter: PhotoAdapter
    private var photoViewModel: PhotoViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        photoViewModel = ViewModelProvider(this@MainActivity)[PhotoViewModel::class.java]
        readDatabase()
    }

    private fun readDatabase() {

        photoViewModel?.photoDataOffline?.observe(this) {
            if (it.isEmpty()) {
                insertDataRoom()

            } else {
                setRV(it as MutableList<PhotoEntity>)

            }


        }

    }

    private fun setRV(photoList: MutableList<PhotoEntity>) {

        mAdapter = PhotoAdapter(this@MainActivity, photoList, photoViewModel!!)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = mAdapter
    }

    private fun insertDataRoom() {
        photoViewModel!!.insertData(PhotoEntity(1, R.drawable.pic1, 0f, ""))
        photoViewModel!!.insertData(PhotoEntity(2, R.drawable.pic2, 0f, ""))
        photoViewModel!!.insertData(PhotoEntity(3, R.drawable.pic3, 0f, ""))
        photoViewModel!!.insertData(PhotoEntity(4, R.drawable.pic4, 0f, ""))

    }
}