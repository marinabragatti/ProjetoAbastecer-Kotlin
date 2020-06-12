package com.marinabragatti.projetoabastecerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
    fun calcularPreco(view: View){
        val alcool = valorAlcool.text.toString()
        val gasolina = valorGasolina.text.toString()

        val validarCampos = validarCampos(alcool, gasolina)
        if(validarCampos){
            var precoAlcool = alcool.toDouble()
            var precoGasolina = gasolina.toDouble()
            var melhorOpcao = precoAlcool/precoGasolina
            if(melhorOpcao < 0.7)
                resultado.text = "Abasteça com Álcool!"
            else
                resultado.text = "Abasteça com Gasolina!"
        }else
            resultado.text = "Valores inválidos"
    }

    fun validarCampos(alcool: String, gasolina: String): Boolean{
        var camposValidados = true
        if(alcool == null || alcool.equals(""))
            camposValidados = false
        else if(gasolina == null || gasolina.equals(""))
            camposValidados = false

        return camposValidados
    }
}
