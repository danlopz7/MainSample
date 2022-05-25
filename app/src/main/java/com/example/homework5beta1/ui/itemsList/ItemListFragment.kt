package com.example.homework5beta1.ui.itemsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.homework5beta1.R
import com.example.homework5beta1.databinding.FragmentItemlistBinding
import com.example.homework5beta1.viewmodel.ItemListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemListFragment : Fragment() {

    private val viewModel: ItemListViewModel by viewModels()
    private lateinit var binding: FragmentItemlistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_itemlist, container, false)
        binding = FragmentItemlistBinding.bind(view).apply {
            vm = viewModel
        }

        //val binding = FragmentItemlistBinding.inflate(inflater)
        //binding.vm = viewModel

        binding.lifecycleOwner = this

        binding.recyclerViewPosts.adapter = ItemsPostAdapter(ItemsPostAdapter.OnClickListener {
            viewModel.displayPhotoDetails(it)
        })

        viewModel.navigateToSelectedPhoto.observe(viewLifecycleOwner, {
            if (it != null) {
                this.findNavController().navigate(
                    ItemListFragmentDirections.actionItemListFragmentToImageDetailFragment(it)
                )
                viewModel.displayPhotoDetailsComplete()
            }
        })

        //return binding.root
        return view

    }
}