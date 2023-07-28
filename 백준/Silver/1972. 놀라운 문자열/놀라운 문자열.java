import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1차 개선 : StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        String s = "*";
        while(!(s = br.readLine()).equals("*")) {
            sb.append(s).append(" is").append(solution(s) ? "" : " NOT").append(" surprising.\n");
        }

        System.out.println(sb);
    }

    /**
     * 놀라운 문자열 검사
     * @param s
     * @return true = 놀라운 문자열
     */
    private static boolean solution(String s) {
        Set<String> pocket = new HashSet<>();

        int max = s.length() - 2;   // N 부터 N-2 쌍까지 존재
        for(int D = 0; D <= max; D++) {
            pocket.clear(); // 비우고 시작

            for(int k = 0; k < (s.length() - D - 1); k++) {
                String item = String.valueOf(s.charAt(k)) + s.charAt(k + D + 1);  // 문자열 생성
                if(pocket.contains(item)) {
                    return false;       // 원소가 이미 존재하면 NOT 놀라운 문자열
                }

                pocket.add(item);   // 원소가 존재하지 않으면 주머니에 추가
            }
        }

        return true;    // 모든 검사를 통과하면 놀라운 문자열
    }
}