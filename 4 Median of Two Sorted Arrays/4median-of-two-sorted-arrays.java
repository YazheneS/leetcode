class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int [] merge= new int [nums1.length + nums2.length];
        for(int i=0;i<nums1.length;i++)
            merge[i]=nums1[i];
        for(int i=0;i<nums2.length;i++)
            merge[nums1.length+i]=nums2[i];
        Arrays.sort(merge);
        if((nums1.length + nums2.length)%2 ==1)
            return merge[(nums1.length + nums2.length)/2];
        else
            return (merge[(nums1.length + nums2.length)/2-1] + merge[(nums1.length + nums2.length)/2]) /2.0;
    }
}