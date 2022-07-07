package com.example.soodvaziyan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.soodvaziyan.databinding.ActivityMain3Binding


class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val checkSoodVaziyan = intent.getIntExtra(KEY_INTENT_VALUE,0)
        if (checkSoodVaziyan>0)
        {
            binding.backgroundMain3.setBackgroundResource(R.drawable.shape_background_end_sood)
            binding.imageViewAlamat.setImageResource(R.drawable.ic_outline_check_24)
            binding.textviewPayamSoodvaziyan.text="تبریک شما سود خواهید کرد"
            binding.textviewValue.text=checkSoodVaziyan.toString()

        }else{
            val text = checkSoodVaziyan.toString()
            binding.backgroundMain3.setBackgroundResource(R.drawable.shape_background_end_zarar)
            binding.imageViewAlamat.setImageResource(R.drawable.ic_baseline_close_24)
            binding.textviewPayamSoodvaziyan.text="متاسفانه شما ضرر خواهید کرد"
            binding.textviewValue.text=text.substring(1,text.length)
        }


    }
}