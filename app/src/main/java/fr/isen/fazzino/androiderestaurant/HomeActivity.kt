package fr.isen.fazzino.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initButtons()
    }

    fun initButtons() {
        val btnStarter = findViewById<Button>(R.id.buttonStarter)
        btnStarter.setOnClickListener {
            goToStarter()
        }

        val btnMainCourse = findViewById<Button>(R.id.buttonMainCourse)
        btnMainCourse.setOnClickListener {
            goToMainCourse()
        }

        val btnDessert = findViewById<Button>(R.id.buttonDessert)
        btnDessert.setOnClickListener {
            goToDessert()
        }
    }
    fun goToStarter(){
        //Toast.makeText(this@HomeActivity, "you clicked on starter dish", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, StarterActivity::class.java)
        startActivity(intent)
    }

    fun goToMainCourse(){
        //Toast.makeText(this@HomeActivity, "you clicked on starter dish", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainCourseActivity::class.java)
        startActivity(intent)
    }

    fun goToDessert(){
        //Toast.makeText(this@HomeActivity, "you clicked on starter dish", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DessertActivity::class.java)
        startActivity(intent)
    }
}