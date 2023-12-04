package vega.odyssey.passpilot

import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

data class PasswordItemAdapter(private val itemPassword:List<PasswordItem>):
        RecyclerView.Adapter<PasswordItemAdapter.PasswordItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasswordItemViewHolder {
        val compresor = LayoutInflater.from(parent.context)
        return PasswordItemViewHolder(compresor.inflate(R.layout.item_password, parent, false))
    }

    override fun getItemCount(): Int {
        return itemPassword.size
    }

    override fun onBindViewHolder(holder: PasswordItemViewHolder, position: Int) {
        holder.render(itemPassword[position])
    }

    class PasswordItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val userName: TextView = itemView.findViewById(R.id.txtItemUser)
        val userSite: TextView = itemView.findViewById(R.id.txtItemSite)
        val siteImage: ImageView = itemView.findViewById(R.id.imgPassPilot)

        fun render(passwordItem:PasswordItem){
            userName.text = passwordItem.username
            userSite.text = passwordItem.site
            Picasso.get().load(passwordItem.image).into(siteImage)

        }
    }
}


