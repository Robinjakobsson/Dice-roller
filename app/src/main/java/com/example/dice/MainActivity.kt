package com.example.dice
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var rollbutton: Button
    private lateinit var tvNumber: TextView
    private lateinit var diceImageView: ImageView

    private val diceImages = listOf(
        R.drawable.ett,
        R.drawable.tva,
        R.drawable.tre,
        R.drawable.fyra,
        R.drawable.fem,
        R.drawable.sex,
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            rollbutton = findViewById(R.id.rollButton)
            tvNumber = findViewById(R.id.tvNumber)
            diceImageView = findViewById(R.id.diceImageView)

        rollbutton.setOnClickListener {
            val randomIndex = Random.nextInt(diceImages.size)
            diceImageView.setImageResource(diceImages[randomIndex])
            tvNumber.text = (randomIndex + 1).toString()




        }


    }
}