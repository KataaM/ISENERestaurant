package fr.isen.fazzino.androiderestaurant

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.CategoryAdapter

class DetailsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val detailsTitle=intent.getStringExtra(CategoryActivity.DETAILS_TITLE_KEY)
        val detailsParagraph=intent.getStringExtra(CategoryActivity.DETAILS_TITLE_PARA
        )

        val detailsTitleTextView = findViewById<TextView>(R.id.detailsTitle)
        detailsTitleTextView.text = detailsTitle;

        val detailsParagraphTextView = findViewById<TextView>(R.id.detailsTitle)
        detailsParagraphTextView.text = detailsParagraph;
    }
}