package vega.odyssey.passpilot

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FreddyFragment : Fragment() {
    private var passwords:MutableList<PasswordItem> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_freddy, container, false)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)
        var recyclerView = view.findViewById<RecyclerView>(R.id.infoRecycler)

        fab.setOnClickListener(){
            val bsd = BottomSheetDialog(view.context)
            val parentView: View= layoutInflater.inflate(R.layout.bsd_add_info, null)
            bsd.setContentView(parentView)
            bsd.show()

            val bdsmid = parentView.findViewById<EditText>(R.id.bsdTxtID)
            val bdsmname = parentView.findViewById<EditText>(R.id.bsdTxtUsername)
            val bdsmpassword = parentView.findViewById<EditText>(R.id.bsdTxtPassword)
            val bdsmsite = parentView.findViewById<EditText>(R.id.bsdTxtSite)
            val bdsmimageurl = parentView.findViewById<EditText>(R.id.bsdImgSite)
            val bdsmbutton = parentView.findViewById<Button>(R.id.bsdBtnAdd)

            bdsmbutton.setOnClickListener() {
                Toast.makeText(context, bdsmid.text, Toast.LENGTH_SHORT).show()
                val newpassword = PasswordItem(
                    bdsmid.text.toString().toInt(),
                    bdsmname.text.toString(),
                    bdsmpassword.text.toString(),
                    bdsmsite.text.toString(),
                    bdsmimageurl.text.toString()
                )
                passwords.add(
                    newpassword
                )

                recyclerView.adapter?.notifyDataSetChanged()
                bsd.dismiss()
            }

        }


    initData()

    val layoutManager = LinearLayoutManager(container?.context)

    val adapter = PasswordItemAdapter(passwords)
    recyclerView?.layoutManager = layoutManager
    recyclerView?.adapter = adapter

    return view
    }

    public fun initData(){
        passwords = mutableListOf(
            PasswordItem(1, "Ruben", "passwordcita", "YouTube", "https://creazilla-store.fra1.digitaloceanspaces.com/icons/3245993/youtube-round-icon-md.png"),
            PasswordItem(2, "Dabnee", "dabnee123", "Facebook", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/2021_Facebook_icon.svg/2048px-2021_Facebook_icon.svg.png"),
            PasswordItem(3, "Jorge", "mona_china321", "Twitter", "https://freelogopng.com/images/all_img/1690643640twitter-x-icon-png.png"),
            PasswordItem(4, "Dan", "dansaurio69", "Instagram", "https://cdn-icons-png.flaticon.com/512/4138/4138124.png")

            )
    }
}