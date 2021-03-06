package com.krystalove.newyeartask.View

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Spinner
import com.krystalove.newyeartask.Model.ProgrammingLanguage
import com.krystalove.newyeartask.Controller.Adapters.MyRecyclerViewAdapter
import com.krystalove.newyeartask.R
import java.util.*

lateinit var languages: ArrayList<ProgrammingLanguage>

class MainActivity : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener, AdapterView.OnItemSelectedListener {

    private var myRecyclerViewAdapter: MyRecyclerViewAdapter? = null

    override fun onItemClick(view: View, position: Int) {
        intent = Intent(this, WebViewActivity::class.java)
        Log.i("URL", myRecyclerViewAdapter!!.mLanguagesDataFiltered[position].Url)
        intent.putExtra("URL", myRecyclerViewAdapter!!.mLanguagesDataFiltered[position].Url)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        /*recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        val adapter = MyRecyclerViewAdapter(this, languages)
        adapter.setClickListener(this)*/
        myRecyclerViewAdapter = MyRecyclerViewAdapter(
            this,
            languages
        ).also{ it.setClickListener(this) }
        recyclerView.also {
            it.setHasFixedSize(true)
            it.layoutManager = GridLayoutManager(this, 1)
            it.adapter = myRecyclerViewAdapter
        }
        //recyclerView.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val item = menu.findItem(R.id.spinner)
        val spinner = item.actionView as Spinner
        //val paradigms = resources.getStringArray(R.array.paradigms)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.paradigms, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
        return true
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var query: String = ""
        if(parent?.getItemAtPosition(position).toString()!="All")
            query = parent?.getItemAtPosition(position).toString()
        myRecyclerViewAdapter!!.filter.filter(query)
        Log.i("ITEM:", parent?.getItemAtPosition(position) as String?)

    }
    private fun initData(){
        languages = ArrayList()
        languages.also {

            it.add(
                ProgrammingLanguage(
                    "Java",
                    "James Gosling",
                    "19 of May 1995",
                    listOf("OOP", "Structured", "Imperative", "Generic", "Reflective"),
                    getBitmap(R.drawable.java_1),
                    "16.904%",
                    "https://en.wikipedia.org/wiki/Java_(programming_language)"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "C",
                    "Dennis Ritchie, Kenneth Thompson",
                    "1972",
                    listOf("Procedural", "Structured", "Imperative"),
                    getBitmap(R.drawable.c_2),
                    "13.337%",
                    "https://en.wikipedia.org/wiki/C_(programming_language)"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "Python",
                    "Guido van Rossum",
                    "20 of February 1991",
                    listOf("OOP", "Reflective", "Imperative", "Functional", "Aspect-oriented"),
                    getBitmap(R.drawable.python_3),
                    "8.294%",
                    "https://en.wikipedia.org/wiki/Python_(programming_language)"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "C++",
                    "Bjarne Stroustrup",
                    "1983",
                    listOf("Procedural", "Functional", "OOP", "Generic"),
                    getBitmap(R.drawable.cpp_4),
                    "8.158%",
                    "https://en.wikipedia.org/wiki/C%2B%2B"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "Visual Basic. NET",
                    "Microsoft Corporation",
                    "2001",
                    listOf("Imperative", "OOP", "Structured", "Declarative", "Generic", "Even-driven"),
                    getBitmap(R.drawable.vnet_5),
                    "6.459%",
                    "https://en.wikipedia.org/wiki/Visual_Basic_.NET"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "JavaScript",
                    "Brendan Eich",
                    "1995",
                    listOf("Imperative", "OOP", "Functional", "Aspect-oriented", "Generic", "Event-driven"),
                    getBitmap(R.drawable.js_6),
                    "3.302%",
                    "https://en.wikipedia.org/wiki/JavaScript"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "C#",
                    "Anders Hejlsberg",
                    "2000",
                    listOf("OOP", "Procedural", "Functional", "Event-driven", "Generic", "Reflective"),
                    getBitmap(R.drawable.csharp_7),
                    "3.284%",
                    "https://en.wikipedia.org/wiki/C_Sharp_(programming_language)"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "PHP",
                    "Rasmus Lerdof",
                    "1995",
                    listOf("OOP", "Imperative"),
                    getBitmap(R.drawable.php_8),
                    "2.680%",
                    "https://en.wikipedia.org/wiki/PHP"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "SQL",
                    "Raymond Boyce, Donald Chemberlin",
                    "1974",
                    listOf("Declarative"),
                    getBitmap(R.drawable.sql_9),
                    "2.277%",
                    "https://en.wikipedia.org/wiki/SQL"
                )
            )
            it.add(
                ProgrammingLanguage(
                    "Objective C",
                    "Brad Cox",
                    "1984",
                    listOf("Reflective", "OOP"),
                    getBitmap(R.drawable.objc_10),
                    "1.781%",
                    "https://ru.wikipedia.org/wiki/Objective-C"
                )
            )
        }
    }
    private fun getBitmap(bitmapID: Int):Bitmap = BitmapFactory.decodeResource(resources, bitmapID)

}
