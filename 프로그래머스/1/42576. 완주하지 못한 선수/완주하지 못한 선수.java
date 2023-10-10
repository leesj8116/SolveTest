import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> m = new HashMap<>();
        for (String s : completion) {
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        for(String s : participant) {
            int v = m.getOrDefault(s, 0);
            if (v == 0) {
                return s;
            } else {
                m.put(s, m.get(s) - 1);
            }
        }

        return null;
    }
}