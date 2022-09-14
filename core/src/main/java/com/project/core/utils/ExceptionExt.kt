package com.project.core.utils

import android.content.Context
import com.project.core.exception.ApiErrorException
import com.project.core.exception.NoInternetConnectionException
import java.lang.Exception


fun Context.getErrorMessage(exception: Exception
): String{
    return when(exception){
        is NoInternetConnectionException -> getString(com.project.styling.R.string.message_error_no_internet)
        is ApiErrorException -> exception.message.orEmpty()
        else -> getString(com.project.styling.R.string.message_error_unknown)
        }
}