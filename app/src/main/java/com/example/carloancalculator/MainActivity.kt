package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateRepayment()
        }
    }

    private fun calculateRepayment(){
    //TODO get input and show outputs
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }
        val carPrice: Int =  editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val interestRate:Float = editTextInterestRate.text.toString().toFloat()
        val loan = carPrice - downPayment
        val loadPeriod:Int = editTextLoanPeriod.text.toString().toInt()

        val interest = loan * interestRate/100 * loadPeriod

        textViewLoan.setText(getString(R.string.loan)+ "${loan}")
        textViewInterest.setText(getString(R.string.interest)+ "${interest}")



        val repayment = (loan + interest) / loadPeriod/12

        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${repayment}" )



    }

    fun reset(view : View){
        //TODO  clear all inputs and outputs
        

    }

}
