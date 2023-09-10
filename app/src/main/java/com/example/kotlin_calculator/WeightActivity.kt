package com.example.kotlin_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlin.math.roundToInt

class WeightActivity : AppCompatActivity() {
    private lateinit var constants : Array<String>

    private lateinit var valueForConvert : EditText

    private lateinit var resultConvert : TextView

    private lateinit var dropdownFrom : Spinner
    private lateinit var dropdownIn : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        constants = resources.getStringArray(R.array.weight_values)

        dropdownFrom = findViewById(R.id.dropDownFrom)
        dropdownIn = findViewById(R.id.dropDownIn)

        valueForConvert = findViewById(R.id.inputValue)

        resultConvert = findViewById(R.id.resultConvertation)



        ArrayAdapter.createFromResource(
            this,
            R.array.weight_values,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // Установка строкового массива
            // Применение адаптера к спинеру

            dropdownFrom.adapter = adapter
            dropdownIn.adapter = adapter
        }
    }
    fun switchToSelector(view : View){
        startActivity(Intent(this,SelectorActivity::class.java))
        finishAfterTransition()
    }
    fun calculateConvertation(view : View) {

        // Подсчёт массы
        if(valueForConvert.text.isNotEmpty()) // Проверяет не пустое ли поле ввода
        {
            val value = valueForConvert.text.toString().toDouble()
            var result = 0.0
            when (dropdownFrom.selectedItem.toString()) {

                // Микрограмм
                constants[0] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 1) // 1
                    constants[1] -> result = (value / 1000) // 1 : 1000 - ug -> miligram
                    constants[2] -> result = (value / 1000000) // 1 : 1e-6 (0,000 001) -> gram
                    constants[3] -> result =
                        (value / 1000000000) // 1 : 1e-9 (0, 000 000 001) -> kilogram
                    constants[4] -> result =
                        (value / 1000000000000) // 1 : 1e-12 (0, 000 000 000 001) - tonna
                    constants[5] -> result =
                        (value / 1000000000000000) // 1 : 1e-15 (0, 000 000 000 001) - megatonna
                    constants[6] -> result =
                        (value / 1000000000000000000) // 1 : 1e-18 (0, 000 000 000 001) - kilotonna
                }

                // Миллиграмм
                constants[1] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.001) // 1 : 0.001
                    constants[1] -> result = (value / 1) // 1 : 1
                    constants[2] -> result = (value / 1000) // 1 : 1e-3
                    constants[3] -> result = (value / 1000000) // 1 : 1e-6
                    constants[4] -> result = (value / 1000000000) // 1 : 1e-9
                    constants[5] -> result = (value / 1000000000000) // 1 : 1e-12
                    constants[6] -> result = (value / 1000000000000000) // 1 : 1e-15
                }

                // Грамм
                constants[2] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.000001) // 1 : 1e+6
                    constants[1] -> result = (value / 0.001) // 1 : 1e+3
                    constants[2] -> result = (value / 1) // 1 : 1
                    constants[3] -> result = (value / 1000) // 1 : 1e-3
                    constants[4] -> result = (value / 1000000) // 1 : 1e-6
                    constants[5] -> result = (value / 1000000000) // 1 : 1e-9
                    constants[6] -> result = (value / 1000000000000) // 1 : 1e-12
                }

                // Килограмм
                constants[3] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.000000001) // 1 : 1e+9
                    constants[1] -> result = (value / 0.000001) // 1 : 1e+6
                    constants[2] -> result = (value / 0.001) // 1 : 1e+3
                    constants[3] -> result = (value / 1) // 1 : 1
                    constants[4] -> result = (value / 1000) // 1 : 1e-3
                    constants[5] -> result = (value / 1000000) // 1 : 1e-6
                    constants[6] -> result = (value / 1000000000) // 1 : 1e-9
                }
                // Тонна
                constants[4] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.000000000001) // 1 : 1e+12
                    constants[1] -> result = (value / 0.000000001) // 1 : 1e+9
                    constants[2] -> result = (value / 0.000001) // 1 : 1e+6
                    constants[3] -> result = (value / 0.001) // 1 : 1e+3
                    constants[4] -> result = (value / 1) // 1 : 1
                    constants[5] -> result = (value / 1000) // 1 : 1e-3
                    constants[6] -> result = (value / 1000000) // 1 : 1e-6
                }

                // Мегатонна
                constants[5] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.000000000000001) // 1 : 1e+15
                    constants[1] -> result = (value / 0.000000000001) // 1 : 1e+12
                    constants[2] -> result = (value / 0.000000001) // 1 : 1e+9
                    constants[3] -> result = (value / 0.000001) // 1 : 1e+6
                    constants[4] -> result = (value / 0.001) // 1 : 1e+3
                    constants[5] -> result = (value / 1) // 1 : 1
                    constants[6] -> result = (value / 1000) // 1 : 1e-3
                }

                // Килотона
                constants[6] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.000000000000000001) // 1 : 1e+18
                    constants[1] -> result = (value / 0.000000000000001) // 1 : 1e+15
                    constants[2] -> result = (value / 0.000000000001) // 1 : 1e+12
                    constants[3] -> result = (value / 0.000000001) // 1 : 1e+9
                    constants[4] -> result = (value / 0.000001) // 1 : 1e+6
                    constants[5] -> result = (value / 0.001) // 1 : 1e+3
                    constants[6] -> result = (value / 1) // 1 : 11
                }
            }
            resultConvert.text = "≈" + result.toString()
        }
    }
    fun resetFields(view : View){
        // Сбрасывает значения в полях - Кнопка "Reset"
        resultConvert.text ="0"
        valueForConvert.setText("0")
    }
}