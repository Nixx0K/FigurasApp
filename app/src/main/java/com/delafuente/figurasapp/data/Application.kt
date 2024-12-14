package com.delafuente.figurasapp.data
import android.app.Application
import androidx.room.Room

class MyApplication : Application() {

    companion object {
        private var instance: MyApplication? = null

        fun getInstance(): MyApplication {
            return instance ?: throw IllegalStateException("Application not created yet!")
        }
    }

    lateinit var database: FiguraDao.AppDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this

        database = Room.databaseBuilder(
            this, // Contexto seguro
            FiguraDao.AppDatabase::class.java,
            "figuras_db"
        ).build()
    }
}

