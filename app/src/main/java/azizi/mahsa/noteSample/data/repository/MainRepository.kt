package azizi.mahsa.noteSample.data.repository


import azizi.mahsa.noteSample.data.database.NoteDao
import azizi.mahsa.noteSample.data.model.NoteEntity
import javax.inject.Inject

class MainRepository @Inject constructor(private val dao: NoteDao) {
    fun allNotes() = dao.getAllNotes()
    fun searchNotes(search: String) = dao.searchNote(search)
    fun filterNotes(filter: String) = dao.filetNote(filter)
    suspend fun deleteNote(entity: NoteEntity) = dao.deleteNote(entity)
}