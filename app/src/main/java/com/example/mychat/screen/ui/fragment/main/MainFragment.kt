package com.example.mychat.screen.ui.fragment.main

import com.example.mychat.BR
import com.example.mychat.R
import com.example.mychat.databinding.FragmentMainBinding
import com.example.mychat.screen.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment:BaseFragment<MainViewModel,FragmentMainBinding>() {

    companion object {
        const val TAG="MainFragment "
        fun newInstance()=MainFragment()
    }

    override val layotuRes: Int = R.layout.fragment_main
    override val viewModel: MainViewModel by viewModel()
    override val viewModelVariable: Int=BR.viewModel

    override fun initComponent() {
    }
}
