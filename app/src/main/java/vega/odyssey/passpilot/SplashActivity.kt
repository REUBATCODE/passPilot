package vega.odyssey.passpilot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val image = findViewById<ImageView>(R.id.imageView)
        image.setOnClickListener{
            Toast.makeText(this, "Imagen tocada", Toast.LENGTH_SHORT).show()
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

    }

}