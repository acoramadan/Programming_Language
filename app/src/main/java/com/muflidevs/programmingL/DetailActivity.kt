package com.muflidevs.programmingL

import android.app.Person
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muflidevs.programmingL.Data.ProgrammingData

class DetailActivity : AppCompatActivity() {
    private lateinit var tvDetailJudul : TextView
    private lateinit var tvDetailDeskripsi : TextView
    private lateinit var imgDetailPhoto : ImageView

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

        tvDetailDeskripsi.text = dataBahasa?.description.toString()
        tvDetailJudul.text = dataBahasa?.judul.toString()
        imgDetailPhoto.setImageResource(dataBahasa!!.photo)

    }
}