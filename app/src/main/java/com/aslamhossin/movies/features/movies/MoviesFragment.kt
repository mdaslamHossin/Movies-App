package com.aslamhossin.movies.features.movies

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aslamhossin.movies.arch.extensions.collectFlow
import com.aslamhossin.movies.arch.system.BaseFragment

import com.aslamhossin.movies.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoviesBinding>(
    FragmentMoviesBinding::inflate
) {

    private lateinit var movieListAdapter: MovieListAdapter
    private val viewModel by viewModels<MoviesViewModel>()

    override fun configureViews(savedInstanceState: Bundle?) {
        movieListAdapter = MovieListAdapter{
            val action = MoviesFragmentDirections.nextAction(it)
            findNavController().navigate(action)
        }
        binding?.recyclerViewMovies?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = movieListAdapter

        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovies()
    }
    override fun bindWithViewModel() {
        viewModel.getMovies()
    }

    override fun collectFlows() {
        collectFlow(viewModel.teamFlow) {
            movieListAdapter.submitList(it)
        }
    }
}
