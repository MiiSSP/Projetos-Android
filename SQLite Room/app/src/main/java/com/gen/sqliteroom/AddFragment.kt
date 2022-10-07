package com.gen.sqliteroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gen.sqliteroom.data.Usuario
import com.gen.sqliteroom.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonSalvar.setOnClickListener {
            inserirNoBanco()
        }

        return binding.root
        }

        private fun verificarCampos(nome: String, sobrenome: String, idade: String): Boolean{
        return !(
                        (nome == "" || nome.length < 3 || nome.length > 20 ) ||
                        ( sobrenome == "" || sobrenome.length < 3 || sobrenome.length > 50 ) ||
                        ( idade == "" )
                )
        }

    private fun inserirNoBanco(){
        val nome = binding.editNome.text.toString()
        val sobrenome = binding.editSobrenome.text.toString()
        val idade = binding.editIdade.text.toString()


        if(verificarCampos(nome, sobrenome, idade)){
            val user = Usuario(0, nome, sobrenome, idade.toInt())
            mainViewModel.addUser(user)
            Toast.makeText(context, "Usuario Adicionado!!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)


        }else{
            Toast.makeText(context, "Verifique se todos os campos estão preenchidos!!", Toast.LENGTH_SHORT).show()}
    }

}