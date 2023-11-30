package com.example.kotlin_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment

class LengthFragment: Fragment() {
    private lateinit var constants: Array<String>

    private lateinit var valueForConvert: EditText

    private lateinit var resultConvert: TextView

    private lateinit var calculateButton: Button
    private lateinit var resetButton: Button

    private lateinit var dropdownFrom: Spinner
    private lateinit var dropdownIn: Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_length, container, false) // Сам view фрагмента

        constants = resources.getStringArray(R.array.length_values)

        dropdownFrom = view.findViewById(R.id.dropDownFrom)
        dropdownIn = view.findViewById(R.id.dropDownIn)

        valueForConvert = view.findViewById(R.id.inputValue)

        resultConvert = view.findViewById(R.id.resultConvertation)

        calculateButton = view.findViewById(R.id.buttonConvert)
        resetButton = view.findViewById(R.id.buttonReset)

        calculateButton.setOnClickListener { calculateConvertation(it) }
        resetButton.setOnClickListener { resetFields(it) }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.length_values,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // Установка строкового массива
            // Применение адаптера к спинеру
            dropdownFrom.adapter = adapter
            dropdownIn.adapter = adapter
        }

        return view
    }
    fun resetFields(view: View) {
        // Сбрасывает значения в полях - Кнопка "Reset"
        resultConvert.text = "0"
        valueForConvert.setText("0")
    }
    fun calculateConvertation(view: View) {
        // Расчёт длины
        if(valueForConvert.text.isNotEmpty()) // Проверяет не пустое ли поле ввода
        {
            val value = valueForConvert.text.toString().toDouble()
            var result = 0.0
            when (dropdownFrom.selectedItem.toString()) {

                //Нанометр
                constants[0] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 1) // 1
                    constants[1] -> result = (value / 1000) // 1000
                    constants[2] -> result = (value / 1000000)// 1e-6
                    constants[3] -> result = (value / 10000000) // 1e-7
                    constants[4] -> result = (value / 100000000) // 1e-8
                    constants[5] -> result = (value / 1000000000) // 1e-9
                    constants[6] -> result = (value / 1000000000000) // 1e-12
                }

                //Микрометр
                constants[1] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.001) // 1
                    constants[1] -> result = (value / 1) // 1 : 1000
                    constants[2] -> result = (value / 1000) // 1 : 1e-3
                    constants[3] -> result = (value / 10000) // 1 : 1e-4
                    constants[4] -> result = (value / 100000) // 1 : 1e-5
                    constants[5] -> result = (value / 1000000) // 1 : 1e-6
                    constants[6] -> result = (value / 1000000000) // 1 : 1e-9
                }

                // Миллиметр
                constants[2] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.000001) // 1e+6
                    constants[1] -> result = (value / 0.001) // 1e+3
                    constants[2] -> result = (value / 1) // 1
                    constants[3] -> result = (value / 10) // 1e-1
                    constants[4] -> result = (value / 100) // 1e-2
                    constants[5] -> result = (value / 1000) // 1e-3
                    constants[6] -> result = (value / 1000000) // 1e-6
                }

                // Сантиметр
                constants[3] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.0000001) // 1e+7
                    constants[1] -> result = (value / 0.0001) // 1e+4
                    constants[2] -> result = (value / 0.1) // 1e+1
                    constants[3] -> result = (value / 1)// 1
                    constants[4] -> result = (value / 10) // 1e-1
                    constants[5] -> result = (value / 100) // 1e-2
                    constants[6] -> result = (value / 100000) // 1e-5
                }

                // Дециметр
                constants[4] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.00000001) // 1e+8
                    constants[1] -> result = (value / 0.000001) // 1e+6
                    constants[2] -> result = (value / 0.01) // 1e+1
                    constants[3] -> result = (value / 0.1) // 1
                    constants[4] -> result = (value / 1) // 1
                    constants[5] -> result = (value / 10) // 1e-1
                    constants[6] -> result = (value / 10000) // 1e-4
                }

                // Метр
                constants[5] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.000000001) // 1e+9
                    constants[1] -> result = (value / 0.000001) // 1e+6
                    constants[2] -> result = (value / 0.001)// 1e+1
                    constants[3] -> result = (value / 0.01) // 1
                    constants[4] -> result = (value / 10) // 1
                    constants[5] -> result = (value / 1) // 1e-1
                    constants[6] -> result = (value / 1000) // 1e-4
                }

                // Километр
                constants[6] -> when (dropdownIn.selectedItem.toString()) {
                    constants[0] -> result = (value / 0.000000000001) // 1e+12
                    constants[1] -> result = (value / 0.000000001) // 1e+9
                    constants[2] -> result = (value / 0.000001) // 1e+6
                    constants[3] -> result = (value / 0.00001) // 1e+5
                    constants[4] -> result = (value / 0.0001) //  1e+4
                    constants[5] -> result = (value / 0.001) //  1e+3
                    constants[6] -> result = (value / 1) // 1e
                }

            }
            resultConvert.text = "≈" + result.toString()
        }
    }
}