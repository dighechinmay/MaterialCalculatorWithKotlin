package com.chinmay.materialcalculatorwithkotlin

import android.app.Activity
import android.os.Handler
import android.os.SystemClock
import android.view.View
import android.widget.TextView

object CalculatorFunctions {

    lateinit var mMethodType: Constants

    fun addition(num1: Float, num2: Float): Float {
        return num1 + num2
    }

    fun subtract(num1: Float, num2: Float): Float {
        return num1 - num2
    }

    fun divide(num1: Float, num2: Float): Float {
        return num1 / num2
    }


    fun multiply(num1: Float, num2: Float): Float {
        return num1 * num2
    }

    fun modulo(num1: Int, num2: Int): Int {
        return num1 % num2
    }

    fun changeSign() {

    }


    fun getResults(num1: Float, num2: Float, methodType: Constants): Float {

        var result:Float = 0.0F

        when (methodType) {
            Constants.MODULO -> return modulo(num1.toInt(), num2.toInt()).toFloat()
            Constants.MULTIPLY -> result =  multiply(num1, num2)
            Constants.ADD -> result = addition(num1, num2)
            Constants.DIVIDE -> result = divide(num1, num2)
            Constants.SUBTRACT -> result = subtract(num1, num2)
        }

        return result
    }

    fun updateUiWithEquationAndSetOperator(
        mStringToDisplay: String,
        activity: Activity,
        mHandler: Handler,
        runnable: Runnable,
        methodType: Constants,
        mSetNumber1: Float,
        mSetNumber2: Float
    ) {

        var mMainActivityRunnable = runnable
        val displayText = activity.findViewById<TextView>(R.id.display_text)

        var resultAvailable = false
        var result = -1.0F

        mMainActivityRunnable = Runnable {

            displayText.visibility = View.INVISIBLE

            //setting operator
            if (methodType != Constants.NUMBER && methodType != Constants.EQUALS) {
                mMethodType = methodType
            }

            //only during showing result
            if (methodType == Constants.EQUALS) {
                resultAvailable = true
                result = getResults(mSetNumber1, mSetNumber2, mMethodType)
            }


            mHandler.post {
                SystemClock.sleep(200)

                if (resultAvailable)
                    displayText.text = result.toString()
                else
                    displayText.text = mStringToDisplay

                displayText.visibility = View.VISIBLE
                mHandler.removeCallbacks(mMainActivityRunnable)
            }
        }

        mHandler.post(mMainActivityRunnable)

    }


    fun clearDisplay(
        activity: Activity,
        mHandler: Handler,
        runnable: Runnable
    ) {
        var mMainActivityRunnable = runnable
        val display_text = activity.findViewById<TextView>(R.id.display_text)

        mMainActivityRunnable = Runnable {

            display_text.visibility = View.INVISIBLE


            mHandler.post {
                SystemClock.sleep(200)
                display_text.text = "0"
                display_text.visibility = View.VISIBLE
                mHandler.removeCallbacks(mMainActivityRunnable)
            }
        }

        mHandler.post(mMainActivityRunnable)

    }


}