package com.ant0n64r.newyeartask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.BitmapFactory
import android.support.v7.widget.GridLayoutManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*



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

        val languages = mutableListOf<ProgrammingLanguage>()

        fun fillAll(languages:MutableList<ProgrammingLanguage>){
            languages.add(ProgrammingLanguage("Java", "Джеймс\nГослинг", 1995, listOf<String>(getString(R.string.functional),getString(R.string.imperative),getString(R.string.objectoriented),getString(R.string.structured)), java, 1, "https://ru.wikipedia.org/wiki/Java"))
            languages.add(ProgrammingLanguage("C", "Деннис Ритчи,\nКен Томпсон", 1972, listOf<String>(getString(R.string.imperative),getString(R.string.procedural),getString(R.string.structured)), c, 2, "https://en.wikipedia.org/wiki/C_(programming_language)"))
            languages.add(ProgrammingLanguage("Python", "Гвидо\nВан Россум", 1990, listOf<String>(getString(R.string.functional),getString(R.string.imperative),getString(R.string.objectoriented),getString(R.string.procedural),getString(R.string.structured)), python, 3, "https://ru.wikipedia.org/wiki/Python"))
            languages.add(ProgrammingLanguage("С++", "Бьёрн\nСтрауструп", 1983, listOf<String>(getString(R.string.functional),getString(R.string.imperative),getString(R.string.objectoriented),getString(R.string.procedural),getString(R.string.structured)), cplusplus, 4, "https://ru.wikipedia.org/wiki/C%2B%2B"))
            languages.add(ProgrammingLanguage("Visual Basic", "Microsoft", 1991, listOf<String>(getString(R.string.eventdriven)), visualbasic, 5, "https://ru.wikipedia.org/wiki/Visual_Basic"))
            languages.add(ProgrammingLanguage("Java Script", "Брендан Эйх", 1995, listOf<String>(getString(R.string.eventdriven),getString(R.string.functional),getString(R.string.objectoriented)), javascript, 6, "https://ru.wikipedia.org/wiki/JavaScript"))
            languages.add(ProgrammingLanguage("C#", "Андерс\nХейлсберг", 2000, listOf<String>(getString(R.string.objectoriented)), csharp, 7, "https://ru.wikipedia.org/wiki/C_Sharp"))
            languages.add(ProgrammingLanguage("PHP", "Расмус\nЛердорф", 1995, listOf<String>(getString(R.string.imperative),getString(R.string.objectoriented),getString(R.string.procedural),getString(R.string.structured)), php, 8, "https://ru.wikipedia.org/wiki/PHP"))
            languages.add(ProgrammingLanguage("SQL", "Д. Чемберлин,\nР. Бойс", 1974, listOf<String>(getString(R.string.declarative)), sql, 9, "https://ru.wikipedia.org/wiki/SQL"))
            languages.add(ProgrammingLanguage("Objective C", "Бред\nКокс", 1983, listOf<String>(getString(R.string.objectoriented)), objectivec, 10, "https://ru.wikipedia.org/wiki/Objective-C"))
        }


        fillAll(languages)

        recycler.layoutManager = GridLayoutManager(this, 2)
        var adapter = CustomAdapter(languages)
        recycler.adapter = adapter

        //функция добавляет onClickListener для определенной кнопки и фильтрует элементы recycler'а по заданной строке
        fun onClickSetter(but:Button,currString:String){
            but.setOnClickListener {
                languages.clear()
                fillAll(languages)
                val sortString = currString
                val langSorted = mutableListOf<ProgrammingLanguage>()
                for (lang in languages){
                    for (paradigm in lang.paradigms){
                        if (paradigm == sortString){
                            langSorted.add(lang)
                        }
                    }
                }
                adapter = CustomAdapter(langSorted)
                recycler.adapter = adapter
            }
        }

        onClickSetter(eventDrivenSortBut,getString(R.string.eventdriven))
        onClickSetter(declarativeSortBut,getString(R.string.declarative))
        onClickSetter(functionalSortBut,getString(R.string.functional))
        onClickSetter(imperativeSortBut,getString(R.string.imperative))
        onClickSetter(objOrientSortBut,getString(R.string.objectoriented))
        onClickSetter(proceduralSortBut,getString(R.string.procedural))
        onClickSetter(structuredSortBut,getString(R.string.structured))

        allSortBut.setOnClickListener {
            languages.clear()
            fillAll(languages)
            adapter = CustomAdapter(languages)
            recycler.adapter = adapter
        }

    }



}
