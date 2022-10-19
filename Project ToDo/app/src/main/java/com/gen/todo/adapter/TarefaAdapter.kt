package com.gen.todo.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gen.todo.MainViewModel
import com.gen.todo.databinding.CardLayoutBinding
import com.gen.todo.model.Tarefa
import java.text.SimpleDateFormat

class TarefaAdapter(

    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel,
    val context: Context

): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>()
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

        holder.itemView.setOnClickListener{
            taskClickListener.onTaskClickListener(tarefa)
        }

        holder.binding.Switch
            .setOnCheckedChangeListener { compoundButton, ativo ->
                tarefa.status = ativo
                mainViewModel.updateTarefa(tarefa)
            }

        holder.binding.buttonDelete.setOnClickListener{
            showAlertDialog(tarefa.id)
        }
    }

    override fun getItemCount(): Int {
        return listTarefa.size
    }

    fun setList(list: List<Tarefa>){
        listTarefa = list.sortedByDescending { it.id }
        notifyDataSetChanged()
    }

   private fun showAlertDialog(id: Long){
       AlertDialog.Builder(context)
           .setTitle("Excluir Tarefa")
           .setMessage("Realmente deseja excluir a tarefa??")
           .setPositiveButton("Sim"){
               _,_ -> mainViewModel.deleteTarefa(id)
           }
           .setNegativeButton("Não"){
               _,_ ->
           }.show()
    }
}

