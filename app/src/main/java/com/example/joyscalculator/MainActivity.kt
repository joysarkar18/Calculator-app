package com.example.joyscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.joyscalculator.databinding.ActivityMainBinding
import java.util.zip.Inflater

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    var operaCnt = false
    fun onClk(view:View){

        if(view is Button){
            if(binding.working.text=="Text hare"){
                binding.working.text =""
            }
            if(binding.working.text.length==20){
                Toast.makeText(this , "limit exied" , Toast.LENGTH_SHORT).show()
                return
            }
            if(view.text=="+" || view.text == "-" || view.text=="/" || view.text == "*" || view.text=="%" || view.text=="^"){
                if(operaCnt){
                    Toast.makeText(this , "Only add One operation" , Toast.LENGTH_SHORT).show()
                    return

                }
                operaCnt = true;

            }
            binding.working.append(view.text)

        }

    }

    fun onClear(view: View){
        binding.working.text = ""
        binding.result.text = "0"
        operaCnt = false
    }

    fun onEqual(view: View){
        if(binding.working.text==""){
            return;
        }
        var typedOp = ""

        for(i in binding.working.text){
            if(i=='+' || i=='-' || i=='/' || i=='*' || i=='%' || i=='^'){
                typedOp +=i
                break
            }

        }


        if(typedOp=="+"){
            val arr = binding.working.text.split("+")
            val num1 = arr[0].toDouble()
            val num2 = arr[1].toDouble()
            val ans = num1 + num2
            binding.result.text = ans.toString()
            return

        }
        if(typedOp=="-"){
            val arr = binding.working.text.split("-")
            val num1 = arr[0].toDouble()
            val num2 = arr[1].toDouble()
            val ans = num1 - num2
            binding.result.text = ans.toString()
            return

        }

        if(typedOp=="*"){
            val arr = binding.working.text.split("*")
            val num1 = arr[0].toDouble()
            val num2 = arr[1].toDouble()
            val ans = num1 * num2
            binding.result.text = ans.toString()
            return

        }

        if(typedOp=="/"){
            val arr = binding.working.text.split("/")
            val num1 = arr[0].toDouble()
            val num2 = arr[1].toDouble()
            if(num2==0.0){
                binding.result.text = "Invalid"
                return

            }
            val ans = num1 / num2
            binding.result.text = ans.toString()
            return

        }

        if(typedOp=="^"){
            val arr = binding.working.text.split("^")
            val num1 = arr[0].toDouble()
            val num2 = arr[1].toDouble()
            val ans = Math.pow(num1,num2)
            binding.result.text = ans.toString()
            return

        }

        if(typedOp=="%"){
            val arr = binding.working.text.split("%")
            val num1 = arr[0].toDouble()
            val num2 = arr[1].toDouble()
            val ans = num1 * (num2/100)
            binding.result.text = ans.toString()
            return

        }

    }


    fun onBack(view: View){
        var ln = binding.working.text.length
        if(ln==0){
            return
        }
        if(ln==1){
            binding.working.text = ""
            binding.result.text="0"
        }
        else{
            binding.working.text = binding.working.text.subSequence(0,ln-1)
        }


    }

}