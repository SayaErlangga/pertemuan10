package com.example.pertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val adapterRestaurant = RestaurantAdapter(generateRestaurant()) {
            restaurant -> Toast.makeText(this@MainActivity, "Hei! You clicked on ${restaurant.name}", Toast.LENGTH_SHORT).show()
        }
        setContentView(binding.root)
        with(binding){
            rvRestaurants.apply {
                adapter = adapterRestaurant
                layoutManager = GridLayoutManager(this@MainActivity, 2)
//                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateRestaurant() : List<Restaurant>{
        return listOf(
            Restaurant(name="McDonalds", type = "Western"),
            Restaurant(name="Bornga", type = "Korean"),
            Restaurant(name="Sushi Tei", type = "Japanese"),
            Restaurant(name="Mas Kobis", type = "Javanese"),
            Restaurant(name="Leko", type = "Indonesian")
        )
    }
}