public class CompressWord2 {

  public int solution(String s) {
    int answer = 1000;
    for(int i=1; i<s.length() ; i++){
      String now = ""; String comp = "";
      String temp = "";
      int cnt = 1;

      // j 기준 단위 0부터 length/i 단위까지
      // 나누어 떨어지지않을때 끝까지 계산해주려면 <=
      for(int j= 0; j<=s.length()/i;j++){
        int from = i*j; int to = i*(j+1);
        // 값 넘을 시 보정
        if(to > s.length()) to = s.length();

        // 기준점 변경
        now = comp;
        comp = s.substring(from, to);

        // 비교
        if(now.equals(comp)) cnt++;
        else{
          if(cnt>1) temp += String.valueOf(cnt);
          temp += now;
          cnt = 1; // 개수 초기화
        }
      }
      // 남은값 처리
      if(cnt>1) temp += String.valueOf(cnt);
      temp += comp;
      // 갱신
      answer = Math.min(temp.length(), answer);
    }
    System.out.println("answer:" + answer);
    return answer;
  }

  public static void main(String[] args) {
    CompressWord2 w = new CompressWord2();
    w.solution("ababcc");
  }
}
