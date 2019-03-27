package dos.sunnat629.com.materialedittext.ui.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dos.sunnat629.com.materialedittext.R
import dos.sunnat629.com.materialedittext.utils.Calculate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content_layout.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCheck()

    }

    private fun editTextCheck() {
        email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                input_lay_email.isErrorEnabled = false
            }
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                input_lay_password.isErrorEnabled = false
            }
        })
    }


    fun logInButton(view: View){
        if (TextUtils.isEmpty(password.text.toString())){
            input_lay_password.isErrorEnabled = true
            input_lay_password.error = getString(R.string.empty)
        }
        if (TextUtils.isEmpty(email.text.toString())){
            input_lay_email.isErrorEnabled = false
            input_lay_email.error = getString(R.string.empty)
        } else {
            if (!Calculate.isValidEmail(email.text.toString())){
                input_lay_email.isErrorEnabled = true
                input_lay_email.error = getString(R.string.error_email)
            } else{
                toast(getString(R.string.success))
            }
        }
    }

    fun forgotButton(view: View){
        alert(getString(R.string.forgot_message), getString(R.string.forgot)) {
            yesButton {
                root.snackbar(getString(R.string.reset_password))
            }
        }.show()
    }
}
