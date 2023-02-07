package com.ex.springprac.util

data class CmResDto<T>(
        val ResultCode:T,
        val resultMsg:String,
        val data:T
)