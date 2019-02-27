package com.example.mychat.utils

import android.content.res.Resources
import android.util.Patterns
import com.example.mychat.R
import java.util.regex.Pattern

fun String.validateEmail(resources: Resources): String =
    if (Patterns.EMAIL_ADDRESS.matcher(this).matches())
        ""
    else
        resources.getString(R.string.email_invalid)


fun String.validatePasswod(resources: Resources): String =
    if (length < 8)
        resources.getString(R.string.password_invalid)
     else ""