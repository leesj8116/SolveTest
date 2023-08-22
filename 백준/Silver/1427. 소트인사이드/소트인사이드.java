import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 개선 : Collector 쓰지 말고 그냥 Array에 이진 정렬 적용
        char[] arr = br.readLine().toCharArray();   // 1 <= N <= 1_000_000_000
        int[] answer = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            answer[i] = arr[i] - '0';
        }

        int temp = 0;
        for (int k = 0; k < arr.length - 1; k++) {
            for (int m = k + 1; m < arr.length; m++) {
                if (answer[k] < answer[m]) {
                    temp = answer[k];
                    answer[k] = answer[m];
                    answer[m] = temp;
                }
            }
        }
        for(int i : answer) {
            bw.write(('0' + i));
        }
        bw.newLine();

        bw.flush();
    }
}