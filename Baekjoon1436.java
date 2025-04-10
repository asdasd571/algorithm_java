import java.util.*;
import java.io.*;

public class Baekjoon1436 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 666;
        int count = 1;

        while(n!=count){
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        System.out.println(num);

    }
}
