package com.example.bmicalculator

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.View.GONE
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var etHieght:EditText
    lateinit var etWeight:EditText
    lateinit var calcBtn:Button
    lateinit var tvBmi:TextView
    lateinit var tvBmiText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etHieght = findViewById(R.id.et_height)
        etWeight = findViewById(R.id.et_weight)
        calcBtn = findViewById(R.id.bt_calc)
        tvBmi = findViewById(R.id.tv_bmi)
        tvBmiText =findViewById(R.id.tv_text)

        tvBmi.visibility = View.GONE
        tvBmiText.visibility = View.GONE
        calcBtn.setOnClickListener(this)


    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(view: View?) {

        if (view?.id == R.id.bt_calc){

            btnRequire()


        }
//            Toast.makeText(this , "Calc Button" ,Toast.LENGTH_LONG).show()
//            var weight = etWeight.text.toString()
//            var height = etHieght.text.toString()
//
//            if(weight.isEmpty()){
//                etWeight.error = "*This field is required"
//            }
//            if (height.isEmpty()){
//                etHieght.error="*This field is required"
//            }
////            if (height.isNotEmpty() && weight.isNotEmpty()){
////                calcBMI()
////            }
// }

    }
    fun btnRequire() {
        var weight = etWeight.text.toString()
        var height = etHieght.text.toString()

        if (weight.isEmpty()) {
            etWeight.error = "*This field is required"
        }
        if (height.isEmpty()) {
            etHieght.error = "*This field is required"
        }
        if (height.isNotEmpty() && weight.isNotEmpty()) {
           CalcBMI()

        }

    }


    fun CalcBMI(){
        var inputHieght = etHieght.text.toString().toFloat()
        var inputWeight = etWeight.text.toString().toFloat()


         var totleHieght = inputHieght*inputHieght
//        totleHieght= totleHieght*totleHieght
//         var totleWeight = (inputWeight*1000)/400

        var Bmi = (inputWeight/totleHieght)*10000

        var RoundBmi = (Bmi*10.0).roundToInt()/10.0

         tvBmi.text = "Your BMI is: - $RoundBmi"
        tvBmi.visibility = View.VISIBLE


        if(RoundBmi<=18.5){
            tvBmiText.text = "You are Underweight"
            tvBmiText.visibility= View.VISIBLE

        }
        else if (RoundBmi>18.5 || Bmi<=24.9){
            tvBmiText.text = "Your Weight is Normal"
            tvBmiText.visibility= View.VISIBLE
        }
        else if (RoundBmi>25 || Bmi<=29.9){
            tvBmiText.text = "You are Overweight"
            tvBmiText.visibility= View.VISIBLE
        }
        else{
            tvBmiText.text ="Obisity"
            tvBmiText.visibility =View.VISIBLE
        }

//        Toast.makeText(this, "$Bmi", Toast.LENGTH_LONG).show()

    }



}





