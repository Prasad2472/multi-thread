/**
 * 
 */
package in.core.multithreads;

import java.util.ArrayList;
import java.util.List;

import in.core.multithreads.util.PrimeUtil;

/**
 * @author Prasad Boini
 *
 */
public class TestWithoutMultiThread {
	public static void main(final String[] args) {
		final List<Integer> primes = new ArrayList<>();
		final Long strt = System.currentTimeMillis();
		primes.add(2);
		System.out.println("Strt: " + strt);
		for (int i = 1; i < 1000000; i = i + 2) {
			if (PrimeUtil.isPrimeNumber(i)) {
				primes.add(i);
			}
		}
		final Long end = System.currentTimeMillis();
		System.out.println("End: " + end);

		System.out.println("Diff: " + (end - strt));
		System.out.println("Total prime Numbers:" + primes.size());
		/**
		 * Strt: 1516185787248 End: 1516185840263 Diff: 53015 Total prime Numbers:78498
		 */
	}
}
