package com.example.agecalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
   lateinit var BtnSelect : Button
   lateinit var TvDob  : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BtnSelect  = findViewById(R.id.SelectAgeBtn)
        TvDob = findViewById(R.id.DobTv)
        BtnSelect.setOnClickListener(View.OnClickListener {
            showCalender()

        })
    }

    private fun showCalender() {
        val myCalendar = Calendar.getInstance()
        val Year = myCalendar.get(Calendar.YEAR)
        val Month = myCalendar.get(Calendar.MONTH)
        val Day = myCalendar.get(Calendar.DAY_OF_MONTH)
     DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
         view, year, month, dayOfMonth ->
         Toast.makeText(this,"$dayOfMonth/${month+1}/$year",Toast.LENGTH_SHORT).show()
     },Year,Month,Day).show()
     //
        var sdf = SimpleDateFormat("dd/MM/YYYY", Locale.ENGLISH)
        var DOB = sdf.parse("$Day/${Month+1}/$Year")
        TvDob.text = DOB.toString()

    }

}