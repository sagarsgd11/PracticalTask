package com.practikaltask.presentation.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practikaltask.presentation.base.viewmodel.BaseViewModel

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getBaseViewModel() :BaseViewModel?



}