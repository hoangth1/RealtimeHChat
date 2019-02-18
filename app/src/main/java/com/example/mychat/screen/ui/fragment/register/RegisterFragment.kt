package com.example.mychat.screen.ui.fragment.register

import android.os.Bundle
import android.view.View
import com.example.mychat.BR
import com.example.mychat.R
import com.example.mychat.databinding.FragmentRegisterBinding
import com.example.mychat.screen.base.BaseFragment
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRegisterBinding>() {
    companion object {
        const val TAG = "FragmentRegister"
        fun newInstance() = RegisterFragment()
    }

    override val layotuRes: Int = R.layout.fragment_register
    override val viewModel: RegisterViewModel by viewModel()
    override val viewModelVariable: Int = BR.viewModel

    override fun initComponent() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_back?.setOnClickListener { onBack() }

    }
}
