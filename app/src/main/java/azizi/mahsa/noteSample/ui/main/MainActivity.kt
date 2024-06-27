package azizi.mahsa.noteSample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.viewModels
import azizi.mahsa.noteSample.data.model.NoteEntity
import azizi.mahsa.noteSample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //Binding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    // @Inject
    // lateinit var notesAdapter: NoteAdapter

    @Inject
    lateinit var noteEntity: NoteEntity

    //Other
    // private val viewModel: MainViewModel by viewModels()
    //  private var selectedItem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //InitViews
        binding?.apply {}
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}