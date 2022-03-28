package fr.isen.fazzino.androiderestaurant

import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import fr.isen.fazzino.androiderestaurant.data.Dish
import fr.isen.fazzino.androiderestaurant.databinding.ActivityDetailsBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt


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
        binding.imageSlider.setPageTransformer(DephtPageTransformer()) //Set the transformer for smoooooooth transition between images

        binding.priceButton.text = "Total : " + dataDish.prices[0].price.toString() + " €"
//        binding.detailsParagraph.text = dishName?.name_fr
//        val dishName: Category? =
//            dataDish?.data?.find { categoryData -> categoryData.name_fr == categoryName }


        binding.quantityTextView.text = "1"

        setUpListener()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
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

        binding.priceButton.setOnClickListener {
            addToCart()
        }
    }

    fun refreshTextView(count : Float){
        val dataDish =
            intent.getSerializableExtra(CategoryActivity.DATA_DISH_OBJECT_KEY) as Dish

        val price = count * dataDish.prices[0].price
        binding.quantityTextView.text = count.roundToInt().toString()
        binding.priceButton.text = "Total : " + price.toString() + " €"
    }

    fun addToCart(){
        var zz = ArrayList<String>()

//        zz.add("a")
//        zz.add("a")
//        zz.add("a")
//
//        val gson =GsonBuilder().setPrettyPrinting().create()
//        val jsonPath = "C:\\Users\\Greg\\git\\ISENERestaurant\\app\\src\\main\\java\\fr\\isen\\fazzino\\androiderestaurant\\jsonFile.json"
//        File(jsonPath).createNewFile()
//        val file = File(jsonPath)
//        file.writeText("gson.toJson(zz")


//        val sharedPref = this.getSharedPreferences(SHAREDFILENAME, Context.MODE_PRIVATE)
//        val editSharePref = sharedPref.edit()
//        editSharePref.putInt(DetailsActivity.CART_ITEM_COUNT,0)
//        editSharePref.commit()

        //TODO CA CEST LES SHAREPREF MAIS GENRE IL FAUT CREER UNE CARTE ACTIVITE RELIER A TOUTES LES ACTIVITES
        //TODO JE PENSE QUE LES SHARED PREFS MARCHE faut juste set à 0 de base et après ça ajoute au fur et à mesure qu'on ajoute dans le panier.

        //TODO En fait j'ai pas finis :)

        val sharedPref = this.getSharedPreferences(SHARED_FILENAME, Context.MODE_PRIVATE)
        val editSharePref = sharedPref.edit()
        editSharePref.putInt(CART_ITEM_COUNT,sharedPref.getInt(CART_ITEM_COUNT,0)+1)
        editSharePref.apply()
    }

    companion object {
        const val CART_ITEM_COUNT = "cart_item_count"
        const val SHARED_FILENAME = "mySharedFile"

    }

}