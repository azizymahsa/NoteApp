package azizi.mahsa.noteSample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import azizi.mahsa.noteSample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //InitViews
        binding.apply {

        }
    }
}