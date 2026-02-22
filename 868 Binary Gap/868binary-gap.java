class Solution 
{
    public int binaryGap(int n) 
    {
        String binary = Integer.toBinaryString(n);
        int size=binary.length();
        int []one =new int [size];
        int idx=0;
        for (int i = 0; i < size; i++) 
        {
            if(binary.charAt(i)=='1')
            {
                one[idx]=i;
                idx++;
            }
        }
        int maxDist=0;
        for(int i=0; i<one.length-1;i++)
        {
            int j=i+1;
            int dist= one[j]-one[i];
            maxDist = Math.max(dist,maxDist);
        }
        return maxDist;
    }
}