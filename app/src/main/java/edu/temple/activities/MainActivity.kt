package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val SIZE_KEY = "TEXT_SIZE_VALUE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create array of integers that are multiples of 5
        val textSizes = Array(20) { (it + 1) * 5 }

        Log.d("Array values", textSizes.contentToString())

        with(findViewById<RecyclerView>(R.id.textSizeSelectorRecyclerView)) {
            adapter = TextSizeAdapter(textSizes) { selectedSize ->
                startActivity(
                    Intent(this@MainActivity, DisplayActivity::class.java).apply {
                        putExtra(SIZE_KEY, selectedSize) // Pass the selected size correctly
                    }
                )
            }
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}

/* RecyclerView Adapter */
class TextSizeAdapter(private val textSizes: Array<Int>, private val callback: (Int) -> Unit) :
    RecyclerView.Adapter<TextSizeAdapter.TextSizeViewHolder>() {

    inner class TextSizeViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {
        init {
            textView.setOnClickListener {
                callback(textSizes[adapterPosition]) // Send selected text size back
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSizeViewHolder {
        return TextSizeViewHolder(TextView(parent.context).apply { setPadding(5, 20, 0, 20) })
    }

    override fun onBindViewHolder(holder: TextSizeViewHolder, position: Int) {
        holder.textView.apply {
            text = textSizes[position].toString()
            textSize = textSizes[position].toFloat()
        }
    }

    override fun getItemCount(): Int = textSizes.size
}









