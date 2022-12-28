package com.example.mymoviemvvm.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import androidx.recyclerview.widget.GridLayoutManager
import com.example.mymoviemvvm.Adapter.BestMovieAdapter
import com.example.mymoviemvvm.MVVM.BestViewModel
import com.example.mymoviemvvm.databinding.FragmentBestBinding


class BestFragment : Fragment() {

    private lateinit var binding: FragmentBestBinding
    private lateinit var bestViewModel: BestViewModel
    private lateinit var bestAdapter: BestMovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bestViewModel = ViewModelProviders.of(this)[BestViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBestBinding.inflate(inflater, container, false)
        binding.bestRV.layoutManager = GridLayoutManager(context, 2)
        bestAdapter = BestMovieAdapter()
        binding.bestRV.adapter = bestAdapter
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovie()
    }


    fun getMovie() {
        bestViewModel.observeMovieLiveData().observe(viewLifecycleOwner)
        { t -> bestAdapter.setMovieList(t!!) }
        bestViewModel.getBestMovie()
    }

}