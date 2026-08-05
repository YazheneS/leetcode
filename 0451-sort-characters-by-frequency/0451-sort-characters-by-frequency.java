class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freq.get(a) != freq.get(b)
                ? freq.get(b) - freq.get(a)   // higher freq first
                : a - b                        // lexicographic for ties
        );

        pq.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}