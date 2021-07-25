import java.util.Arrays;
import java.util.PriorityQueue;
public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int idx = 0;
        int jobLength = jobs.length;

        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0] );
        PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);

        while(idx < jobLength || !pq.isEmpty()) {
            while (idx < jobLength && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] doneJob = pq.poll();
                answer += time - doneJob[0] + doneJob[1];
                time += doneJob[1];
            }
        }
        return answer / jobLength;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {1,9}, {2,6}};

        DiskController dc = new DiskController();
        System.out.println(dc.solution(jobs));
    }
}
