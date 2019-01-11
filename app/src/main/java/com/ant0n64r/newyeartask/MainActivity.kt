package com.ant0n64r.newyeartask

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.BitmapFactory
import android.support.v7.widget.CardView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView.OnItemClickListener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val java = BitmapFactory.decodeResource(this.getResources(),R.drawable.java)
        val c = BitmapFactory.decodeResource(this.getResources(), R.drawable.c)
        val python = BitmapFactory.decodeResource(this.getResources(), R.drawable.python)
        val cplusplus = BitmapFactory.decodeResource(this.getResources(),R.drawable.cplusplus)
        val visualbasic = BitmapFactory.decodeResource(this.getResources(), R.drawable.vb)
        val javascript = BitmapFactory.decodeResource(this.getResources(), R.drawable.javascript)
        val csharp = BitmapFactory.decodeResource(this.getResources(), R.drawable.csharp)
        val php = BitmapFactory.decodeResource(this.getResources(), R.drawable.php)
        val sql = BitmapFactory.decodeResource(this.getResources(), R.drawable.sql)
        val objectivec = BitmapFactory.decodeResource(this.getResources(),R.drawable.objectivec)

        recycler.layoutManager = GridLayoutManager(this, 2)


        val languaches = ArrayList<ProgrammingLanguage>()

        languaches.add(ProgrammingLanguage("Java", "Джеймс\nГослинг", 1995, "Imperative, Structured, Functional, Object-oriented", java, 1, "https://ru.wikipedia.org/wiki/Java"))
        languaches.add(ProgrammingLanguage("C", "Деннис Ритчи,\nКен Томпсон", 1972, "Imperative, Structured, Procedural", c, 2, "https://en.wikipedia.org/wiki/C_(programming_language)"))
        languaches.add(ProgrammingLanguage("Python", "Гвидо\nВан Россум", 1990, "Imperative, Structured, Procedural, Functional, Object-oriented", python, 3, "https://ru.wikipedia.org/wiki/Python"))
        languaches.add(ProgrammingLanguage("С++", "Бьёрн\nСтрауструп", 1983, "Imperative, Structured, Procedural, Functional, Object-oriented", cplusplus, 4, "https://ru.wikipedia.org/wiki/C%2B%2B"))
        languaches.add(ProgrammingLanguage("Visual Basic", "Microsoft", 1991, "Event-driven", visualbasic, 5, "https://ru.wikipedia.org/wiki/Visual_Basic"))
        languaches.add(ProgrammingLanguage("Java Script", "Брендан Эйх", 1995, "Functional, Event-driven, Object-oriented", javascript, 6, "https://ru.wikipedia.org/wiki/JavaScript"))
        languaches.add(ProgrammingLanguage("C#", "Андерс\nХейлсберг", 2000, "Object-oriented", csharp, 7, "https://ru.wikipedia.org/wiki/C_Sharp"))
        languaches.add(ProgrammingLanguage("PHP", "Расмус\nЛердорф", 1995, "Imperative, Structured, Procedural, Object-oriented", php, 8, "https://ru.wikipedia.org/wiki/PHP"))
        languaches.add(ProgrammingLanguage("SQL", "Д. Чемберлин,\nР. Бойс", 1974, "Declarative", sql, 9, "https://ru.wikipedia.org/wiki/SQL"))
        languaches.add(ProgrammingLanguage("Objective C", "Бред\nКокс", 1983, "Object-oriented", objectivec, 10, "https://ru.wikipedia.org/wiki/Objective-C"))

        val adapter = CustomAdapter(languaches)

        recycler.adapter = adapter

    }
}
