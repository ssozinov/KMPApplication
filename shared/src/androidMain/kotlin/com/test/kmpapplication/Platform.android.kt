package com.test.kmpapplication

import com.test.kmpapplication.platform.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}
