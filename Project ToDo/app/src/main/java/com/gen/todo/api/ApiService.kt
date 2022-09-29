package com.gen.todo.api

import com.gen.todo.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET ("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

}