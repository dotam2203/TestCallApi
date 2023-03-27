package com.test.libraries

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

class LocalHelper {
    //local: đại diện cho ngon ngữ cần lấy chuỗi "Locale.US"
    fun getString(context: Context, locale: Locale, resourceId: Int): String{
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            val config = Configuration(context.resources.configuration)
            config.setLocale(locale)
            return context.createConfigurationContext(config).getString(resourceId)
        }
        else{
            val resource = context.resources
            val conf = resource.configuration
            val saveLocale = conf.locale
            conf.locale = locale
            resource.updateConfiguration(conf,null)
            // retrieve resources from desired locale
            val result: String = resource.getString(resourceId)
            // restore original locale
            conf.locale = saveLocale
            resource.updateConfiguration(conf,null)
            return result
        }
    }
}