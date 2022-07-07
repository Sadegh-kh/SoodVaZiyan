package com.example.soodvaziyan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.soodvaziyan.databinding.ActivityMain2Binding

const val KEY_INTENT_VALUE = "value"

class MainActivity2() : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var Darsad = 0
    var valueGheymat = 0
    var valueFroush = 0
    var valueBedehi = 0
    var valueKrayemghaze = 0
    var valueSoodKol = 0
    var valueBedhiKol = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonEnd.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            if (binding.texteditForush.editText!!.length() == 0) {
                binding.texteditForush.error = "لطفا مقدار بدهید"
            } else if (binding.texteditGheymatkala.editText!!.length() == 0) {
                binding.texteditGheymatkala.error = "لطفا مقدار بدهید"
            } else if (binding.texteditBedehi.editText!!.length() == 0) {
                binding.texteditBedehi.error = "لطفا مقدار بدهید"
            } else if (binding.texteditKraye.editText!!.length() == 0) {
                binding.texteditKraye.error = "لطفا مقدار بدهید"
            } else {
                val SoodVaziyan = mohasbeSoodVaZiyan(valueSoodKol, valueBedhiKol)
                intent.putExtra(KEY_INTENT_VALUE,SoodVaziyan)
                startActivity(intent)

            }

        }
        edittextCheck()
        radioCheck()


    }


    private fun radioCheck() {
        binding.radioGroup.setOnCheckedChangeListener { group, i ->
            when (i) {
                R.id.radioButton_20darsd -> {
                    Darsad = 20
                    soodKoll(Darsad, valueGheymat, valueFroush)
                }
                R.id.radioButton_30darsad -> {
                    Darsad = 30
                    soodKoll(Darsad, valueGheymat, valueFroush)
                }
                R.id.radioButton_50darsad -> {
                    Darsad = 50
                    soodKoll(Darsad, valueGheymat, valueFroush)
                }

            }
        }
    }

    private fun edittextCheck() {
        binding.texteditForush.editText?.addTextChangedListener {
            if (it!!.isNotEmpty()) {
                binding.texteditForush.error = null
                val froosh = it.toString()
                valueFroush = froosh.toInt()
                soodKoll(Darsad, valueGheymat, valueFroush)
            }
        }
        binding.texteditGheymatkala.editText?.addTextChangedListener {
            if (it!!.isNotEmpty()) {
                binding.texteditGheymatkala.error = null
                val ghymatKala = it.toString()
                valueGheymat = ghymatKala.toInt()
                soodKoll(Darsad, valueGheymat, valueFroush)
            }
        }
        binding.texteditBedehi.editText?.addTextChangedListener {
            if (it!!.isNotEmpty()) {
                binding.texteditBedehi.error = null
                val bedehiMaliat = it.toString()
                valueBedehi = bedehiMaliat.toInt()
                bedhiKoll(valueBedehi, valueKrayemghaze)
            }
        }
        binding.texteditKraye.editText?.addTextChangedListener {
            if (it!!.isNotEmpty()) {
                binding.texteditKraye.error = null
                val bedehimKraye = it.toString()
                valueKrayemghaze = bedehimKraye.toInt()
                bedhiKoll(valueBedehi, valueKrayemghaze)
            }
        }

    }

    fun soodKoll(darsad: Int, gheymat: Int, foroosh: Int) {
        val result = ((darsad * gheymat) / 100) * foroosh
        valueSoodKol = result
        mohasbeSoodVaZiyan(valueSoodKol, valueBedehi)

    }

    fun bedhiKoll(bedehiMaliat: Int, bedehiKraye: Int) {
        val result = bedehiKraye + bedehiMaliat
        valueBedhiKol = result
        mohasbeSoodVaZiyan(valueSoodKol, valueBedehi)
    }

    fun mohasbeSoodVaZiyan(sood: Int, bedhi: Int): Int {
        val result = sood - bedhi
        return result
    }


}
