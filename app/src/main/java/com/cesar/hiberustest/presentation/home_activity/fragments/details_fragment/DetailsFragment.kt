package com.cesar.hiberustest.presentation.home_activity.fragments.details_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.cesar.hiberustest.MyApplication
import com.cesar.hiberustest.R
import com.cesar.hiberustest.databinding.FragmentDetailsBinding
import com.cesar.hiberustest.domain.entity.MyData
import com.cesar.hiberustest.utils.Logger
import com.cesar.hiberustest.utils.loadUrl
import com.google.gson.Gson

class DetailsFragment : Fragment() ,Logger{

    override val nameClass: String get() = "--->"+javaClass.simpleName
    private lateinit var binding: FragmentDetailsBinding
    private var json : String=""
    private var data : MyData?=null
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBundleData()
        initComponents()
    }

    private fun getBundleData() {
        val bundle= this.arguments
        if(bundle!=null) {
            json = args.itemData
            data= Gson().fromJson(json,MyData::class.java)
        }else{
            //Handle Error
            return
        }
    }

    private fun initComponents() {
        if(data!=null) {
            with(binding) {
                tvName.text= data?.firstName.plus(" ").plus(data?.lastName)
                tvDescription.text= data?.email
                civGif.loadUrl(MyApplication.appContext.getString(R.string.gif_url))
                civProfile.loadUrl(data?.picture)

                //config generic toolbar
                toolbar.ivBack.setOnClickListener { requireActivity().onBackPressed() }
            }
        }
    }

}