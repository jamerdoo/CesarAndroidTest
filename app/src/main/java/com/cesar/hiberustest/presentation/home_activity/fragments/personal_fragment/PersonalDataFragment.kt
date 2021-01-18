package com.cesar.hiberustest.presentation.home_activity.fragments.personal_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.cesar.hiberustest.R
import com.cesar.hiberustest.databinding.FragmentPersonalDataBinding
import com.cesar.hiberustest.utils.Logger

class PersonalDataFragment : Fragment() ,Logger{

    override val nameClass: String get() = "--->"+javaClass.simpleName
    private lateinit var binding: FragmentPersonalDataBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPersonalDataBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    private fun initComponents() {
        with(binding){
            fab.setOnClickListener{
                Navigation.findNavController(requireView())
                .navigate(R.id.action_personalDataFragment_to_dataFragment)
            }
            //config generic toolbar
            toolbar.ivBack.visibility= View.INVISIBLE
        }
    }

}