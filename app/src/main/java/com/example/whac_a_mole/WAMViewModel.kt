package com.example.whac_a_mole

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import java.util.*
import kotlin.random.Random.Default.nextInt

class WAMViewModel(
    application: Application) : AndroidViewModel(application) {

    private var record = MutableLiveData<Int>(0)
    var recordLive:LiveData<Int> = record
    private var score = MutableLiveData<Int>(0)
    var scoreLive:LiveData<Int> = score
    private var target = MutableLiveData<Int>()
    var targetLive: LiveData<Int> = target
//    private var hit = MutableLiveData<Int>()
//    //var hitLive: LiveData<Int> = hit
    
    //var sc

    fun initScore(){
        score.value = 0

    }

    //val array: Array<Int> = arrayOf(0,0,0,0,0,0,0,0,0)

//    fun getNum(btn:Int){
//        target.value= btn
//    }

    fun checkRecord(sc:Int){
        if(record.value!! < sc)
            record.value = sc
    }

    fun setPastRecord(sc:String){
        record.value = sc.toInt()
    }

    fun getHit(btn:Int){
        var i:Int
        if(target.value == btn) {
            score.value = score.value?.plus(1)
        }
    }

    fun arrange(){
        var i = (1..9).random()
        target.value = i
    }

}