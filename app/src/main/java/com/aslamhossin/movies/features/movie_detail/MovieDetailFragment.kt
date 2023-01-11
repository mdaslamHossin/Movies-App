package com.aslamhossin.movies.features.movie_detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.aslamhossin.movies.arch.system.BaseFragment
import com.aslamhossin.movies.databinding.FragmentMovieDetailBinding
import com.aslamhossin.movies.domain.model.MovieModel
import com.aslamhossin.movies.features.movies.MoviePosterMapper.getPoster
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


/**
 * Created by aslam on 10,January,2023
 */


@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>(
    FragmentMovieDetailBinding::inflate
) {

    private val viewModel by viewModels<MovieDetailViewModel>()
    private val args: MovieDetailFragmentArgs by navArgs()


    override fun configureViews(savedInstanceState: Bundle?) {
        bindUI()
        bindClickEvents()
    }

    private fun bindUI() {
        args.movie?.let { movie ->
            binding?.apply {
                textRating.text = "${movie.rating}/10"
                textMovieName.text = movie.title
                manageWatchListButtonStatus(movie)
                textDescription.text = movie.description
                imageMoviePoster.setImageResource(getPoster(movie.title))
            }
        }

    }

    private fun FragmentMovieDetailBinding.manageWatchListButtonStatus(movie: MovieModel) {
        buttonAddWatchList.isEnabled = movie.onMyWatchList.not()
    }

    private fun bindClickEvents() {
        binding?.apply {
            buttonAddWatchList.setOnClickListener {
                val movie = args.movie?.apply {
                    onMyWatchList = true
                }
                lifecycleScope.launch {
                    if (movie != null) {
                        viewModel.addMovieOnMyWishList(movie)
                    }
                }
                if (movie != null) {
                    manageWatchListButtonStatus(movie)
                }
            }
            buttonWatchTrailer.setOnClickListener {

                args.movie?.trailerLink?.let { url -> watchYoutubeVideo(url) }
            }
            toolBarMovieDetail.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }

    }

    private fun watchYoutubeVideo(url: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$id"))
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
        try {
            startActivity(appIntent)
        } catch (ex: ActivityNotFoundException) {
            startActivity(webIntent)
        }
    }

}
