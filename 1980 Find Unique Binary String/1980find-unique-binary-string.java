class Solution {

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        String[] all = new String[1 << n];

        generate(n, "", all, new int[]{0});

        for(String s : all){
            if(!exists(nums, s)){
                return s;
            }
        }

        return "";
    }

    static void generate(int n, String curr, String[] all, int[] index){

        if(curr.length() == n){
            all[index[0]++] = curr;
            return;
        }

        generate(n, curr + "0", all, index);
        generate(n, curr + "1", all, index);
    }

    static boolean exists(String[] nums, String target){

        for(String s : nums){
            if(s.equals(target))
                return true;
        }

        return false;
    }
}