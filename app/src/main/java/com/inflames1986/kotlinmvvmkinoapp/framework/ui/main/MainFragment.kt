package com.inflames1986.kotlinmvvmkinoapp.framework.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.inflames1986.kotlinmvvmkinoapp.AppState
import com.inflames1986.kotlinmvvmkinoapp.R
import com.inflames1986.kotlinmvvmkinoapp.databinding.MainFragmentBinding
import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val observer = Observer<AppState> { renderData(it) }
        viewModel.getLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getFilm()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                val filmData = appState.filmData
                progressBar.visibility = View.GONE
                filmGroup.visibility = View.VISIBLE
                setData(filmData)
            }
            is AppState.Loading -> {
                filmGroup.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                filmGroup.visibility = View.INVISIBLE
                Snackbar
                    .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getFilm() }
                    .show()
            }
        }
    }

    private fun setData(filmData: FilmInfo) = with(binding) {
        filmTitle.text = filmData.film_title.film
        filmYear.text = filmData.film_year.toString()
        filmBudget.text = filmData.film_budget.toString()

//        GenreLabel.text = String.format(
//            getString(R.string.Genre),
//            filmData.film_title,
//        )
//        filmYear.text = filmData.toString()
//        imdbValue.text = filmData.toString()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}