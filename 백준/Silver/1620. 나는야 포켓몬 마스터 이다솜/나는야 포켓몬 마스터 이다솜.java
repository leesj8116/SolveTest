import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // String.split => StringTokenizer로 변경
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 포켓몬의 개수 N
        int M = Integer.parseInt(st.nextToken()); // 문제의 개수 M

//        System.out.printf("N = %d, M = %d\n", N, M);
        String[] library = new String[N];
        Map<String, Integer> libMap = new HashMap<>();

        // 도감 입력
        for(int i = 0; i < N; i++) {
            String data = bf.readLine();
            library[i] = data;
            libMap.put(data, i + 1);
        }

        // 문제 풀이
        for(int i = 0; i < M; i++) {
            String quiz = bf.readLine();    // 문제 입력
            try {
                // 숫자일 경우
                System.out.println(library[Integer.parseInt(quiz) - 1]);
            } catch(NumberFormatException e) {
                // 숫자가 아닐 경우
                System.out.println(libMap.get(quiz));
            }
        }

    }
}