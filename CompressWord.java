public class CompressWord {

  public int solution(String s) {
    int answer = 1000;
    for(int i=1; i<=s.length(); i++) {
      String curr_word = "";
      String next_word = "";
      StringBuilder compressedWord = new StringBuilder();
      int same_cnt = 1;
      for(int j=0; j<=s.length()/i; j++) {
        int start = i*j;
        int end = i*(j+1);
        if(end > s.length()){
          end = s.length();
        }
        curr_word = next_word;
        next_word = s.substring(start, end);
        if(curr_word.equals(next_word)) {
          same_cnt++;
        } else {
          if(same_cnt > 1) {
            compressedWord.append(String.valueOf(same_cnt));
          }
          compressedWord.append(curr_word);
          same_cnt = 1;
        }
      }
      if(same_cnt > 1) {
        compressedWord.append(String.valueOf(same_cnt));
      }
      compressedWord.append(next_word);
      System.out.println("i:" + i);
      System.out.println("next_word:" + next_word);
      System.out.println("cw:" + compressedWord);
      answer = Math.min(answer, compressedWord.length());
      System.out.println("answer:" + answer);
    }
    System.out.println("answer:" + answer);
    return answer;
  }

  public static void main(String[] args) {
    CompressWord w = new CompressWord();
    w.solution("a");
  }
}
