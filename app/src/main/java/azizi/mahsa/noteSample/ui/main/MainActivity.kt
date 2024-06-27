package azizi.mahsa.noteSample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import azizi.mahsa.noteSample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Binding
    private  var _binding: ActivityMainBinding ?= null
    private  val binding get() = _binding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding ?.root)
        //InitViews
        binding?.apply {

        }

    }
    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}