import java.util.*;
import java.io.*;

public class Baekjoon14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n + 2]; // 상담 기간
        int[] P = new int[n + 2]; // 상담 금액
        int[] dp = new int[n + 2]; // i번째 날까지의 최대 이익

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n + 1; i++) {
            // 이전까지의 최대 이익을 현재에도 반영
            dp[i] = Math.max(dp[i], dp[i - 1]);
            // 상담을 할 수 있는 경우
            if (i + T[i] - 1 <= n) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        System.out.println(dp[n + 1]);
    }
}
