package com.example.figuras.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.delafuente.figurasapp.data.Figura
import com.delafuente.figurasapp.R
import com.delafuente.figurasapp.databinding.FragmentListBinding
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView
        val adapter = FiguraAdapter { figura ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(figura.id)
            findNavController().navigate(action)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        // Cargar datos desde Room o un ViewModel
        lifecycleScope.launch {
            val figuras = listOf(
                Figura(1, "Figura 1", "url_logo", null, null, null, null, null, true, 10.0),
                Figura(2, "Figura 2", "url_logo", null, null, null, null, null, true, 20.0)
            ) // Simulación de datos
            adapter.submitList(figuras)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
