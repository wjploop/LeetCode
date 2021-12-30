package com.wjp.contest.leetcode_2021_12_23;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public String firstPalindrome(String[] words) {
            for (String word : words) {
                if (isPalindrome(word)) {
                    return word;
                }
            }
            return "";
        }

        boolean isPalindrome(String word) {
            int i = 0, j = word.length() - 1;
            while (i < j) {
                if (word.charAt(i) == word.charAt(j)) {
                    i++;
                    j--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}