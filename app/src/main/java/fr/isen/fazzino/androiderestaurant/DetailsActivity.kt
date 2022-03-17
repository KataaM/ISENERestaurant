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
import fr.isen.fazzino.androiderestaurant.databinding.ActivityDetailsBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.json.JSONObject


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val categoryName = intent.getStringExtra(HomeActivity.CATEGORY_KEY)
        val detailsParagraph = intent.getStringExtra(CategoryActivity.DISH_NAME_KEY)


        val dataDishSerializedString = intent.getSerializableExtra(CategoryActivity.DATA_DISH_OBJECT_KEY) as DataDish


        //TODO Essayer de récupérer l'objet dataDish à travers l'intent ? c'est relou
//        val dataDishObject = Json.decodeFromString<DataDish>(dataDishSerializedString as String)


//        val dishName = dataDishObject?.data?.find { categoryData -> categoryData.name_fr == categoryName }

        binding.detailsTitle.text = dataDishSerializedString.data.get(0).name_fr
//        binding.detailsParagraph.text = dishName?.name_fr



//        val dishName: Category? =
//            dataDish?.data?.find { categoryData -> categoryData.name_fr == categoryName }

    }
}