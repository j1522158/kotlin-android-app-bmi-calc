package com.example.jetbmicalculater

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")

    // 0fでfloat型へ
    var bmi by mutableStateOf(0f)

    // BMI = (体重kg) / (身長m) ** 2
    fun calculateBMI() {
        // toFloat でFloat型へ　変換できないときにExceptionを返す
        // toFloatOrNull　変換できないときにNullを返す
        // .div(100) で身長(cm)を(m)に直す　＝100で割る
        val heightNumber = height.toFloatOrNull()?.div(100) ?: 0f

        val weightNumber = weight.toFloatOrNull() ?: 0f

        // roundToIntで四捨五入
        bmi = if (heightNumber > 0f && weightNumber > 0f) {
            (weightNumber / heightNumber.pow(2) * 10).roundToInt() / 10f
        } else 0f
    }
}