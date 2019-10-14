package com.example.kalkulatir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import kotlinx.android.synthetic.main.activity_main.*

class MainCalculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var leftOperand: Integer
        var rightOperand: Integer
        var operation: Char

        btnSome.setOnClickListener {
            startActivity(Intent(this, SomeActivity::class.java))
        }

        btn0.setOnClickListener {
            if(resultTextView.text != "0"){
                resultTextView.text = resultTextView.text + "0"
            }
        }

        btn1.setOnClickListener {
            resultTextView.text = displayNumbers("1")
        }

        btn2.setOnClickListener {
            resultTextView.text = displayNumbers("2")
        }

        btn3.setOnClickListener {
            resultTextView.text = displayNumbers("3")
        }

        btn4.setOnClickListener {
            resultTextView.text = displayNumbers("4")
        }

        btn5.setOnClickListener {
            resultTextView.text = displayNumbers("5")
        }

        btn6.setOnClickListener {
            resultTextView.text = displayNumbers("6")
        }

        btn7.setOnClickListener {
            resultTextView.text = displayNumbers("7")
        }

        btn8.setOnClickListener {
            resultTextView.text = displayNumbers("8")
        }

        btn9.setOnClickListener {
            resultTextView.text = displayNumbers("9")
        }

        btnDot.setOnClickListener {
            if(resultTextView.text == ""){
                resultTextView.text = "0."
            }else if(resultTextView.text.contains('.')){
            // do nothing
            }else{
                resultTextView.text = resultTextView.text + "."
            }
        }

        btnRemove.setOnClickListener {
            resultTextView.text = resultTextView.text.dropLast(1)
        }

        btnDelete.setOnClickListener {
            resultTextView.text = "0"
        }

        btnEquals.setOnClickListener {
            displayRightOperator()
        }

        btnPlus.setOnClickListener {
            displayLeftOperator('+')
        }

        btnMinus.setOnClickListener {
            displayLeftOperator('-')
        }

        btnDelete.setOnClickListener {
            displayLeftOperator('/')
        }

        btnMultiply.setOnClickListener {
            displayLeftOperator('*')
        }

        btnPercent.setOnClickListener {
            val res = resultTextView.toString().toDouble() / 100
            historyTextView.text += resultTextView.text +"\n=\n$res\n\n"
            resultTextView.text = "$res"
        }
    }


    private fun displayNumbers(s: String): String {

        return if(resultTextView.text.toString() == "0") { s } else { resultTextView.text.toString() + s }
    }

    private fun displayLeftOperator(operator: Char) {
        val g = Globals.getInstance()
        g.setLeftOperand(resultTextView.text.toString().toDouble())
        g.setOperation(operator)

        historyTextView.text += resultTextView.text + "\n$operator\n"
        resultTextView.text = "0"
    }

    private fun displayRightOperator() {
        val g = Globals.getInstance()

        val left = g.getLeftOperand()
        val right = resultTextView.text.toString().toDouble()
        val result: Double

        result = when(g.operation) {
            '+' -> left + right
            '-' -> left - right
            '*' -> left * right
            '/' -> left / right
            else -> left / 100 // %
        }
        historyTextView.text += resultTextView.text + "\n=\n$result"
        resultTextView.text = result.toString()
    }
}

private operator fun Any.plus(s: String): CharSequence {
    return this.toString() + s
}

private operator fun Any.plus(s: CharSequence): CharSequence {
    return this.toString() + s
}
