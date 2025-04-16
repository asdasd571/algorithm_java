import java.util.*;
import java.io.*;

public class Baekjoon11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2, N) - 1);
        hanoiTower(N, 1, 2, 3);
        System.out.print(sb);
    }

    // 하노이 탑 이동 과정 출력 함수
    static void hanoiTower(int n, int from, int temp, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoiTower(n - 1, from, to, temp); // 1단계: n-1개를 보조 기둥으로 이동
        sb.append(from).append(" ").append(to).append("\n"); // 2단계: 가장 큰 원반을 목표 기둥으로 이동
        hanoiTower(n - 1, temp, from, to); // 3단계: n-1개를 목표 기둥으로 이동
    }
}
