package com.example.kotlin_calculator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.kotlin_calculator.R
import com.example.kotlin_calculator.activities.MainActivity

class SelectorFragment: Fragment() {
    // Ленивая инициализация фрагмента конвертора
    private val converterFragment: ConverterFragment by lazy { ConverterFragment() }

    // Ленивая инициализация фрагмента математических тел
    private val mathFigureFragment: MathFigureFragment by lazy { MathFigureFragment() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_selector, container, false)

        //Ссылки на компоненты
        val unitButtons = arrayOf(
            view.findViewById(R.id.buttonWeight) as ImageButton,
            view.findViewById(R.id.buttonLength) as ImageButton,
            view.findViewById(R.id.buttonSpeed) as ImageButton,
            view.findViewById(R.id.buttonData) as ImageButton,
            view.findViewById(R.id.buttonTemperature) as ImageButton,
            view.findViewById(R.id.buttonVolume) as ImageButton,
            view.findViewById(R.id.buttonArea) as ImageButton,
            view.findViewById(R.id.buttonFrequency) as ImageButton,
            view.findViewById(R.id.buttonFuelConsumption) as ImageButton,
            view.findViewById(R.id.buttonPressure) as ImageButton,
            view.findViewById(R.id.buttonPowerNumber) as ImageButton,
            view.findViewById(R.id.buttonEnergy) as ImageButton
        )
        val mathSolidsButtons = arrayOf(
            view.findViewById(R.id.buttonMathParallelepiped) as ImageButton,
            view.findViewById(R.id.buttonMathPyramid) as ImageButton,
            view.findViewById(R.id.buttonMathCylinder) as ImageButton,
            view.findViewById(R.id.buttonMathCone) as ImageButton,
            view.findViewById(R.id.buttonMathSphere) as ImageButton,
//            view.findViewById(R.id.buttonMathPrism) as ImageButton,
            view.findViewById(R.id.buttonMathRectangle) as ImageButton,
            view.findViewById(R.id.buttonMathTriangle) as ImageButton,
            view.findViewById(R.id.buttonMathRhombus) as ImageButton,
            view.findViewById(R.id.buttonMathCircle) as ImageButton,
            view.findViewById(R.id.buttonMathTrapezium) as ImageButton
        )

        for ((index, button) in unitButtons.withIndex()) {
            button.setOnClickListener {
                converterFragment.dataIdSet(index)
                (requireActivity() as MainActivity).replaceFragmentInViewPager(1, converterFragment)
            }
        }

        for ((index, button) in mathSolidsButtons.withIndex()) {
            button.setOnClickListener {
                mathFigureFragment.dataIdSet(index)
                mathFigureFragment.imageSet(button.drawable)
                (requireActivity() as MainActivity).replaceFragmentInViewPager(1, mathFigureFragment)
            }
        }


        return view
    }
}