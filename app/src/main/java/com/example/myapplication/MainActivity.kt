package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityMainBinding.inflate
import net.objecthunter.exp4j.ExpressionBuilder
class MainActivity : AppCompatActivity() {
    public lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
       binding.tvOne.setOnClickListener { appendOnExpresstion("1", true) }
        binding.tvTwo.setOnClickListener { appendOnExpresstion("2", true) }
        binding.tvThree.setOnClickListener { appendOnExpresstion("3", true) }
        binding.tvFour.setOnClickListener { appendOnExpresstion("4", true) }
        binding.tvFive.setOnClickListener { appendOnExpresstion("5", true) }
        binding.tvSix.setOnClickListener { appendOnExpresstion("6", true) }
        binding.tvSeven.setOnClickListener { appendOnExpresstion("7", true) }
        binding.tvEight.setOnClickListener { appendOnExpresstion("8", true) }
        binding.tvNine.setOnClickListener { appendOnExpresstion("9", true) }
        binding.tvZero.setOnClickListener { appendOnExpresstion("0", true) }
        binding.tvDot.setOnClickListener { appendOnExpresstion(".", true) }
        binding.tvPlus.setOnClickListener { appendOnExpresstion("+", false) }
        binding.tvMinus.setOnClickListener { appendOnExpresstion("-", false) }
        binding.tvMul.setOnClickListener { appendOnExpresstion("*", false) }
        binding.tvDivide.setOnClickListener { appendOnExpresstion("/", false) }
        binding.tvOpen.setOnClickListener { appendOnExpresstion("(", false) }
        binding.tvClose.setOnClickListener { appendOnExpresstion(")", false) }
        binding.tvBack.setOnClickListener()
        {
            val s=binding.tvExpression.text.toString()
            if(s.isNotEmpty())
            {
                binding.tvExpression.text=s.substring(0,s.length-1)
            }
            binding.tvResult.text=""

        }
        binding.tvClear.setOnClickListener()
        {
            binding.tvExpression.text=""
            binding.tvResult.text=""
        }
        binding.tvEquals.setOnClickListener()
        {
            try {
            val i=ExpressionBuilder(binding.tvExpression.text.toString()).build()
                val res=i.evaluate()
                val longres=res.toLong()
                if(res==longres.toDouble())
                {
                    binding.tvResult.text=longres.toString()
                }
                else
                    binding.tvResult.text=res.toString()
            }
            catch (e:Exception)
            {
                Log.d("Exception"," message : " + e.message )
            }
            }

        }

    fun appendOnExpresstion(sa: String, b: Boolean) {
        if(binding.tvResult.text.isNotEmpty())
        {
            binding.tvExpression.text=""
        }
        if(b)
        {
            binding.tvResult.text=""
            binding.tvExpression.append(sa)
        }
        else
        {
            binding.tvExpression.append(binding.tvResult.text)
            binding.tvExpression.append(sa)
            binding.tvResult.text=""
        }
    }
}

