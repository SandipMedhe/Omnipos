package com.example.task.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//datastore preference class to hold the user is logged in or not
class StoreUser(private val context: Context) {


    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("User")
        val USER_KEY = stringPreferencesKey("user")
    }

    //Function to get the user data
    val getUser: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_KEY] ?: ""
        }

    //Function to save the user in database preferences
    suspend fun saveUser(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_KEY] = name
        }
    }

    suspend fun clear(){
        context.dataStore.edit {
            clear()
        }
    }

}