package com.example.mychat.screen.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.mychat.R

abstract class BaseFragment<ViewModel : BaseViewModel, ViewBinding : ViewDataBinding> : Fragment() {
    abstract val layotuRes: Int
    abstract val viewModel: ViewModel
    abstract val viewModelVariable: Int
    lateinit var viewBinding: ViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = DataBindingUtil.inflate<ViewBinding>(
            inflater,
            layotuRes, container, false
        ).apply {
            root.isClickable = true
        }
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    abstract fun initComponent()
    fun addFragment(
        container: Int = R.id.activity_container,
        fragment: Fragment,
        tag: String = "fragment",
        isAddBackstack: Boolean = true
    ) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            add(container, fragment)
            if (isAddBackstack) {
                addToBackStack(tag)
            }
            commit()
        }
    }

    fun replaceFragment(
        container: Int = R.id.fragment_container,
        fragment: Fragment,
        tag: String = "fragment",
        isAddBackstack: Boolean
    ) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(container, fragment, tag)
            if (isAddBackstack) {
                addToBackStack(tag)
            }
            commit()
        }
    }

    fun addChildFragment(
        parentFragment: Fragment = this,
        container: Int,
        fragment: Fragment,
        tag: String = "",
        isAddBackstack: Boolean = false
    ) {
        parentFragment.childFragmentManager.beginTransaction().apply {
            add(container, fragment, tag)
            if (isAddBackstack) {
                addToBackStack(tag)
            }
            commit()
        }
    }

    fun replaceChildFragment(
        parentFragment: Fragment = this,
        container: Int,
        fragment: Fragment,
        tag: String = "",
        isAddBackstack: Boolean = false
    ) {
        parentFragment.childFragmentManager.beginTransaction().apply {
            replace(container, fragment, tag)
            if (isAddBackstack) {
                addToBackStack(tag)
            }
            commit()
        }
    }

    fun onBack() {
        activity?.onBackPressed()
    }
}
