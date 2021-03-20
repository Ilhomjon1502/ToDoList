package com.ilhomjon.homework423

import KeshXotira.MySharedPrefarance
import Models.TodoPlan
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_property.*

class Property : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property)

        MySharedPrefarance.init(this)
        val name = intent.getStringExtra("name")
        println(name)
        val planArray = MySharedPrefarance.obektString
        var plan1 = TodoPlan()
        var index = -1
        for (plan in planArray) {
            if (plan.name == name){
                plan1 = plan
                index = planArray.indexOf(plan)
                txt_name_plan.text = plan.name
                txt_create_data.text = plan.createData
                txt_dedline_data.text = plan.dedline
                txt_degree.text = plan.degree?.name
                img_plan.setImageResource(plan.degree!!.img)
                when(plan.level){
                    "Open" -> rad_open.isChecked = true
                    "Development" -> rad_dev.isChecked = true
                    "Uploading" -> rad_uploading.isChecked = true
                    "Reject" -> rad_reject.isChecked = true
                    "Close" -> rad_closed.isChecked = true
                }
                break
            }
        }
        btn_ok.setOnClickListener {
            var rad = ""
            if (rad_open.isChecked) rad = "Open"
            if (rad_closed.isChecked) rad = "Close"
            if (rad_dev.isChecked) rad = "Development"
            if (rad_reject.isChecked) rad = "Reject"
            if (rad_uploading.isChecked) rad = "Uploading"

            plan1.level = rad
            planArray[index] = plan1
            MySharedPrefarance.obektString = planArray
            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}