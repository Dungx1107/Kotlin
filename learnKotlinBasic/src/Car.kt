class Car : Vehical {
    override val numberOfWheel: Int
        get() = 4
    override val name: String
        get() = "Car"
    var nameChu: String = ""
    var giaTien: String = ""

    constructor(name: String, giaTien: String) {
        this.nameChu = name
        this.giaTien = giaTien
    }
    fun desCar(){
        print("gia tin la ${giaTien}" )
    }
    fun desChu(){
        print("ten cua chu ${nameChu}")
    }
//    override fun go() {
//        super.go()
//        println("$name go")
//    }
}