package vega.odyssey.passpilot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PasswordsActivity : AppCompatActivity() {

    private lateinit var recyclerViewPasswords: RecyclerView
    private lateinit var adapter: PasswordsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passwords)

        recyclerViewPasswords = findViewById(R.id.recyclerViewPasswords)
        recyclerViewPasswords.layoutManager = LinearLayoutManager(this)

        // Aquí deberías obtener tu lista de contraseñas desde la base de datos
        val dataListFromDatabase: List<PasswordItem> = obtainPasswordsFromDatabase()

        // Configuración del adaptador con la lista de contraseñas y asignación al RecyclerView
        adapter = PasswordsAdapter(dataListFromDatabase)
        recyclerViewPasswords.adapter = adapter
    }

    // Este método simulado obtiene la lista de contraseñas de tu base de datos
    private fun obtainPasswordsFromDatabase(): List<PasswordItem> {
        // Aquí deberías implementar la lógica para obtener los datos de la base de datos y devolverlos
        // Por ejemplo:
        // val passwordsList: List<PasswordItem> = databaseHandler.getAllPasswords()
        // return passwordsList

        // En este ejemplo simulado, retornamos una lista vacía
        return emptyList()
    }

    inner class PasswordsAdapter(private val dataList: List<PasswordItem>) : RecyclerView.Adapter<PasswordsAdapter.ViewHolder>() {

        // ViewHolder que representa cada elemento en la lista
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
            val passwordTextView: TextView = itemView.findViewById(R.id.passwordTextView)
            val siteTextView: TextView = itemView.findViewById(R.id.siteTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_password, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentItem = dataList[position]
            holder.usernameTextView.text = currentItem.username
            holder.passwordTextView.text = currentItem.password
            holder.siteTextView.text = currentItem.site
        }

        override fun getItemCount(): Int {
            return dataList.size
        }
    }
}
