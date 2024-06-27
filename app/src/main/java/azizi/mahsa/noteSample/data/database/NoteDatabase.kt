package azizi.mahsa.noteSample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import azizi.mahsa.noteSample.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}