import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String s) {
        List<String> answer;
        answer = new ArrayList<>();

        int sLen = s.length();
        for(int i = 0; i < sLen / 2; i++) {
            for(int j = 1; j <= sLen / 2-i; j++) {
                System.out.println("i: " + i);
                System.out.println("j: " + j);
                String s_str = s.substring(i,i+j);
                String e_str = s.substring(sLen - i - j, sLen - i);
                System.out.println("s_str: " + s_str);
                System.out.println("e_str: " + e_str);
                System.out.println("-----------------");
                if(s_str.equals(e_str)){
                    System.out.println(s_str);
                    answer.add(s_str);
                    i += (j - 1);
                    break;
                }
            }
        }
        return answer.toArray(new String[answer.size()]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("zzzzzz").toString());
    }
}