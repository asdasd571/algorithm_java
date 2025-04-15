import java.io.*;
import java.util.*;

public class Baekjoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

// 첫 번째 집은 처음 그대로
        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }

// DP 점화식 적용
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));


    }
}
