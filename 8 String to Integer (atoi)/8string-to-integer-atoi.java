class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int sign=1, i=0;
        long num=0;

        if (s.length() == 0) 
            return 0;

        if (s.charAt(0) == '-') 
        { 
            sign = -1;
            i++; 
        } 
        else if (s.charAt(0) == '+') 
        {
            i++;
        }    

        for(; i<s.length();i++)
        {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') 
                break;
            
            num= num*10 + (ch-'0');

            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE; 
            else if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        }
        
        return (int) (sign * num);
    }
}