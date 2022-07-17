package com.example.trendingprojects.repositories.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trendingprojects.repositories.domain.Projects


const val DB_VERSION = 1
const val DB_NAME = "sadapay_database"

@Database(
    entities = [Projects::class],
    version = DB_VERSION,
    exportSchema = false
)

abstract class RoomDb : RoomDatabase() {
    abstract fun trendingProjectsDao(): ProjectsDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDb? = null

        fun getDatabase(context: Context): RoomDb =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RoomDb::class.java, DB_NAME
            ).build()

    }
}