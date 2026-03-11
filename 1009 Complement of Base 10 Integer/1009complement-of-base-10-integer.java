class Solution {
    public int bitwiseComplement(int n) {

        String binaryNum = Integer.toBinaryString(n);
        char[] arr = binaryNum.toCharArray();

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == '0')
                arr[i] = '1';
            else
                arr[i] = '0';
        }

        return Integer.parseInt(new String(arr), 2);
    }
}