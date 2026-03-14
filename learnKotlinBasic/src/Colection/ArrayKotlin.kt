package Colection

class ArrayKotlin {

    val rockPhant = arrayOf<String>("Rock", "Paper", "kaka", "ghi")
    val gasPlanets = arrayOf<String>("Jupiter", "Saturn", "Uranus", "Neptune")

    val kaka: Array<String> = rockPhant + gasPlanets


}

fun main() {
//    var a = ArrayKotlin()
//    for (i in a.kaka) {
//        println(i)
//    }

    var solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    println(solarSystem.indexOf("Earth"))
//    solarSystem.add("Pluto")
}