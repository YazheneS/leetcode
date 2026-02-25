class Solution {
    public int[] sortByBits(int[] arr) {
        int barr[]= new int[arr.length];
        int temp;
        for(int i=0; i<arr.length;i++)
            barr[i] = Integer.bitCount(arr[i]);
        for(int i=0; i<arr.length-1; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(barr[i]>barr[j] || barr[i]==barr[j] && arr[i]>arr[j])
                {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
            
                    temp=barr[i];
                    barr[i]=barr[j];
                    barr[j]=temp;
                }
            }
        }
        return arr;
    }
}