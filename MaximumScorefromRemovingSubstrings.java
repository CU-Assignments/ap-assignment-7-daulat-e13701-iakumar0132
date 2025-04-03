class Solution {
    public int maximumGain(String s, int x, int y) {
        return Math.max(removePairs(s, "ab", x, "ba", y), removePairs(s, "ba", y, "ab", x));
    }

    private int removePairs(String s, String first, int firstValue, String second, int secondValue) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        int countFirst = 0;
        for (char c : s.toCharArray()) {
            sb.append(c);
            int len = sb.length();
            if (len >= 2 && sb.substring(len - 2).equals(first)) {
                sb.setLength(len - 2);
                res += firstValue;
            }
        }
        s = sb.toString();
        sb.setLength(0);
        for (char c : s.toCharArray()) {
            sb.append(c);
            int len = sb.length();
            if (len >= 2 && sb.substring(len - 2).equals(second)) {
                sb.setLength(len - 2);
                res += secondValue;
            }
        }
        return res;
    }
}
