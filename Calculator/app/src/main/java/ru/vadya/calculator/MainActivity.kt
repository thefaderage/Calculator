package ru.vadya.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import ru.vadya.calculator.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn0.setOnClickListener{ setTextFields("0") }

        binding.btn1.setOnClickListener{ setTextFields("1") }

        binding.btn2.setOnClickListener{ setTextFields("2") }

        binding.btn3.setOnClickListener{ setTextFields("3") }

        binding.btn4.setOnClickListener{ setTextFields("4") }

        binding.btn5.setOnClickListener{ setTextFields("5") }

        binding.btn6.setOnClickListener{ setTextFields("6") }

        binding.btn7.setOnClickListener{ setTextFields("7") }

        binding.btn8.setOnClickListener{ setTextFields("8") }

        binding.btn9.setOnClickListener{ setTextFields("9") }

        binding.btnDot.setOnClickListener{ setTextFields(".") }

        binding.btnMinus.setOnClickListener{ setTextFields("-") }

        binding.btnPlus.setOnClickListener{ setTextFields("+") }

        binding.btnMultiply.setOnClickListener{ setTextFields("*") }

        binding.btnDivision.setOnClickListener{ setTextFields("/") }

        binding.btnAC.setOnClickListener {
            binding.calculation.text = ""
            binding.result.text = ""
        }

        binding.btnBack.setOnClickListener {
            val str = binding.calculation.text.toString()
            if (str.isNotEmpty())
                binding.calculation.text = str.substring(0, str.length - 1)

            binding.result.text = ""
        }

        binding.btnEqual.setOnClickListener {
            try {

                val expression = ExpressionBuilder(binding.calculation.text.toString()).build()
                val result = expression.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    binding.result.text = longRes.toString()
                else
                    binding.result.text = result.toString()

            } catch (e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields (str: String){
        if (binding.result.text != ""){
            binding.calculation.text = binding.result.text
            binding.result.text = ""
        }
        binding.calculation.append(str)
    }
}