package sorts

fun main() {
    HeapSort.heapSort(intArrayOf())
}

/**
 * 参考 https://www.cnblogs.com/chengxiao/p/6129630.html
 *
 * 堆排序，首先要求时完全二叉树，使用数组的存储结构，叶子节点只会在倒数第二层出现
 * 大根堆，节点值均小于根节点
 * 使用数组存储结构时，根节点与子节点关系可以通过下标换算的，arr[left] = arr[root*2+1] , arr[right] = arr[root*2+2]
 *
 *
 */
object HeapSort {
    fun heapSort(arr: IntArray) {
//        val arr = intArrayOf(4, 6, 8, 5, 9)
        arr.println()
        val len = arr.size
        for (i in len / 2 - 1 downTo 0) {
            adjustHeap(arr, i, len)
        }
        for (k in len - 1 downTo 1) {
            arr.swap(0, k)
            adjustHeap(arr, 0, k)
        }
        arr.println()
        arr.joinToString()

        listOf<Int>().joinToString()
    }

    //以firstRoot开始，使得该节点为最大值
    //注意该调整有个前提，其左右子树已经是个大根堆了
    //故，初始化一个大根堆，则需要最后一个非叶子节点开始，从下往上，从左往右迭代调整
    private fun adjustHeap(arr: IntArray, firstRoot: Int, len: Int) {
        var root = firstRoot
        val max = arr[firstRoot]    //其实我们就是要找最大的元素
        var k = 0
        do {
            k = root * 2 + 1
            if (k < len) {
                //要找到左右节点中较大的哦
                if (k + 1 < len && arr[k] < arr[k + 1]) {
                    k++
                }
                if (arr[k] > max) {    //若是存在叶子节点比root大的情况
                    arr[root] = arr[k]
                    root = k    //root指向该叶子节点，继续循环以该root为节点的树
                } else {
                    break
                }
            }
        } while (k < len)
        arr[root] = max
    }


}

