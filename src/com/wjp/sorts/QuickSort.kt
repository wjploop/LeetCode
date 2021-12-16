package sorts

object QuickSort {

    fun quickSort(nums: IntArray) {
        nums.println()
        helper(nums, 0, nums.size - 1)
    }

    private fun helper(nums: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }
        var start = left
        var end = right
        // 保存中轴的数，已经空出了一个坑
        var pivot = nums[start++]
        while (start < end) {
            println("pivot:${pivot}")
            // 寻找右边第一个比pivot小的数
            while (start < end && nums[end] > pivot) {
                end--
            }
            while (start < end && nums[start] < pivot) {
                start++
            }
            if (start < end) {
                if (nums[start] == nums[end]) {
                    // 一个数据即  <=pivot 又 >= pivot，即这两个数都是pivot
                    // 我们这里想要小于等于pivot的数放左边，故右移start
                    start++
                }else{
                    // 交换两个数
                    var temp = nums[start]
                    nums[start] = nums[end]
                    nums[end] = temp
                    nums.println()
                    println("swap ${nums[start]} and ${nums[end]}")
                }
            }
        }

        // 此时 start == end
        // 且左边除中轴外，全部数都小于pivot
        // 右边所有数大于中轴

        nums[start] = pivot
        //每一遍结束，pivot都能划分[left,right]
        nums.println()
        helper(nums, left, start - 1)
        helper(nums, start + 1, end)




    }

    //将数组翻转一位
    //这里效率很低啊
    private fun moveToHead(nums: IntArray, left: Int, right: Int) {
        val temp = nums[right]
        for (i in right downTo left + 1) {
            nums[i] = nums[i - 1]
        }
        nums[left] = temp
    }


}
