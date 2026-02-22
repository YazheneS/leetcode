class Solution {
    public boolean isPalindrome(String s) {
        String org = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        String rev = new StringBuilder(org).reverse().toString();
        return org.equals(rev);
    }
}