class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> woDupli = new HashSet<>(); 
        for(int num : nums)
            woDupli.add(num);
        return nums.length != woDupli.size();
    }
}