package com.ilhomjon.homework423

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        card_add_to_do.setOnClickListener {
            startActivity(Intent(this, AddToDo::class.java))
        }

        card_to_do_list.setOnClickListener {
            startActivity(Intent(this, ToDoList::class.java))
        }
    }
}