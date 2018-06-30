import org.pcj.*;
import java.io.IOException;
import java.util.Random;

@RegisterStorage(MonteCarloPCJ.Shared.class)

public class MonteCarloPCJ implements StartPoint {

    @Storage(MonteCarloPCJ.class)

    enum Shared { count };
    long count = 0;

    public static void main(String[] args) throws IOException {
        PCJ.deploy(MonteCarloPCJ.class, new NodesDescription("nodes.txt"));
    }

    @Override
    public void main() throws Throwable {
        int id = PCJ.myId();
        int threads = PCJ.threadCount();
        long nAll = 2000000000;
        long t = System.nanoTime();

        if (id == 0) {
            System.out.println("threads,nAll,PI,time");
        }

        long n = nAll / threads;
        count = 0;

        Random r = new Random();

        for (int i = 0; i < n; i++) {
            double x = 2 * r.nextDouble() - 1.0;
            double y = 2 * r.nextDouble() - 1.0;

            if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                count++;
            }
        }

        PCJ.barrier();

        if (id == 0) {
            long sum = count;

            for (int p = 1; p < threads; p++) {
                sum = sum + (long) PCJ.get(p, MonteCarloPCJ.Shared.count);
            }

            double pi = (4 * sum) / (double) nAll;

            long t2 = System.nanoTime();

            System.out.print(threads);
            System.out.print(',');
            System.out.print(nAll);
            System.out.print(',');
            System.out.print(pi);
            System.out.print(',');
            System.out.print((t2-t) * 1e-9);
        }

    }
}
