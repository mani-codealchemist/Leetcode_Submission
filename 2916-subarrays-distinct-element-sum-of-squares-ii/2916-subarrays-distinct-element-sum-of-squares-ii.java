
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        long[] sum = new long[4 * n];
        long[] squares = new long[4 * n];
        long[] lazy = new long[4 * n];

        java.util.HashMap<Integer, Integer> last = new java.util.HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int left = last.getOrDefault(nums[i], -1) + 1;

            update(1, 0, n - 1, left, i, sum, squares, lazy);

            last.put(nums[i], i);
            ans = (ans + squares[1]) % MOD;
        }

        return (int) ans;
    }

    private void update(int node, int start, int end,
                        int left, int right,
                        long[] sum, long[] squares, long[] lazy) {
        if (start > right || end < left) return;

        if (left <= start && end <= right) {
            apply(node, start, end, sum, squares, lazy, 1);
            return;
        }

        push(node, start, end, sum, squares, lazy);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, left, right,
               sum, squares, lazy);
        update(node * 2 + 1, mid + 1, end, left, right,
               sum, squares, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        squares[node] =
            (squares[node * 2] + squares[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int start, int end,
                       long[] sum, long[] squares, long[] lazy,
                       long add) {
        long len = end - start + 1L;

        squares[node] = (
            squares[node] + 2L * add * sum[node]
            + len * add * add
        ) % MOD;

        sum[node] = (sum[node] + len * add) % MOD;
        lazy[node] = (lazy[node] + add) % MOD;
    }

    private void push(int node, int start, int end,
                      long[] sum, long[] squares, long[] lazy) {
        if (lazy[node] == 0 || start == end) return;

        int mid = start + (end - start) / 2;
        long add = lazy[node];

        apply(node * 2, start, mid, sum, squares, lazy, add);
        apply(node * 2 + 1, mid + 1, end,
              sum, squares, lazy, add);

        lazy[node] = 0;
    }
}

        
    
