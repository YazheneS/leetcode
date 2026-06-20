class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int i = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                j++;
            }
            i++;
        }
        return j;
    }
}