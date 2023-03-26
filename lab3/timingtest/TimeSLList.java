package timingtest;
import edu.princeton.cs.algs4.In;
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
        /** Instantiate the three required AList. */
        AList ns = new AList<Integer>();
        AList times = new AList<Double>();
        AList op = new AList<Integer>();

        /** SLList for test. */
        SLList test = new SLList<Integer>();

        /** Finish n and op AList. */
        int opNum = 10000;
        for (int listLen = 1000; listLen <= 128000; listLen *= 2) {
            ns.addLast(listLen);
            op.addLast(opNum);

            /** Construct a SSList with listLen length. */
            for (int i = 0; i < listLen; i += 1) {
                test.addLast(1);
            }

            /** Record the time when call of getLast finished. */
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < opNum; i += 1) {
                test.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }

        /** Generate timing table. */
        printTimingTable(ns, times, op);
    }
}
