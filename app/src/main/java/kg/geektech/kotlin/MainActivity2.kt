package kg.geektech.kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.kotlin.Constant.KEY
import kg.geektech.kotlin.Constant.KEY2
import kg.geektech.kotlin.databinding.ActivityEmptyBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityEmptyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etTitle1.setText(intent.getStringExtra(KEY))

        binding.btn1.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(
                    KEY2, binding.etTitle1
                        .text.toString()
                )
            )
            finish()
        }
    }
}