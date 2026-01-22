class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        StringBuilder temp = new StringBuilder(s);
        
        String rev = temp.reverse().toString();
        int k=0;

        for(int i=0; i<rev.length(); i++)
        {
            if(rev.charAt(i)==' ')
                break;
            k++;
        }
        return k;
    }
}