package com.example.mychat.screen.start

import com.example.mychat.BR
import com.example.mychat.R
import com.example.mychat.databinding.FragmentStartBinding
import com.example.mychat.screen.base.BaseFragment
import com.example.mychat.screen.ui.fragment.login.LoginFragment
import com.example.mychat.screen.ui.fragment.register.RegisterFragment
import org.koin.android.viewmodel.ext.android.viewModel

class StartFragment : BaseFragment<StartViewModel, FragmentStartBinding>() {
    companion object {
        const val TAG = "StartFragment"
        fun newInstance() = StartFragment()
    }

    override val layotuRes: Int = R.layout.fragment_start
    override val viewModel: StartViewModel by viewModel()
    override val viewModelVariable: Int = BR.viewModel

    override fun initComponent() {
        viewBinding.apply {
            buttonRegister.setOnClickListener {
                addFragment(
                    fragment = RegisterFragment.newInstance(),
                    tag = RegisterFragment.TAG,
                    isAddBackstack = true
                )
            }
            buttonLogin.setOnClickListener{
                addFragment(
                    fragment = LoginFragment.newInstance(),
                    tag = LoginFragment.TAG,
                    isAddBackstack = true
                )

            }
        }
    }
}
