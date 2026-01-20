class Solution {
    public boolean isPalindrome(int x) 
    {
        int num=x, r, s=0;
        while(x>0)
        {
            r=x%10;
            s=s*10+r;
            x/=10;
        }
        if(num==s)
            return true;
        return false;
    }
}