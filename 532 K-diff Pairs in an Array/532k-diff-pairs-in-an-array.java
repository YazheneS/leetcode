class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        Set<String> pairs = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num - k))
                pairs.add(Math.min(num, num - k) + "_" + Math.max(num, num - k));
            if (seen.contains(num + k))
                pairs.add(Math.min(num, num + k) + "_" + Math.max(num, num + k));
            seen.add(num);
        }
        return pairs.size();
    }
}