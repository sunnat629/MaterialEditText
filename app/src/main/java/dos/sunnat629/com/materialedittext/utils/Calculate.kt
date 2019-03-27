package dos.sunnat629.com.materialedittext.utils

import android.util.Patterns
import android.text.TextUtils



object Calculate {
    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}