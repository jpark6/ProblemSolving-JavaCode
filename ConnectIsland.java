import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectIsland {
    public static Logger logger = Logger.getLogger("ConnectIsland");
    int[] parent;

    public int findParent(int node) {
        if(parent[node] == node) {
            return node;
        } else {
            return findParent(parent[node]);
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // costs 배열 오름차순정렬
        Arrays.sort(costs, ((int[] c1, int[] c2) -> c1[2] - c2[2]));

        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int[] cost: costs) {
            int p1 = findParent(cost[0]);
            int p2 = findParent(cost[1]);

            System.out.println("cost: " + cost[0] + ", " + cost[1] + ", " + cost[2]);
            System.out.print("root1: "+ p1 + " ");
            System.out.println("root2: "+ p2);
            if(p1 != p2) {
                parent[p2] = p1;
                answer += cost[2];
            }
        }

        for(int p: parent) {
            System.out.println(p);
        }
        return answer;
    }

    

    public static void main(String[] args) {
        ConnectIsland ci = new ConnectIsland();

        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int answer = ci.solution(4,costs);
        ConnectIsland.logger.log(Level.INFO, "answer: {0}", answer);
    }
}
