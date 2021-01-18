package com.cesar.hiberustest.presentation.home_activity.fragments.data_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.cesar.hiberustest.R
import com.cesar.hiberustest.databinding.FragmentDataBinding
import com.cesar.hiberustest.domain.Resource
import com.cesar.hiberustest.domain.entity.MyData
import com.cesar.hiberustest.presentation.home_activity.fragments.data_fragment.adapter.DataAdapter
import com.cesar.hiberustest.utils.Consts
import com.cesar.hiberustest.utils.Logger
import com.cesar.hiberustest.utils.printToast
import com.google.gson.Gson


class DataFragment : Fragment() , Logger,
    DataAdapter.OnItemClickListener {

    override val nameClass: String get() = "--->"+javaClass.simpleName
    private lateinit var binding: FragmentDataBinding
    private val initAdapter =
        DataAdapter(
            emptyList(),
            this
        )

    private var itemList: MutableList<MyData> = arrayListOf()
    private lateinit var viewModel: DataViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDataBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    private fun initComponents() {
        with(binding){
            toolbar.ivBack.setOnClickListener { requireActivity().onBackPressed()}
            recycler.adapter = initAdapter
        }
        viewModel.myDataLiveData.observe(viewLifecycleOwner, Observer { resource ->
            when (resource) {
                is Resource.Loading -> {
                    showProgress(true)
                }
                is Resource.Success -> {
                    showProgress(false)

                    updateDataList(resource.data ?: emptyList())
                }
                is Resource.Error -> {
                    showProgress(false)
                    showSnackBarFailed(getString(R.string.handle_error))
                }
            }
        })
        viewModel.getData()
    }

    override fun onClickItem(item: MyData, TAG: String) {
        logD(Gson().toJson(item))
        when(TAG){
            Consts.Adapters.ALL->{
                val args = Bundle()
                args.putString(Consts.Arg.ITEM_DATA,Gson().toJson(item))

                val action =
                    DataFragmentDirections.actionDataFragmentToDetailsFragment(Gson().toJson(item))
                Navigation.findNavController(requireView())
                    .navigate(action)
            }
        }
    }

    private fun updateDataList(list: List<MyData>) {
        this.itemList = list as MutableList<MyData>
        initAdapter.listItems= itemList
    }

    private fun showProgress(control: Boolean) {binding.progress.visibility= (if (control) View.VISIBLE else View.GONE)}


    private fun showSnackBarFailed(message: String) {
        requireActivity().printToast(message)
    }
}