package ccom.delafuente.figurasapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.delafuente.figurasapp.databinding.RecyclerView.FiguraAdapter

class DetailFragment : Fragment() {

    private var _binding: FiguraAdapter? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FiguraAdapter.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val figuraId = args.figuraId
        // Aquí puedes cargar detalles del producto usando el ID
        binding.detalleTexto.text = "Detalle de figura ID: $figuraId"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}