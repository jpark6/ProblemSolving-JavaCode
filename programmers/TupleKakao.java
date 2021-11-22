package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TupleKakao {
    public int[] solution(String s) {

        s = s.substring(2)
             .substring(0,s.length()-4)
             .replace("},{","-");

        String[] arr = s.split("-");

        Arrays.sort(arr,(x, y) -> {return x.length() - y.length(); });

        List tupleList = new ArrayList<Integer>();

        for(String a: arr) {
            for(String str: a.split(",")) {
                int i = Integer.valueOf(str);
                if(!tupleList.contains(i)) {
                    tupleList.add(i);
                }
            }
        }
        int[] answer = new int[tupleList.size()];
        for(int i=0; i< tupleList.size(); i++) {
            answer[i] = (int)tupleList.get(i);
        }
        System.out.println(tupleList);
        return answer;
    }

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        TupleKakao ptk = new TupleKakao();
        ptk.solution(s);
        ptk.solution("{{20,111},{111}}");
    }
}
