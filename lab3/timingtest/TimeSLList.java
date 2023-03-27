package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        // Instantiate the three required AList.
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        // SLList for test.
        SLList<Integer> test = new SLList<>();

        // Finish n and op AList.
        for (int listLen = 1000; listLen <= 128000; listLen *= 2) {
            Ns.addLast(listLen);

            // Construct a SLList with listLen length.
            for (int i = 0; i < listLen; i += 1) {
                test.addLast(1);
            }

            // Record the time when call of getLast finished.
            int opNum = 10000;
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < opNum; i += 1) {
                test.getLast();
            }
            times.addLast(sw.elapsedTime());
            opCounts.addLast(opNum);
        }

        // Generate timing table.
        printTimingTable(Ns, times, opCounts);
    }
}
