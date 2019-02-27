package com.example.mychat.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import com.example.mychat.R

object DialogUtils {
    fun createLoadingDialog(
        context: Context?,
        cancelable: Boolean = false,
        canceledOnTouchOutside: Boolean = false
    ): AlertDialog? =
        context?.let {
            AlertDialog.Builder(it)
                .setView(R.layout.layout_loading_dialog)
                .create().apply {
                    setCancelable(cancelable)
                    setCanceledOnTouchOutside(canceledOnTouchOutside)
                    window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                }
        }

    fun showLoadingDialog(context: Context?, cancelable: Boolean = false): AlertDialog? =
        context?.let { createLoadingDialog(context, cancelable)?.apply { show() } }

    fun showMessage(
        context: Context?,
        title: String? = null,
        mesage: String? = null,
        textPositive: String? = null,
        positiveListener: (() -> Unit)? = null,
        textNegative: String? = null,
        negativeListener: (() -> Unit)? = null,
        cancelable: Boolean = false,
        canceledOnTouchOutside: Boolean = false
    ) {
        context?.let {
            AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(mesage)
                .setPositiveButton(textPositive) { _, _ -> positiveListener?.invoke() }
                .setNegativeButton(textNegative) { _, _ -> negativeListener?.invoke() }
                .setCancelable(cancelable)
                .create().apply {
                    setCanceledOnTouchOutside(canceledOnTouchOutside)
                    show()
                }
        }
    }
}