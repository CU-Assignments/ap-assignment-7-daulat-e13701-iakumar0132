import java.util.*;

class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) indexMap.put(target[i], i);
        List<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            if (indexMap.containsKey(num)) {
                int idx = indexMap.get(num);
                int pos = Collections.binarySearch(lis, idx);
                if (pos < 0) pos = -pos - 1;
                if (pos < lis.size()) lis.set(pos, idx);
                else lis.add(idx);
            }
        }
        return target.length - lis.size();
    }
}
