package azizi.mahsa.noteSample.data.repository


import azizi.mahsa.noteSample.data.database.NoteDao
import javax.inject.Inject

class MainRepository @Inject constructor(private val dao: NoteDao) {
    fun allNotes() = dao.getAllNotes()

}