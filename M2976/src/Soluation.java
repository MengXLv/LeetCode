class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (i != j) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        long ans = 0;
        int m = source.length(), n = original.length;
        for (int i = 0; i < n; ++i) {
            dist[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], dist[original[i] - 'a'][changed[i] - 'a']);
        }
        for (int k = 0; k < 26; ++k) {
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < 26; ++j) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            long weight = dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (weight == Integer.MAX_VALUE)
                return -1;
            ans += weight;
        }
        return ans;
    }
}
