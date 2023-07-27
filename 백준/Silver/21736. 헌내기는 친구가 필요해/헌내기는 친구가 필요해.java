import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static char[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 1 <= N <= 600
        int M = Integer.parseInt(st.nextToken());   // 1 <= M <= 600

        int y = 0;
        int x = 0;

        // 캠퍼스 입력
        field = new char[N][];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            field[i] = s.toCharArray();

            if(s.indexOf('I') != -1) {
                y = i;
                x = s.indexOf('I');
            }
        }

        int answer = solution(y, x);
        bw.write(answer == 0 ? "TT" : ("" + answer));
        bw.newLine();

        bw.flush();
    }

    public static int solution(int y, int x) {
        int answer = 0;

        if(field[y][x] == 'P') {
            answer++;
        }

        field[y][x] = 'X';  // 방문한 구역으로 처리

        if((y != 0) && (field[y - 1][x] != 'X')) {
            answer += solution(y -1, x);
        }
        if((x != 0) && (field[y][x - 1] != 'X')) {
            answer += solution(y, x - 1);
        }
        if(((y + 1) < field.length) && (field[y + 1][x] != 'X')) {
            answer += solution(y + 1, x);
        }
        if(((x + 1) < field[0].length) && (field[y][x + 1] != 'X')) {
            answer += solution(y, x + 1);
        }

        return answer;
    }
}