package com.example.whac_a_mole

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.whac_a_mole.databinding.FragmentNewGameBinding


class NewGameFragment : Fragment() {

    //private lateinit var vm: WAMViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentNewGameBinding>(
            layoutInflater, R.layout.fragment_new_game, container, false)

//        val application = requireNotNull(this.activity).application
//        val viewModelFactory = WAMViewModelFactory(application)
//        vm = ViewModelProvider(this, viewModelFactory).get(WAMViewModel::class.java)

//        val args: ResultFragmentArgs by navArgs()
//        val text:String
//        if(args.record.isNotEmpty()) {
//            text = args.record
//        }
//        else {
//            text = "0"
//        }
//
//        vm.recordLive.observe(viewLifecycleOwner, Observer {record->
//            if(text.isEmpty())
//                text=record.toString()
//            binding.record.text = "Highest record: $text"
//        })



        binding.startButton.setOnClickListener { v: View ->
            v.findNavController().navigate(
                NewGameFragmentDirections.actionNewGameFragmentToGameFragment())
        }


        return binding.root
    }


}