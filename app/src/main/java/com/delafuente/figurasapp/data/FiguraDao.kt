package com.delafuente.figurasapp.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

interface FiguraDao {
    @Dao
    interface FiguraDao {
        @Query("SELECT * FROM figuras")
        fun getAllFiguras(): Flow<List<Figura>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertFiguras(figuras: List<Figura>)
    }

    @Database(entities = [Figura::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun figuraDao(): FiguraDao
    }
}