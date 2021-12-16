package sorts

object SelectSort {
    fun sort(arr: IntArray) {
        for (i in 0 until arr.size - 2) {
            var min = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[min]) {
                    min = j
                }
            }
            arr.swap(i, min)
        }
    }
}