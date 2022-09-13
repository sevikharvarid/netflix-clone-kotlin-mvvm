package com.project.core.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.project.core.utils.getErrorMessage
import java.lang.Exception

abstract class BaseActivity<B: ViewBinding,VM : ViewModel>(
    val bindingFactory: (LayoutInflater) -> B
): AppCompatActivity() {

    protected lateinit var binding: B
    protected abstract val viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        initView()
        observeData()
    }

    abstract fun initView()

    open fun observeData(){}

    fun showError(isErrorEnable: Boolean, exception: Exception){
        if(isErrorEnable){
            Toast.makeText(this,getErrorMessage(exception), Toast.LENGTH_SHORT).show()
        }
    }

    fun enableHomeAsBack(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp() :Boolean{
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}