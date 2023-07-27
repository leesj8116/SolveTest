import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int[] answer = new int[11]; // 1 <= n < 11. answer[0]은 미사용
        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 4;

        for(int i = 0; i < T; i++) {
            bw.write("" + solution(Integer.parseInt(br.readLine()), answer));
            bw.newLine();
        }

        bw.flush();
    }

    /**
     * n개까지의 경우의 수 계산
     * @param n 1 <= n < 11
     */
    private static int solution(int n, int[] answer) {
        // n에 대해 경우의 수가 계산된 적 없는 경우 계산
        if(answer[n] == 0) {
            for(int i = 4; i <= n; i++) {
                answer[i] = answer[i - 1] + answer[i - 2] + answer[i - 3];
            }
        }

        return answer[n];
    }
}