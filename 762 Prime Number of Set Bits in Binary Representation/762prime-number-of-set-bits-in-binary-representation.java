class Solution {
    public int countPrimeSetBits(int left, int right) {
        int sum=0;
        for(int i=left; i<=right;i++)
        {
            String binary = Integer.toBinaryString(i);
            int freq=0;
            for (int j = 0; j < binary.length(); j++) 
            {
                if (binary.charAt(j) == '1') 
                    freq++;
            }
            
            if(isPrime(freq))
                sum++;
        }
        return sum;
        
    }
    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}