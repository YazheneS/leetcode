class Solution {

    public char findKthBit(int n, int k) {

        String s = "0";

        for(int i = 2; i <= n; i++)
        {
            s = s + "1" + rev(invert(s));
        }

        return s.charAt(k - 1);
    }

    private String invert(String s)
    {
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == '0')
                arr[i] = '1';
            else
                arr[i] = '0';
        }

        return new String(arr);
    }

    private String rev(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }
}