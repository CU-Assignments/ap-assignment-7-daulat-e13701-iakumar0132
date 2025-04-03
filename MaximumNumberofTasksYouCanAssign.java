import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l = 0, r = Math.min(tasks.length, workers.length);
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (canAssign(tasks, workers, mid, pills, strength)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    private boolean canAssign(int[] tasks, int[] workers, int count, int pills, int strength) {
        Deque<Integer> deque = new ArrayDeque<>();
        int j = workers.length - count;
        for (int i = 0; i < count; i++) {
            while (j < workers.length && workers[j] < tasks[i]) deque.addLast(workers[j++]);
            if (!deque.isEmpty() && deque.peekFirst() + strength >= tasks[i]) deque.pollFirst();
            else if (pills > 0) pills--;
            else return false;
        }
        return true;
    }
}
