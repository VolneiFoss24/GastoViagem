package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gastoviagem.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculo.setOnClickListener(this)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        ajusteObserver()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_calculo) {
            val distancia = binding.editDistancia.text.toString()
            val autonomia = binding.editAutonomia.text.toString()
            val precoLitro = binding.editPrecoLitro.text.toString()

            viewModel.calculo(distancia, autonomia, precoLitro)

        }
    }

    fun ajusteObserver(){
        viewModel.logicCalculo().observe(this) {
            val local = Locale("pt", "br")
            binding.textResult.text = NumberFormat.getCurrencyInstance(local).format(it)
        }
    }
}