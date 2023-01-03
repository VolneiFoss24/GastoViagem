package com.example.gastoviagem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var gasto = MutableLiveData<Double>()

    fun calculo(distancia : String, autonomia : String, precoLitro : String){

        val litros = distancia.toDouble() / autonomia.toDouble()
        val total = litros * precoLitro.toDouble()

        gasto.value = total
    }

    fun logicCalculo() : LiveData<Double> {
        return gasto
    }
}