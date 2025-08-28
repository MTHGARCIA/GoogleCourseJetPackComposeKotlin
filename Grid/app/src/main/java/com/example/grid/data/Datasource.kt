package com.example.grid.data


import com.example.grid.R
import com.example.grid.model.Affirmation

class Datasource() {

    fun loadAffirmations(): List<Affirmation>{
        return listOf<Affirmation>(
            Affirmation(R.string.architecture, 58, R.drawable.architecture),
            Affirmation(R.string.automotive, 30, R.drawable.automotive),
            Affirmation(R.string.biology, 90, R.drawable.biology),
            Affirmation(R.string.crafts, 121, R.drawable.crafts),
            Affirmation(R.string.business, 78, R.drawable.business),
            Affirmation(R.string.culinary, 118, R.drawable.culinary),
            Affirmation(R.string.design, 423, R.drawable.design),
            Affirmation(R.string.ecology, 28, R.drawable.ecology),
            Affirmation(R.string.engineering, 67, R.drawable.engineering),
            Affirmation(R.string.fashion, 92, R.drawable.fashion),
            Affirmation(R.string.finance, 100, R.drawable.finance),
            Affirmation(R.string.film, 165, R.drawable.film),
            Affirmation(R.string.gaming, 37, R.drawable.gaming),
            Affirmation(R.string.geology, 290, R.drawable.geology),
            Affirmation(R.string.drawing, 326, R.drawable.drawing),
            Affirmation(R.string.history, 189, R.drawable.history),
            Affirmation(R.string.journalism, 96, R.drawable.journalism),
            Affirmation(R.string.law, 58, R.drawable.law),
            Affirmation(R.string.lifestyle, 305, R.drawable.lifestyle),
            Affirmation(R.string.music, 212, R.drawable.music),
            Affirmation(R.string.painting, 172, R.drawable.painting),
            Affirmation(R.string.photography, 321, R.drawable.photography),
            Affirmation(R.string.physics, 41, R.drawable.physics),
            Affirmation(R.string.tech, 118, R.drawable.tech),
    )
    }
}