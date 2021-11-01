package com.wjp.contest.leetcode_2021_10_31;

class Contest4 {
    public static void main(String[] args) {
        Solution solution = new Contest4().new Solution();
        boolean res = solution.possiblyEquals("internationalization", "i18n");

        System.out.println(res);
    }

    class Solution {
        public boolean possiblyEquals(String s1, String s2) {
            char[] chs1 = s1.toCharArray();
            char[] chs2 = s2.toCharArray();
            return possible(chs1, 0, 0, chs2, 0, 0);
        }

        private boolean possible(char[] chs1, int x, int count1, char[] chs2, int y, int count2) {
            if (x == chs1.length && y == chs2.length) {
                return count1 == 0 && count2 == 0;
            }
            if (x == chs1.length || y == chs2.length) {
                return false;
            }

            System.out.println(new String(chs1) + " " + new String(chs2)+ "  " + chs1[x] + "," + chs2[y] + "  count " + count1 + ":" + count2);

            if (count1 < count2) {
                return possible(chs2, y, count2, chs1, x, count1);
            }
            if (count2 > 0) {
                return possible(chs1, x, count1 - count2, chs2, y, 0);
            }
            // count2 = 0
            if (count1 > 0) {
                if (isAbc(chs2[y])) {
                    return possible(chs1, x, count1 - 1, chs2, y + 1, 0);
                } else {
                    boolean p1 = possible(chs1, x + 1, chs1[x] - '0', chs2, y, 0);
                    if (p1) {
                        return true;
                    }
                    if (x + 1 < chs1.length && !isAbc(chs1[x + 1])) {
                        int count11 = count1 * 10 + chs1[x + 1] - '0';
                        boolean p2 = possible(chs1, x + 2, count11, chs2, y, 0);
                        if (p2) {
                            return true;
                        }
                        if (x + 2 < chs1.length && !isAbc(chs1[x + 2])) {
                            int count111 = count11 * 10 + chs1[x + 2] - '0';
                            boolean p3 = possible(chs1, x + 3, count111, chs2, y, 0);
                            if (p3) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
            // count1 == count2 ==0
            if (isAbc(chs1[x]) && isAbc(chs2[y])) {
                if (chs1[x] != chs2[y]) {
                    return false;
                } else {
                    return possible(chs1, x + 1, 0, chs2, y + 1, 0);
                }
            } else if (!isAbc(chs1[x]) && isAbc(chs2[y])) {
                return possible(chs1, x + 1, chs1[x] - '0', chs2, y, 0);
            } else if (isAbc(chs1[x]) && !isAbc(chs2[y])) {
                return possible(chs2, y, 0, chs1, x, 0);
            } else {
                return possible(chs1, x + 1, chs1[x] - '0', chs2, y + 1, chs2[y] - '0');
            }
        }

        boolean isAbc(char ch) {
            return ch >= 'a' && ch <= 'z';
        }

    }
}