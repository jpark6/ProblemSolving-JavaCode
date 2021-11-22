package programmers;

public class ChuseokTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        int count = lines.length;
        double[] durations = new double[count];
        double[] endTimes = new double[count];
        double[] startTimes = new double[count];

        for(int i=0; i<count; i++) {
            String[] lineItems = lines[i].split(" ");

            durations[i] = Double.parseDouble(lineItems[2].replace("s",""));

            String[] times = lineItems[1].split("[:|.]");
            endTimes[i] = Double.parseDouble(times[0]) * 3600
                         + Double.parseDouble(times[1]) * 60
                         + Double.parseDouble(times[2])
                         + Double.parseDouble(times[3]) / 1000;
            startTimes[i] = endTimes[i] - durations[i] + .001;
        }

        for(int i=0; i<count; i++) {
            int sameTimeCount = 0;
            for(int j=0; j<count; j++) {
                if(i==j || (endTimes[i] + 1 > startTimes[j] && endTimes[i] <= endTimes[j])) {
                    sameTimeCount++;
                }
            }
            if(sameTimeCount > answer) {
                System.out.println("et2:" + i + ", " + endTimes[i]);
                System.out.println("cnt:" + sameTimeCount);
                answer = sameTimeCount;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ChuseokTraffic ct = new ChuseokTraffic();
        String[] lines1 = {
            "2016-09-15 01:00:04.001 2.0s",
            "2016-09-15 01:00:07.000 2s"
        };
        String[] lines2 = {
            "2016-09-15 01:00:04.002 2.0s",
            "2016-09-15 01:00:07.000 2s"
        };
        String[] lines3 = {
            "2016-09-15 20:59:57.421 0.351s",
            "2016-09-15 20:59:58.233 1.181s",
            "2016-09-15 20:59:58.299 0.8s",
            "2016-09-15 20:59:58.688 1.041s",
            "2016-09-15 20:59:59.591 1.412s",
            "2016-09-15 21:00:00.464 1.466s",
            "2016-09-15 21:00:00.741 1.581s",
            "2016-09-15 21:00:00.748 2.31s",
            "2016-09-15 21:00:00.966 0.381s",
            "2016-09-15 21:00:02.066 2.62s"
        };
        System.out.println(ct.solution(lines1));
        System.out.println(ct.solution(lines2));
        System.out.println(ct.solution(lines3));
    }
}
