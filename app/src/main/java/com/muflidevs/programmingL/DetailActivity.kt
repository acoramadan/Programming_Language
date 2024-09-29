package com.muflidevs.programmingL

import android.app.Person
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muflidevs.programmingL.Data.ProgrammingData

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvDetailJudul : TextView
    private lateinit var tvDetailDeskripsi : TextView
    private lateinit var imgDetailPhoto : ImageView
    private lateinit var icBack : TextView
    private lateinit var btnShare : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_detail)
        val dataBahasa = if(Build.VERSION.SDK_INT >=33) {
            intent.getParcelableExtra<ProgrammingData>("key_bahasa",ProgrammingData::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<ProgrammingData>("key_bahasa")
        }
        tvDetailJudul = findViewById(R.id.tv_judul)
        tvDetailDeskripsi = findViewById(R.id.tv_deskripsi)
        imgDetailPhoto = findViewById(R.id.img_detail)
        icBack = findViewById(R.id.back)
        btnShare = findViewById(R.id.share)
        tvDetailDeskripsi.text = dataBahasa?.description.toString()
        tvDetailJudul.text = dataBahasa?.judul.toString()
        imgDetailPhoto.setImageResource(dataBahasa!!.photo)

        icBack.setOnClickListener(this)

        btnShare.setOnClickListener {
            val sendIntent : Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,dataBahasa?.description.toString())
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent,null)
            startActivity(shareIntent)
        }

    }

    override fun onClick(view : View?) {
        when(view?.id) {
            R.id.back -> {
                finish()
            }
        }
    }

}