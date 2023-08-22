import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();       // 1 <= N <= 1_000_000_000
        List<Character> collect = N.chars().mapToObj(c -> (char) c).sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());

        for(Character c : collect) {
            bw.write(c);
        }
        bw.newLine();

        bw.flush();
    }
}