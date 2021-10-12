package com.inflames1986.kotlinmvvmkinoapp.framework.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.inflames1986.kotlinmvvmkinoapp.databinding.FragmentMainRecyclerItemBinding
import com.inflames1986.kotlinmvvmkinoapp.framework.ui.main.MainFragment
import com.inflames1986.kotlinmvvmkinoapp.model.entities.FilmInfo


class MainFragmentAdapter(private val itemClickListener: MainFragment.OnItemViewClickListener) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var filmData: List<FilmInfo> = listOf()
    private lateinit var binding: FragmentMainRecyclerItemBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setFilm(data: List<FilmInfo>) {
        filmData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = FragmentMainRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(filmData[position])
    }

    override fun getItemCount() = filmData.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(filmInfo: FilmInfo) = with(binding) {
            mainFragmentRecyclerItemTextView.text = filmInfo.film_title.film
            Glide.with(mainFragmentRecyclerItemImageView).load(filmInfo.film_title.image).into(mainFragmentRecyclerItemImageView)
            root.setOnClickListener { itemClickListener.onItemViewClick(filmInfo) }
        }
    }
}