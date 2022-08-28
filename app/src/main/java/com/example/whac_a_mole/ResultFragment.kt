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
import com.example.whac_a_mole.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var vm: WAMViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentResultBinding>(
            layoutInflater, R.layout.fragment_result, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = WAMViewModelFactory(application)
        vm = ViewModelProvider(this, viewModelFactory).get(WAMViewModel::class.java)

        val args: ResultFragmentArgs by navArgs()
        val text = args.result
        binding.textView.text = "Your score is: $text"

//        vm.recordLive.observe(viewLifecycleOwner, Observer {record->
//            binding.resultRecord.text = "Highest record: $record"
//        })

        binding.restartButton.setOnClickListener { v: View ->
            v.findNavController().navigate(
                ResultFragmentDirections.actionResultFragmentToGameFragment())
        }
        binding.returnButton.setOnClickListener { v: View ->
            v.findNavController().navigate(
                ResultFragmentDirections.actionResultFragmentToNewGameFragment())
        }

        return binding.root
    }

}