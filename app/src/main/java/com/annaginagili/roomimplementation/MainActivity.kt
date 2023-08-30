package com.annaginagili.roomimplementation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.annaginagili.AppDatabase
import com.annaginagili.roomimplementation.data.User
import com.annaginagili.roomimplementation.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var name: EditText
    lateinit var surname: EditText
    lateinit var add: Button
    lateinit var get: Button
    lateinit var data: TextView
    var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        name = binding.name
        surname = binding.surname
        add = binding.add
        get = binding.get
        data = binding.data

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "myLMS").build()

        get.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val userDao = db.userDao()
                val users = userDao.getAll()

                for (i in users) {
                    text += i.name + " " + i.surname + ", "
                    Log.e("hello", i.name)
                }
            }

            data.text = text
        }
    }
}