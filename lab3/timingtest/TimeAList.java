package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        /** Instantiate the four required ALists. */
        AList<Integer> ns = new AList();
        AList<Double> times = new AList();
        AList<Integer> op = new AList();

        AList<Integer> test = new AList();

        /** Finish n and op AList. */
        for (int listLen = 1000; listLen <= 128000; listLen *= 2) {
            ns.addLast(listLen);
            op.addLast(listLen);

            /** Record the time when call of addLast finished. */
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < listLen; i++) {
                test.addLast(1);
            }
            times.addLast(sw.elapsedTime());
        }

        /** Generate timing table. */
        printTimingTable(ns, times, op);
    }
}
