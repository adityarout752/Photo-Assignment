package com.example.photoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)

abstract class PhotoDB : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    companion object {

        @Volatile
        private var INSTANCE: PhotoDB? = null

        fun getDatabase(context: Context): PhotoDB {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhotoDB::class.java,
                    "photo_db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
