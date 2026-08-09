//Hashing
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a).equals(freqMap.get(b)) ? b - a : freqMap.get(a) - freqMap.get(b)
        );
        
        for (int num : nums) {
            heap.add(num);
        }
        
        int[] result = new int[nums.length];
        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.poll();
        }
        
        return result;
    }
}