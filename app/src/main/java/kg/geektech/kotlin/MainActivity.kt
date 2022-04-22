package kg.geektech.kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.kotlin.Constant.KEY
import kg.geektech.kotlin.Constant.KEY2
import kg.geektech.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var register: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btn.setOnClickListener {
                if (etTitle.text.toString().isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.isEmpty),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Intent(this@MainActivity, MainActivity2::class.java).apply {
                        putExtra(KEY, etTitle.text.toString())
                        register.launch(this)
                    }
                }
            }
            register = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                etTitle.setText(result.data?.getStringExtra(KEY2))
            }
        }
    }
}