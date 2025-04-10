import java.util.Scanner;
public class baekjoon2775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arr = new int[15][15];
        for (int i=1; i<15; i++){
            arr[i][1] = 1; //i층 1호
            arr[0][i] = i; //0층 i호 -> i값
        }

        for(int j=1; j<15; j++){
            for(int k=2; k<15; k++){
                arr[j][k] += arr[j][k-1] + arr[j-1][k];
            }
        }

        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            int N = sc.nextInt();

            System.out.println(arr[K][N]);
        }
    }

}