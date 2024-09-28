package com.muflidevs.programmingL

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muflidevs.programmingL.Adapter.ListProgrammingAdapter
import com.muflidevs.programmingL.Data.ProgrammingData

class MainActivity : AppCompatActivity() {
    private lateinit var rvProgrammings : RecyclerView
    private val list = ArrayList<ProgrammingData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvProgrammings = findViewById(R.id.rv_progamming)
        rvProgrammings.setHasFixedSize(true)

        list.addAll(getListProgrammings())
        showRecylerList()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
   override fun onCreateOptionsMenu(menu: Menu?) : Boolean{
       menuInflater.inflate(R.menu.menu_main,menu)
       return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about -> {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListProgrammings() : ArrayList <ProgrammingData> {
        val dataJudul = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listProgrammings = ArrayList<ProgrammingData>()

        for (i in dataJudul.indices) {
            val programmings = ProgrammingData(dataJudul[i],dataDescription[i],dataPhoto.getResourceId(i,-1))
            listProgrammings.add(programmings)
        }
        return listProgrammings
    }

    private fun showRecylerList() {
        rvProgrammings.layoutManager = LinearLayoutManager(this)
        val listProgrammingsAdapter = ListProgrammingAdapter(list)
        rvProgrammings.adapter = listProgrammingsAdapter
    }
}