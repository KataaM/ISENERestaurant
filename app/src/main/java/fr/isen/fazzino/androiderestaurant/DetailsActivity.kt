package fr.isen.fazzino.androiderestaurant

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.fazzino.androiderestaurant.data.DataDish
import fr.isen.fazzino.androiderestaurant.databinding.ActivityDetailsBinding
import org.json.JSONObject


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailsTitle = intent.getStringExtra(CategoryActivity.DETAILS_TITLE_KEY)
        val detailsParagraph = intent.getStringExtra(
            CategoryActivity.DETAILS_TITLE_PARA
        )

        binding.detailsTitle.text = detailsTitle
        binding.detailsParagraph.text = detailsTitle
    }
}