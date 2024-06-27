package azizi.mahsa.noteSample.ui.main.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import azizi.mahsa.noteSample.data.model.NoteEntity
import azizi.mahsa.noteSample.databinding.FragmentNoteBinding
import azizi.mahsa.noteSample.utils.setupListWithAdapter
import azizi.mahsa.noteSample.viewmodel.NoteViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteFragment :BottomSheetDialogFragment() {
    //Binding
    private  var _binding : FragmentNoteBinding? = null
    private val binding get() = _binding
    //Others
    private val viewModel : NoteViewModel by viewModels()
    private var category = ""
    private var priority = ""
    @Inject
    lateinit var entity: NoteEntity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding=FragmentNoteBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //InitView
        binding?.apply {
            //Close
            closeImg.setOnClickListener { dismiss() }
            //Spinners
            viewModel.loadCategoriesData()
            viewModel.categoriesList.observe(viewLifecycleOwner){
                categoriesSpinner.setupListWithAdapter(it){itItem->
                    category= itItem
                }
            }
            //Spinner priority
            viewModel.loadPrioritiesData()
            viewModel.prioritiesList.observe(viewLifecycleOwner){
                prioritySpinner.setupListWithAdapter(it) {itItem->
                    priority=itItem

                }
            }
            //Click
            saveNote.setOnClickListener {
                val title = titleEdt.text.toString()
                val desc = descEdt.text.toString()
                entity.id = 0
                entity.title = title
                entity.desc = desc
                entity.category = category
                entity.priority = priority

                if (title.isNotEmpty() && desc.isNotEmpty()) {
                    viewModel.saveEditNote(false, entity)
                }

                dismiss()
            }
        }
    }
    override fun onStop() {
        super.onStop()
        _binding = null
    }
}