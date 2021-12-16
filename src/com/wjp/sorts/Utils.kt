package sorts

fun IntArray.println() {
    this.map { it.toString() }.joinToString().let {
        println(it)
    }
}

fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}