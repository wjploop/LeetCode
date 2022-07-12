package com.wjp.problems.算法;

import java.util.Arrays;

/**
 * 一个数组中，寻找最大的k个数
 * 1. 排序 NlogN
 * 2. 冒泡排序 k * N
 * 3. k
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 8, 1, 9, 7, 4, 6, 5,118,13};
//        int[] topK = new TopK().topKBobble(nums, 4);
//        int[] topK = new TopK().topKHeap(nums, 4);
        int[] topK = new TopK().topKQuick(nums, 4);
        print(topK);
    }

    /**
     * 相比于整体排序后取前k个，需要 N * logN
     * 我们局部排序，则只需选出K个最大的数，即 N * K
     * 但，这里，我们多做了一个操作，内含了一个操作，将K个数做了排序
     */
    int[] topKBobble(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return Arrays.copyOf(nums, k);
    }

    /**
     * 建立一个大小为k的小根堆
     * 后续的数跟堆根节点比较，比根节点小，则说明最大的数不会是根节点，交换, 调整小根堆
     * 比较 n次，调整的时间复杂度为 logK，即 N * logK
     */

    int[] topKHeap(int[] nums, int k) {
        // 构造大小为k的小根堆
        build(nums, k);
        print(nums);

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, i, 0);
                adjustHeap(nums, 0, k);
            }
        }
        return Arrays.copyOf(nums, k);
    }

    void build(int[] nums, int n) {
        for (int i = n / 2; i >= 0; i--) {
            adjustHeap(nums, i, n);
        }
    }

    void adjustHeap(int[] heap, int root, int n) {
        System.out.println("adjust heap :" + root + ", " + n);
        while (true) {
            int left = 2 * root, right = left + 1;
            // 到达叶子节点
            if (left >= n) {
                break;
            }
            if (right >= n) {
                right = left;
            }
            int min = heap[left] < heap[right] ? left : right;
            if (heap[root] < heap[min] || min == 0) {
                break;
            }
            // 交换小的到跟节点
            swap(heap, root, min);
            // 继续调整以root下面的子树
            root = min;

        }
    }

    /**
     * 快排思路
     * 随机选中一个数，划分为俩份
     * 假设大的在左边，假设左边的个数大k，继续划分左边
     * 否则，继续在
     *
     */
    int[] topKQuick(int[] nums, int k) {
        topK(nums, 0, nums.length - 1, k);
        return Arrays.copyOf(nums, k);
    }

    void topK(int[] nums, int start, int end, int k) {
        int mid = quickSelect(nums, start, end);
        int leftCount = mid - start;
        if (leftCount == k || leftCount + 1 == k) {
            return;
        } else if (leftCount > k) {
            topK(nums, start, mid - 1, k);
        } else {
            topK(nums, mid + 1, end, k - leftCount - 1);
        }
    }

    // 找出比最左边的的元素小的元素个数

    private int quickSelect(int[] nums, int left, int right) {
        int i = left, j = right;
        int pivot = nums[left];
        while (i < j) {
            if (i < j && nums[j] <= pivot) {
                j--;
            }
            // 更大的元素移入左边
            // 右边有坑位了
            nums[i] = nums[j];
            // 左起第一个小于pivot
            if (i < j && nums[i] >= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println("");
    }
}
