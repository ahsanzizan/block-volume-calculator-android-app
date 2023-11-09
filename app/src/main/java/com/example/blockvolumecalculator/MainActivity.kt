package com.example.blockvolumecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var editWidth: EditText
    private lateinit var editHeight: EditText
    private lateinit var editLength: EditText
    private lateinit var calculateBtn: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editWidth = findViewById(R.id.edit_width)
        editHeight = findViewById(R.id.edit_height)
        editLength = findViewById(R.id.edit_length)
        calculateBtn = findViewById(R.id.calculate_btn)
        result = findViewById(R.id.result)

        calculateBtn.setOnClickListener(this)
    }

    private fun toDouble(str: String): Double? {
        return try {
            str.toDouble()
        } catch (e: NumberFormatException) {
            null
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.calculate_btn) {
            val inputLength: String = editLength.text.toString().trim()
            val inputWidth: String = editWidth.text.toString().trim()
            val inputHeight: String = editHeight.text.toString().trim()

            if (TextUtils.isEmpty(inputLength) || TextUtils.isEmpty(inputWidth) || TextUtils.isEmpty(inputHeight)) {
                if (TextUtils.isEmpty(inputLength)) {
                    editLength.error = "Length cannot be empty"
                }
                if (TextUtils.isEmpty(inputWidth)) {
                    editWidth.error = "Width cannot be empty"
                }
                if (TextUtils.isEmpty(inputHeight)) {
                    editHeight.error = "Height cannot be empty"
                }
            } else {
                val res: Int = Integer.parseInt(inputLength) * Integer.parseInt(inputWidth) * Integer.parseInt(inputHeight)
                result.text = res.toString()
            }
        }
    }
}