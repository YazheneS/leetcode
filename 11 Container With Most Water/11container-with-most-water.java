class Solution {
    public int maxArea(int[] height) 
    {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        int h;
        while(left<right)
        {
            h=Math.min(height[left], height[right]);
            area= Math.max(area, (right-left) * h );

            if(height[left] <height[right])
                left++;
            else
                right--;
        }
        return area;
    }
}