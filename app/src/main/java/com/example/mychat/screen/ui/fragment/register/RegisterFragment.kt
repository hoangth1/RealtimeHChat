package com.example.mychat.screen.ui.fragment.register

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.mychat.BR
import com.example.mychat.R
import com.example.mychat.databinding.FragmentRegisterBinding
import com.example.mychat.screen.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_register.*
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
        image_back?.setOnClickListener { onBack() }
        viewBinding.apply {
            buttonRegister.setOnClickListener {
                this@RegisterFragment.viewModel.register(
                    editUsername.text.toString(),
                    editEmail.text.toString(),
                    editPassword.text.toString()
                )
            }
        }
        viewModel.apply {
            errorEmail.observe(viewLifecycleOwner, Observer {
                viewBinding.inputLayoutEmail.error = it
            })
            errorPassword.observe(viewLifecycleOwner, Observer {
                viewBinding.inputLayoutPassword.error = it
            })
            registerSuccess.observe(viewLifecycleOwner, Observer {
                if (it){
                    fragmentManager?.popBackStack()
                    Snackbar.make(view?:return@Observer,"Register successfull, you can login now",Snackbar.LENGTH_SHORT).show()
                }
            })
        }
    }


}
