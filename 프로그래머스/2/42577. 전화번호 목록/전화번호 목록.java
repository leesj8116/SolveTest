import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public boolean solution(String[] phone_book) {        
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        for (String s: phone_book) {
            for (int i = 0; i < s.length(); i++) {
                String sub = s.substring(0, i);
                
                if(set.contains(sub)) {
                    return false;
                }
            }
        }

        return true;
    }
}