package com.example.myapp.plants

class Plant {
    var name : String? = null
    var poisonous : Boolean = false
    var height : Int = 0
    var type : PlantType? = null

    override fun toString(): String {
        return "$name ($type), " +
                (if (poisonous) "[poisonous], " else "") +
                "height: ${height / 100.0}m "
    }
}