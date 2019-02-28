package com.example.mychat.screen.ui.fragment.login

import androidx.lifecycle.Observer
import com.example.mychat.BR
import com.example.mychat.R
import com.example.mychat.databinding.FragmentLoginBinding
import com.example.mychat.screen.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {
    companion object {
        const val TAG = "LoginFragment"
        fun newInstance() = LoginFragment()
    }

    override val layotuRes: Int = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModel()
    override val viewModelVariable: Int = BR.viewModel
    override fun initComponent() {
        viewBinding.apply {
            buttonLogin.setOnClickListener {
                viewModel.signInWithEmail(
                    email = editEmail.text.toString(),
                    password = editPassword.text.toString()
                )
            }
        }
        viewModel.apply {
            loginSuccess.observe(viewLifecycleOwner, Observer {
               if (it){
                   Snackbar.make(
                       view ?: return@Observer,
                       resources.getString(R.string.notify_login_sccess),
                       Snackbar.LENGTH_SHORT
                   ).show()
                   fragmentManager?.popBackStack()
               }
           })
        }
    }
}