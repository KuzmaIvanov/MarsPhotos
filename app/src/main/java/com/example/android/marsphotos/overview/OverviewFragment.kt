package com.example.android.marsphotos.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.marsphotos.databinding.FragmentOverviewBinding
import com.example.android.marsphotos.other.MarsPhotoItemAdapter

/**
 * This fragment shows the the status of the Mars photos web services transaction.
 */
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        viewModel.status.observe(viewLifecycleOwner, Observer {
            binding.tvStatus.text = viewModel.status.value
        })

        val adapter = MarsPhotoItemAdapter(listOf(), requireContext())
        binding.rvMarsPhotos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMarsPhotos.adapter = adapter

        viewModel.photos.observe(viewLifecycleOwner, Observer {
            adapter.photos = it
            adapter.notifyDataSetChanged()
        })

        return binding.root
    }
}
