package com.inflames1986.kotlinmvvmkinoapp.framework.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.inflames1986.kotlinmvvmkinoapp.AppState
import com.inflames1986.kotlinmvvmkinoapp.R
import com.inflames1986.kotlinmvvmkinoapp.databinding.MainFragmentBinding
import com.inflames1986.kotlinmvvmkinoapp.framework.ui.adapters.MainFragmentAdapter
import com.inflames1986.kotlinmvvmkinoapp.framework.ui.details.DetailsFragment
import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private var adapter: MainFragmentAdapter? = null
    private var isDataSetRus: Boolean = true

    private val onItemViewClickListener = object : OnItemViewClickListener {
        override fun onItemViewClick(filmInfo: FilmInfo) {
            val manager = activity?.supportFragmentManager
            manager?.let { manager ->
                val bundle = Bundle().apply {
                    putParcelable(DetailsFragment.BUNDLE_EXTRA, filmInfo)
                }
                manager.beginTransaction()
                    .add(R.id.container, DetailsFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            mainFragmentRecyclerView.adapter = adapter
            mainFragmentFAB.setOnClickListener { changeFilmDataSet() }
            viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
            viewModel.getFilmFromLocalSourceRus()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun changeFilmDataSet() = with(binding) {
        if (isDataSetRus) {
            viewModel.getFilmFromLocalSourceWorld()
            mainFragmentFAB.setImageResource(R.drawable.ic_launcher_foreground)
        } else {
            viewModel.getFilmFromLocalSourceRus()
            mainFragmentFAB.setImageResource(R.drawable.ic_launcher_foreground)
        }
        isDataSetRus = !isDataSetRus
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                mainFragmentLoadingLayout.visibility = View.GONE
                adapter = MainFragmentAdapter(onItemViewClickListener).apply {
                    setWeather(appState.filmData)
                }
                mainFragmentRecyclerView.adapter = adapter
            }
            is AppState.Loading -> {
                mainFragmentLoadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                mainFragmentLoadingLayout.visibility = View.GONE
                Snackbar
                    .make(
                        binding.mainFragmentFAB,
                        getString(R.string.error),
                        Snackbar.LENGTH_INDEFINITE
                    )
                    .setAction(getString(R.string.reload)) { viewModel.getFilmFromLocalSourceRus() }
                    .show()
            }
        }
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(filmInfo: FilmInfo)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}