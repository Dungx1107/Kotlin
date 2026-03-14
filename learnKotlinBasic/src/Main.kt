//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    main2()
}

fun main2() {
    println("Earth".hashCode())
    println("Mars".hashCode())
}

fun main1() {
//   var car = Car()
//    println("Car is $car")
//    println(car.name)
//
//    Car().go()
    var car1 = Car("Dung", "1 ti")
    var car2 = Car("Dung1", "2 ti")
    var car3 = Car("Dung2", "3 ti")

    println(car1.giaTien)
    println(car1.nameChu)

    car1.let {
        println(it.giaTien)
        println(it.nameChu)
    }

    car1.apply {
        desCar()
        desChu()
    }
}