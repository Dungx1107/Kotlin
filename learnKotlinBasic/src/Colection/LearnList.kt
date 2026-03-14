package Colection

class LearnList {
}

/*
*Các phần tử có thứ tự
Có chỉ mục (index)
Index bắt đầu từ 0
Chỉ đọc (read-only) → không thêm/xóa/sửa được
*/
fun main1() {
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    for (i in solarSystem) {
        println(i)
    }

    println("Số lượng phần tử trong list ${solarSystem.size}")

    // truy cập các phần tử trong List
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])

    ngan()

    println(solarSystem.get(0))
    println(solarSystem.get(1))
    println(solarSystem.get(2))

/*
Phương thức indexOf() tìm kiếm danh sách cho một phần tử nhất định
(được truyền dưới dạng đối số) và trả về chỉ mục trong lần xuất hiện đầu tiên của phần tử đó.
Nếu không có phần tử nào trong danh sách, chỉ số được trả về sẽ là -1.
*/
    println(solarSystem.indexOf("Earth"))


}

fun main() {
//    main1()
    main2()
}

/*
MutableList (List có thể thay đổi)
*/
fun main2() {
    val solarSystem = mutableListOf(
        "Mercury",
        "Venus",
        "Earth",
        "Mars"
    )

    solarSystem.add("Pluto")
    println(solarSystem[solarSystem.size - 1])
}

fun ngan() {
    println("-----------------------------------")
}
