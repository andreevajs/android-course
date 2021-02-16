package com.example.myapp.plants

import kotlin.random.Random

class PlantGroupGenerator {
    private var nameParts: List<String> = listOf("an", "shy", "shi", "lo", "se", "ro", "fa", "m", "k", "isi", "sli", "shu", "vi", "vao", "fu", "fun", "var", "val", "set", "ri",
            "da", "mo", "co", "ne", "no", "de", "el", "la", "ono", "uno", "ux", "iji", "msi", "exe", "bat", "doc")
    private var nameEndings: List<String> = listOf("um", "is", "lis", "alis", "isa", "ca", "us", "ta", "sa")

    fun generateRandom(minPlantsCount: Int, maxPlantsCount: Int): MutableList<Plant> {
        val plants: MutableList<Plant> = mutableListOf<Plant>()
        for (i in 1..(minPlantsCount..maxPlantsCount).random())
            plants.add(Plant().apply {
                name = generateName((2..5).random()) + " " + generateName((2..4).random())
                poisonous = Random.nextBoolean()
                height = (10..2000).random();
                type = PlantType.values().random()
            })
        return plants
    }

    private fun generateName(complexity: Int): String {
        val name = StringBuilder()
        for (i in 1 until complexity)
            name.append(nameParts.random())
        name.append(nameEndings.random())
        return name.toString().capitalize()
    }
}