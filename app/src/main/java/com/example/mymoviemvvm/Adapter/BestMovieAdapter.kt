package com.example.mymoviemvvm.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymoviemvvm.Model.MovieResponse
import com.example.mymoviemvvm.databinding.FragmentBestMovieAdapterBinding

class BestMovieAdapter : RecyclerView.Adapter<BestMovieAdapter.ViewHolder>() {
    private var bestMovieList: List<MovieResponse> = ArrayList()

    fun setMovieList(bestMovieList: List<MovieResponse>) {
        this.bestMovieList = bestMovieList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: FragmentBestMovieAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentBestMovieAdapterBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            Glide.with(holder.itemView)
                .load("https://image.tmdb.org/t/p/w500" + bestMovieList[position].backdropPath)
                .into(holder.binding.bestImageView)
            holder.binding.bestMovieName
                .text = bestMovieList[position].title
        }

    }

    override fun getItemCount(): Int {
        return bestMovieList.size
    }


}
