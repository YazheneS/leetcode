class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) 
            return -1;
        
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) 
                    return steps;
                
                char[] chars = curr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char originalChar = chars[j];
                    
                    for (int dir : new int[]{-1, 1}) {
                        int newDigit = (originalChar - '0' + dir + 10) % 10;
                        chars[j] = (char) (newDigit + '0');
                        String next = new String(chars);
                        
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    chars[j] = originalChar; 
                }
            }
            steps++;
        }
        return -1;
    }
}
