package com.example.task.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUser(private val context: Context) {


    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("User")
        val USER_KEY = stringPreferencesKey("user")
    }


    val getUser: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_KEY] ?: ""
        }


    suspend fun saveUser(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_KEY] = name
        }
    }
}