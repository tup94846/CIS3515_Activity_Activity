package edu.temple.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Extract transferred value and apply it to the TextView
        with(findViewById<TextView>(R.id.lyricsDisplayTextView)) {
            textSize = intent.getIntExtra(SIZE_KEY, 22).toFloat() // Corrected default value
        }
    }
}
