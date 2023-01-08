package com.example.testbagus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.testbagus.databinding.ActivityMainBinding
import com.example.testbagus.databinding.FragmentFibonaciBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FibonaciFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class FibonaciFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentFibonaciBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFibonaciBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.buttonProcess.setOnClickListener {
            fibonaci(binding.etN.text.toString().toInt(),binding.tvResult)
        }
        return binding.root
    }
    fun fibonaci(angka : Int, tvResult: TextView)
    {
        val n = angka
        var t1 = 0
        var t2 = 1
        val deret = ArrayList<Int>()
        Log.d("isielement","First $n terms: ")

        for (i in 1..n) {
            Log.d("isielement",  "$t1  ")
            deret.add(t1)
            val sum = t1 + t2
            t1 = t2
            t2 = sum
        }
        tvResult.text = deret.toString()

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FibonaciFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FibonaciFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}