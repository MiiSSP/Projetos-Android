package com.gen.sqliteroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.gen.sqliteroom.data.UserDatabase
import com.gen.sqliteroom.data.UserRepository
import com.gen.sqliteroom.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (application: Application): AndroidViewModel(application) {

    val selectUsers: LiveData<List<Usuario>>
    val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        selectUsers = repository.selectUsers
    }

    fun addUser (usuario: Usuario) {
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(usuario)
        }
    }
}