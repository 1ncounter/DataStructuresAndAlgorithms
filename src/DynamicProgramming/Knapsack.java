package DynamicProgramming;

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {2, 5, 7};
        int n = 5;
        int w = 27;

        System.out.println(coinChange(weight, w));
    }

    public static int f(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1];

        states[0] = true;
        states[weight[0]] = true;

        for (int i = 1; i < n; ++i) {
            for (int j = w - weight[i]; j >= 0; --j) {
                if (states[j] && !states[j + weight[i]]) {
                    states[j + weight[i]] = true;
                }
            }
        }

        for (int i = w; i >= 0; --i) {
            if (states[i]) return i;
        }

        return 0;
    }

    public static int coinChange(int[] A, int M) {
        int[] f = new int[M + 1];
        int n = A.length;

        // 初始化
        f[0] = 0;

        for (int i = 1; i <= M; i++) {
            f[i] = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE) {
                    // 状态转移方程
                    f[i] = Math.min(f[i - A[j]] + 1, f[i]);
                }
            }
        }

        if (f[M] == Integer.MAX_VALUE) {
            f[M] = -1;
        }

        return f[M];
    }

    public static int uniquePaths(int m, int n) {
        int[][] states = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 1 || j == 1) {
                    states[i][j] = 1;
                } else {
                    states[i][j] = states[i - 1][j] + states[i][j - 1];
                }
            }
        }

        return states[m - 1][n - 1];
    }

    public static boolean jumpGame(int[] A) {
        int n = A.length;
        boolean[] f = new boolean[n];

        f[0] = true;

        for(int j = 0; j < n; j++) {
            f[j] = false;

            // previous stone i
            // last jump is from i to j
            for (int i = 0; i < j; i++) {
                if (f[i] && i + A[i] > j) {
                    f[j] = true;
                    break;
                }
            }
        }

        return f[n - 1];
    }
}
