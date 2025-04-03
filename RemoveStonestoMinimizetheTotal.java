import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int pile : piles) {
            pq.add(pile);
            sum += pile;
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int maxPile = pq.poll();
            int remove = maxPile / 2;
            sum -= remove;
            pq.add(maxPile - remove);
        }
        return sum;
    }
}
