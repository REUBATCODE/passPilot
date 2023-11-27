package vega.odyssey.passpilot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import vega.odyssey.passpilot.DatabaseHandler
import vega.odyssey.passpilot.R

class MainActivity : AppCompatActivity() {

    private lateinit var txtUserWritten: EditText
    private lateinit var txtPasswordWritten: EditText
    private lateinit var txtSiteWritten: EditText
    private lateinit var btnFastSave: Button
    private lateinit var databaseHandler: DatabaseHandler
    private lateinit var btnView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUserWritten = findViewById(R.id.txtUserWritten)
        txtPasswordWritten = findViewById(R.id.txtPasswordWritten)
        txtSiteWritten = findViewById(R.id.txtSiteWritten)
        btnFastSave = findViewById(R.id.btnFastSave)
        btnView = findViewById(R.id.btnView)

        databaseHandler = DatabaseHandler(this)

        btnFastSave.setOnClickListener {
            val username = txtUserWritten.text.toString()
            val password = txtPasswordWritten.text.toString()
            val site = txtSiteWritten.text.toString()

            val result = databaseHandler.addUserData(username, password, site)

            if (result != -1L) {
                // Éxito al guardar en la base de datos
                // Puedes mostrar un mensaje de éxito o realizar otra acción aquí
            } else {
                // Error al guardar en la base de datos
                // Puedes mostrar un mensaje de error o realizar otra acción aquí
            }
        }
        btnView.setOnClickListener{
            val intent = Intent(this, PasswordsActivity::class.java)
            startActivity(intent)
        }
    }
}
