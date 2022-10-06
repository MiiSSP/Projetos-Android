package com.gen.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gen.todo.databinding.CardLayoutBinding
import com.gen.todo.model.Tarefa
import java.text.SimpleDateFormat

class TarefaAdapter: RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>()
{
    private var listTarefa = emptyList<Tarefa>()

    class TarefaViewHolder (val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listTarefa [position]

        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textResponsavel.text = tarefa.responsavel
        val formatter = SimpleDateFormat("yyyy-mm-dd")
        val date = formatter.parse(tarefa.data)
        holder.binding.textData.text = formatter.format(date!!)
        holder.binding.Switch.isChecked = tarefa.status
        holder.binding.textCategoria.text = tarefa.categoria.descricao
    }

    override fun getItemCount(): Int {
        return listTarefa.size
    }

    fun setList(list: List<Tarefa>){
        listTarefa = list
        notifyDataSetChanged()
    }

}

