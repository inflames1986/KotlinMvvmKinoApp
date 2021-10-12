package com.inflames1986.kotlinmvvmkinoapp.framework.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inflames1986.kotlinmvvmkinoapp.databinding.DetailsFragmentBinding
import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo

class DetailsFragment : Fragment() {
    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<FilmInfo>(BUNDLE_EXTRA)?.let {
            with(binding) {
                val film = it.film_title
                filmTitle.text = film.film
                filmGenre.text = film.genre
                filmImdbValue.text = film.imdb.toString()
                filmBudgetValue.text = it.film_budget.toString()
                filmYear.text = it.film_year.toString()

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val BUNDLE_EXTRA = "filminfo"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}