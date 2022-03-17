package fr.isen.fazzino.androiderestaurant

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.fazzino.androiderestaurant.data.Category
import fr.isen.fazzino.androiderestaurant.data.DataDish
import fr.isen.fazzino.androiderestaurant.data.Dish
import fr.isen.fazzino.androiderestaurant.databinding.ActivityDetailsBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.util.*


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataDish =
            intent.getSerializableExtra(CategoryActivity.DATA_DISH_OBJECT_KEY) as Dish

        binding.detailsTitle.text = dataDish.name_fr

        binding.detailsParagraph.text = dataDish.ingredients.joinToString(", ") {
            it.name_fr.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            }
        }


        binding.imageSlider.adapter = DetailImagePager(this,dataDish.images)

        binding.priceButton.text = dataDish.prices[0].price.toString() + " €"
//        binding.detailsParagraph.text = dishName?.name_fr
//        val dishName: Category? =
//            dataDish?.data?.find { categoryData -> categoryData.name_fr == categoryName }


        binding.quantityTextView.text = "1"

        setUpListener()
    }

    fun setUpListener(){
        var count = 1.0f

        binding.removeButton.setOnClickListener {
            if (count > 1){
                count--
            }
            refreshTextView(count)
        }

        binding.addButton.setOnClickListener {
            count++
            refreshTextView(count)
        }
    }

    fun refreshTextView(count : Float){
        val dataDish =
            intent.getSerializableExtra(CategoryActivity.DATA_DISH_OBJECT_KEY) as Dish

        val price = count * dataDish.prices[0].price
        binding.quantityTextView.text = count.toString()
        binding.priceButton.text = price.toString() + " €"
    }
}