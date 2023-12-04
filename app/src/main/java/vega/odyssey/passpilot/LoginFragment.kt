package vega.odyssey.passpilot

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.google.android.material.bottomsheet.BottomSheetDialog
class LoginFragment : Fragment() {
    private var users: List<User> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val user = view.findViewById<EditText>(R.id.txtName)
        val password = view.findViewById<EditText>(R.id.txtPassword)
        val button = view.findViewById<Button>(R.id.btnSubmit)

        button.setOnClickListener()
        {
            validUsers()
            if(user.text.isNotEmpty() && password.text.isNotEmpty()){
                val email = user.text.toString()
                val pass = password.text.toString()

                if(checkUser(email,pass,users)){
                    val i = Intent(view.context,MainActivity::class.java)
                    startActivity(i)


                }else{
                    Toast.makeText(context,
                        "Las credenciales no coinciden",
                        Toast.LENGTH_SHORT).show()
                }
            }
            else{
                val bottomSheetDialog = BottomSheetDialog(view.context)
                val parentView: View = layoutInflater.inflate(R.layout.bsd_validation_login,null)
                bottomSheetDialog.setContentView(parentView)
                bottomSheetDialog.show()
            }
        }
        return view
    }

    private fun checkUser(username: String, password: String, users:List<User>): Boolean{
        return users.any {user -> username == user.email && password == user.password}
    }
    private fun validUsers(){
        users = listOf(
            User(1, "papu@papu.com", "lechepapu"),
            User(2, "mamu@mamu.com", "lechemamu"),
            User(3, "rub@en.com", "123")
        )
    }
}