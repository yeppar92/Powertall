package co.yeppar.powertall.screens.fragments

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import co.yeppar.powertall.R
import co.yeppar.powertall.databinding.FragHomeBinding

class Home : Fragment(), View.OnClickListener {
    private lateinit var binding: FragHomeBinding
    private lateinit var bounce: Animation
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragHomeBinding>(
            inflater,
            R.layout.frag_home, container, false
        )
        init()
        return binding.root
    }

    override fun onClick(v: View) {
        when (v.id) {

        }
    }

    private fun init() {


    }


}