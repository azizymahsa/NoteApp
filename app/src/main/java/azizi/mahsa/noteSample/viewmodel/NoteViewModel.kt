package azizi.mahsa.noteSample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azizi.mahsa.noteSample.data.model.NoteEntity
import azizi.mahsa.noteSample.data.repository.NoteRepository
import azizi.mahsa.noteSample.utils.EDUCATION
import azizi.mahsa.noteSample.utils.HEALTH
import azizi.mahsa.noteSample.utils.HIGH
import azizi.mahsa.noteSample.utils.HOME
import azizi.mahsa.noteSample.utils.LOW
import azizi.mahsa.noteSample.utils.NORMAL
import azizi.mahsa.noteSample.utils.WORK
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
    //Spinners
    val categoriesList = MutableLiveData<MutableList<String>> ()
    val prioritiesList = MutableLiveData<MutableList<String>> ()

    fun loadCategoriesData() = viewModelScope.launch(Dispatchers.IO) {
       val data = mutableListOf(WORK, EDUCATION, HOME, HEALTH)
        categoriesList.postValue(data)
    }
    fun loadPrioritiesData() = viewModelScope.launch(Dispatchers.IO){
        val data = mutableListOf(HIGH , NORMAL, LOW)
        prioritiesList.postValue(data)
    }
    fun saveEditNote(isEdit: Boolean, entity: NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        if (isEdit) {
            repository.updateNote(entity)
        } else {
            repository.saveNote(entity)
        }
    }
}