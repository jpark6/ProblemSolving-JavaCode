public class GoToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] routeCntArr = new int[n+1][m+1];

        for(int[] puddle: puddles) {
            routeCntArr[puddle[1]][puddle[0]] = -1;
        }

        for(int i=1; i<routeCntArr.length; i++) {
            for(int j=1; j<routeCntArr[i].length; j++) {
                if(i == 1 || j == 1) {
                    routeCntArr[i][j] = 1;
                } else if(routeCntArr[i][j] == -1) {
                    routeCntArr[i][j] = 0;
                } else {
                    routeCntArr[i][j] = routeCntArr[i-1][j] + routeCntArr[i][j-1];
                }
                System.out.println(i+", "+j+" : "+routeCntArr[i][j]);
            }
        }
        return routeCntArr[n][m];
    }

    public static void main(String[] args) {
        GoToSchool gts = new GoToSchool();
        int[][] puddles = new int[1][2];
        puddles[0] = new int[]{2, 2};
        System.out.println(gts.solution(4,3,puddles));
    }
}
