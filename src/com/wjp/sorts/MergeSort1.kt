package sorts

object MergeSort1 {
    //另外，可以利用归并排序的稳定性，
    fun mergeSort(nums: IntArray) {
        val copy = nums.copyOf()
        helper(nums, copy, 0, nums.size - 1)
    }

    private fun helper(nums: IntArray, copy: IntArray, left: Int, right: Int) {
        if (left == right) {
            return
        }
        if(right-left+1 <9 ){
            println("use insert sort, left:${nums[left]}, right:${nums[right]}")
            insertSort(nums,left,right);
            return;
        }
        val mid = left + (right - left) / 2
        helper(nums, copy, left, mid)
        helper(nums, copy, mid + 1, right)
        mergeArr(nums, copy, left, mid, right)
    }

    // 合并两个有序的数组，为了避免每次都要创建一个字数组来保存，使用copy
    private fun mergeArr(nums: IntArray, copy: IntArray, left: Int, mid: Int, right: Int) {
        nums.println()
        println("mid:${nums[mid]}, left:${nums[left]}, right:${nums[right]}")

        // 依赖上一次合并状态
        for (i in left..right) {
            copy[i] = nums[i]
        }
        var i = left
        var j = mid + 1
        var k = left
        while (i <= mid && j <= right) {
            if (copy[i] <= copy[j]) {
                nums[k++] = copy[i++]
            } else {
                nums[k++] = copy[j++]
            }
        }
        while (i <= mid) {
            nums[k++] = copy[i++]
        }
        while (j <= right) {
            nums[k++] = copy[j++]
        }
    }


    private fun insertSort(nums: IntArray, left: Int, right: Int) {
        for (i in left + 1..right) {
            var key = nums[i];
            var k = i - 1;
            while (k >= left && nums[k] > key) {
                nums[k + 1] = nums[k];
                k--;
            }
            nums[k+1] = key;
            nums.println()
        }
    }


}
