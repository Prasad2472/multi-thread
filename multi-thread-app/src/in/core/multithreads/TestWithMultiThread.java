/**
 * 
 */
package in.core.multithreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Prasad Boini
 *
 */
public class TestWithMultiThread {
	private static Integer N_THREADS = 10;

	public static void main(final String[] args) {
		/**
		 * Create ExecutorServce, it will create threads.
		 */
		final ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
		List<Future<List<Integer>>> futures = new ArrayList<>();
		/**
		 * Track time
		 */
		final Long strt = System.currentTimeMillis();
		System.out.println("Strt: " + strt);

		List<PrimeCallable> callables = new ArrayList<>();

		for (int i = 0; i < 1000000; i = i + 1000) {
			/**
			 * For Every 1000 numbers create new task
			 */
			callables.add(new PrimeCallable(i, i + 1000));
		}
		try {
			/**
			 * Execute all the tasks
			 */
			futures = executorService.invokeAll(callables);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		final List<Integer> primes = new ArrayList<>();
		/**
		 * Collect Data from Future Object.
		 */
		for (final Future<List<Integer>> future2 : futures) {
			try {
				primes.addAll(future2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		final Long end = System.currentTimeMillis();
		System.out.println("End: " + end);

		System.out.println("Diff: " + (end - strt));
		System.out.println("Total prime Numbers:" + primes.size());
		// System.out.println(primes);
		/**
		 * Its mandatory that shutdown the ExecutorService, otherwise threads will keep
		 * alive.
		 */
		executorService.shutdown();
		/**
		 * Test Result with MultiThread: Time Taken: Strt: 1516185696102 End:
		 * 1516185710760 Diff: 14658 Total prime Numbers:78498
		 * 
		 */
	}
}
