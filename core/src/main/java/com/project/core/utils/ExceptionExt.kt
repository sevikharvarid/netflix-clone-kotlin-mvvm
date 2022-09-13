package com.project.core.utils

import android.content.Context
import com.project.core.exception.ApiErrorException
import com.project.core.exception.NoInternetConnectionException
import java.lang.Exception


fun Context.getErrorMessage(exception: Exception
): String{
    return when(exception){
        is NoInternetConnectionException ->"Something is wrong with internet connection\\nMake sure you have an Internet Connection and try again."
        is ApiErrorException -> exception.message.orEmpty()
        else -> "\"Something is wrong when fetch data\\\\nPlease try again\""
        }
}