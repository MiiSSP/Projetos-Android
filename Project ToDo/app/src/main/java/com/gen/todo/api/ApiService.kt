package com.gen.todo.api

import com.gen.todo.model.Categoria
import com.gen.todo.model.Tarefa
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET ("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @GET ("tarefa")
    suspend fun listTarefa(): Response<List<Tarefa>>

    @POST ("tarefa")
    suspend fun addTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @PUT ("tarefa")
    suspend fun updateTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @DELETE ("tarefa/{id}")
    suspend fun deleteTarefa(
        @Path ("id") id: Long
    ): Response<Tarefa>
}