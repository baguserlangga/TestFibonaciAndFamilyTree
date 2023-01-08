package com.example.testbagus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.testbagus.databinding.FragmentFibonaciBinding
import com.example.testbagus.databinding.FragmentKeluargaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KeluargaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KeluargaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentKeluargaBinding
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
        // Inflate the layout for this fragment
        initdata()
        binding = FragmentKeluargaBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.buttonProcess.setOnClickListener {
            initsearchparent(binding.etName.text.toString())
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KeluargaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KeluargaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun initdata()
    {
        val orangs1 = Orang("A001", "Wati",null )
        val orangs2 = Orang("A002" , "Wira","A001")
        val orangs3 = Orang("A003", "Andi","A002" )
        val orangs4 = Orang("A004" , "Bagus","A002")
        val orangs5 = Orang("A005" , "Siti","A001")
        val orangs6 = Orang("A006", "Hasan","A005" )
        val orangs7 = Orang("A007" , "Abdul","A006")
        listOrang.add(orangs1)
        listOrang.add(orangs2)
        listOrang.add(orangs3)
        listOrang.add(orangs4)
        listOrang.add(orangs5)
        listOrang.add(orangs6)
        listOrang.add(orangs7)


    }
    val listOrang = ArrayList<Orang>()
    val listoranghasil = ArrayList<String>()
    fun initsearchparent(code:String)
    {
        listOrang!!.forEachIndexed { index, element ->
            if (element.parent==code)
            {
                Log.d("isielement", "onCreate: " + element)
                listoranghasil.add(element.name)
                initsearchparent(element.code.toString())

            }
            else{

            }
        }
        binding.tvResult.text=listoranghasil.toString()
    }
}