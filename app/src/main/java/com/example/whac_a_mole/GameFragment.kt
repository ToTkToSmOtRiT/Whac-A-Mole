package com.example.whac_a_mole

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.whac_a_mole.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    private lateinit var vm: WAMViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            layoutInflater, R.layout.fragment_game, container, false)
        val application = requireNotNull(this.activity).application
        //val dao = WordsDatabase.getInstance(application).getWordsDatabaseDao()
        val viewModelFactory = WAMViewModelFactory(application)
        vm = ViewModelProvider(this, viewModelFactory).get(WAMViewModel::class.java)

        vm.initScore()

        object : CountDownTimer(31000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // logic to set the EditText could go here
                binding.timerScreen.setText(" " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                val action = GameFragmentDirections.actionGameFragmentToResultFragment(
                    vm.scoreLive.value.toString())
                findNavController().navigate(action)
            }
        }.start()

        object : CountDownTimer(31000, 500) {
            override fun onTick(millisUntilFinished: Long) {
                // logic to set the EditText could go here
                when (vm.targetLive.value) {
                    1 -> binding.b1.setImageResource(R.drawable.hole_1)
                    2 -> binding.b2.setImageResource(R.drawable.hole_1)
                    3 -> binding.b3.setImageResource(R.drawable.hole_1)
                    4 -> binding.b4.setImageResource(R.drawable.hole_1)
                    5 -> binding.b5.setImageResource(R.drawable.hole_1)
                    6 -> binding.b6.setImageResource(R.drawable.hole_1)
                    7 -> binding.b7.setImageResource(R.drawable.hole_1)
                    8 -> binding.b8.setImageResource(R.drawable.hole_1)
                    9 -> binding.b9.setImageResource(R.drawable.hole_1)
                }
                vm.arrange()
                    when (vm.targetLive.value) {
                        1 -> binding.b1.setImageResource(R.drawable.hole_2)
                        2 -> binding.b2.setImageResource(R.drawable.hole_2)
                        3 -> binding.b3.setImageResource(R.drawable.hole_2)
                        4 -> binding.b4.setImageResource(R.drawable.hole_2)
                        5 -> binding.b5.setImageResource(R.drawable.hole_2)
                        6 -> binding.b6.setImageResource(R.drawable.hole_2)
                        7 -> binding.b7.setImageResource(R.drawable.hole_2)
                        8 -> binding.b8.setImageResource(R.drawable.hole_2)
                        9 -> binding.b9.setImageResource(R.drawable.hole_2)
                    }
            }

            override fun onFinish() {

            }
        }.start()

//        val listener = View.OnClickListener(){ view->
//            val b = requireView().findViewById<ImageButton>(view.id)
//            //vm.getNum(b.getText() as String)
//            //binding.scoreScreen.text = b.text
//        }

        binding.b1.setOnClickListener{
            vm.getHit(1)
        }
        binding.b2.setOnClickListener{
            vm.getHit(2)
        }
        binding.b3.setOnClickListener{
            vm.getHit(3)
        }
        binding.b4.setOnClickListener{
            vm.getHit(4)
        }
        binding.b5.setOnClickListener{
            vm.getHit(5)
        }
        binding.b6.setOnClickListener{
            vm.getHit(6)
        }
        binding.b7.setOnClickListener{
            vm.getHit(7)
        }
        binding.b8.setOnClickListener{
            vm.getHit(8)
        }
        binding.b9.setOnClickListener{
            vm.getHit(9)
        }



        vm.scoreLive.observe(viewLifecycleOwner, Observer {score->
            binding.scoreScreen.text = score.toString()
            vm.checkRecord(score)
        })

        return binding.root
    }

}