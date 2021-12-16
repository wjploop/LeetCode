package sorts

object InsertSort {
    fun sort(arr: IntArray) {
        val size = arr.size
        for (i in 1 until size) {
            //插入排序，就是将 [0..i-1]视为有序数组，将[i..size-1]无序数组插入到前面有序数组中
            val temp = arr[i]
            var j = i - 1
            // 从右往左找到一个第一个 >= arr[i]的数，并将target插入到该数后面
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j] //顺便将该整体右移一位
                j--
            }
            arr[j + 1] = temp
        }
    }

}