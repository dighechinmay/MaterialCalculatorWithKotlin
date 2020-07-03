package com.chinmay.materialcalculatorwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var TAG = "MainActivity";

    var mHandler = Handler()
    var mRunnable = Runnable {}
    var mStringToDisplay = ""


    var mSetNumber1 = -1.0F
    var mSetNumber2 = -1.0F
    var mSetFlag1 = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpOnClickListeners()
    }

    fun setUpOnClickListeners() {
        all_clear_btn.setOnClickListener(this)

        modulo_btn.setOnClickListener(this)
        multiply_btn.setOnClickListener(this)
        equals_btn.setOnClickListener(this)
        divide_btn.setOnClickListener(this)
        add_btn.setOnClickListener(this)
        subtract_btn.setOnClickListener(this)



        nine9_btn.setOnClickListener(this)
        eight8_btn.setOnClickListener(this)
        seven7_btn.setOnClickListener(this)
        six6_btn.setOnClickListener(this)
        five5_btn.setOnClickListener(this)
        four_btn.setOnClickListener(this)
        three3_btn.setOnClickListener(this)
        two2_btn.setOnClickListener(this)
        one1_btn.setOnClickListener(this)
        zero_btn.setOnClickListener(this)

    }


    override fun onClick(iTemView: View?) {


        when (iTemView!!.id) {
            R.id.all_clear_btn -> {
                CalculatorFunctions.clearDisplay(this, mHandler, mRunnable)
                mStringToDisplay = ""
            }

            R.id.subtract_btn -> {
                mStringToDisplay += "-"
                callCalculatorfunction(Constants.SUBTRACT)
            }

            R.id.divide_btn -> {
                mStringToDisplay += "÷"
                callCalculatorfunction(Constants.DIVIDE)
            }

            R.id.modulo_btn -> {
                mStringToDisplay += "%"
                callCalculatorfunction(Constants.MODULO)
            }

            R.id.multiply_btn -> {
                 mStringToDisplay += "x"
                 callCalculatorfunction(Constants.MULTIPLY)
            }

            R.id.add_btn -> {
                mStringToDisplay += "+"
                callCalculatorfunction(Constants.ADD)
            }

            R.id.equals_btn -> {
                mStringToDisplay += "="
                callCalculatorfunction(Constants.EQUALS)
            }

            R.id.nine9_btn -> {
                mStringToDisplay += "9"
                if (!mSetFlag1) {
                    mSetNumber1 = 9.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 9.0F

                callCalculatorfunction(Constants.NUMBER)
            }

            R.id.eight8_btn -> {
                mStringToDisplay += "8"

                if (!mSetFlag1) {
                    mSetNumber1 = 8.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 8.0F

                callCalculatorfunction(Constants.NUMBER)
            }

            R.id.seven7_btn -> {
            mStringToDisplay += "7"
            if (!mSetFlag1) {
                mSetNumber1 = 7.0F
                mSetFlag1 = true
            }
            else
                mSetNumber2 = 7.0F

            callCalculatorfunction(Constants.NUMBER)
        }

            R.id.six6_btn -> {
                mStringToDisplay += "6"

                if (!mSetFlag1) {
                    mSetNumber1 = 6.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 6.0F

                callCalculatorfunction(Constants.NUMBER)
            }

            R.id.five5_btn -> {
                mStringToDisplay += "5"
                if (!mSetFlag1) {
                    mSetNumber1 = 5.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 5.0F

                callCalculatorfunction(Constants.NUMBER)
            }

            R.id.four_btn -> {
                mStringToDisplay += "4"

                if (!mSetFlag1) {
                    mSetNumber1 = 4.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 4.0F

                callCalculatorfunction(Constants.NUMBER)
            }

            R.id.three3_btn -> {
                mStringToDisplay += "3"
                if (!mSetFlag1) {
                    mSetNumber1 = 3.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 3.0F

                callCalculatorfunction(Constants.NUMBER)
            }

            R.id.two2_btn -> {
                mStringToDisplay += "2"

                if (!mSetFlag1) {
                    mSetNumber1 = 2.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 2.0F

                callCalculatorfunction(Constants.NUMBER)
            }


            R.id.one1_btn -> {
                mStringToDisplay += "1"

                if (!mSetFlag1) {
                    mSetNumber1 = 1.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 1.0F

                callCalculatorfunction(Constants.NUMBER)
            }

            R.id.zero_btn -> {
                mStringToDisplay += "0"

                if (!mSetFlag1) {
                    mSetNumber1 = 0.0F
                    mSetFlag1 = true
                }
                else
                    mSetNumber2 = 0.0F

                callCalculatorfunction(Constants.NUMBER)
            }

        }
    }


    fun callCalculatorfunction(constants: Constants){

        CalculatorFunctions.updateUiWithEquationAndSetOperator(
            mStringToDisplay,
            this,
            mHandler,
            mRunnable,
            constants,
            mSetNumber1,
            mSetNumber2
        )

    }
}