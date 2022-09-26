package com.gen.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gen.todo.adapter.TarefaAdapter
import com.gen.todo.model.Tarefa
import com.gen.todo.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

       val listTarefas = listOf(
            Tarefa
                (
                "Estudar para prova",
                "Estudar sobre ResMat e MecFlu para as provas",
                "Milena",
                "2022-09-26",
                true,
                "Acadêmicos"
                ),

            Tarefa
                (
                "Limpar Gatos",
                "Limpar todas as caixas de areias dos gatos",
                "Leila",
                "2022-09-28",
                false,
                "Limpeza Pets"
                ),

            Tarefa
                (
                    "Lavar Louça",
                "Lavar todas as louças que forem usadas ao longo do dia",
                "Manoel",
                "2022-09-28",
                true,
                "Limpeza Casa"
                )
        )

        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager (context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        adapter.setList(listTarefas)

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }

}