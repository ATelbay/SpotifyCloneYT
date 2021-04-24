package com.plcoding.spotifycloneyt.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.plcoding.spotifycloneyt.data.entity.Song
import com.plcoding.spotifycloneyt.util.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import java.lang.Exception

class AppDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs() = try {
        songCollection.get().await().toObjects(Song::class.java)
    } catch (e: Exception) {
        Timber.e(e)
        emptyList()
    }


}