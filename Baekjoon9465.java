import java.io.*;
import java.util.*;

public class Baekjoon9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[2][N];
            int[][] dp = new int[2][N];

            // 첫 번째 줄 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[0][j] = Integer.parseInt(st.nextToken());
            }

            // 두 번째 줄 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[1][j] = Integer.parseInt(st.nextToken());
            }

            if (N == 1) {
                System.out.println(Math.max(score[0][0], score[1][0]));
                continue;
            }

            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];
            dp[0][1] = score[0][1] + dp[1][0];
            dp[1][1] = score[1][1] + dp[0][0];

            for (int i = 2; i < N; i++) {
                dp[0][i] = score[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = score[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            }

            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}
