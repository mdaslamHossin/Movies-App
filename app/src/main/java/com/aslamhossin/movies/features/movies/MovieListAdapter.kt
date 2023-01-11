package com.aslamhossin.movies.features.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aslamhossin.movies.databinding.LayoutMovieItemBinding
import com.aslamhossin.movies.domain.model.MovieModel
import com.aslamhossin.movies.features.movies.MoviePosterMapper.getPoster


/**
 * Created by aslam on 02,January,2023
 */
class MovieListAdapter(private val onClick: (MovieModel) -> Unit) :
    ListAdapter<MovieModel, MovieListAdapter.MovieViewHolder>(MovieComparator) {


    inner class MovieViewHolder(private val binding: LayoutMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: MovieModel) = with(binding) {
            textMovieName.text = model.title
            textGenre.text = model.genre
            imageMoviePoster.setImageResource(getPoster(model.title))
            binding.root.setOnClickListener {
                onClick.invoke(model)
            }
            textWatchList.isVisible = model.onMyWatchList
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            LayoutMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(getItem(position))

    object MovieComparator : DiffUtil.ItemCallback<MovieModel>() {

        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel) =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel) =
            oldItem == newItem
    }
}