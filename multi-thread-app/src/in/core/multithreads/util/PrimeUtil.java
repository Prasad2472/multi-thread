/**
 * 
 */
package in.core.multithreads.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Prasad Boini
 *
 */
public class PrimeUtil {

	/**
	 * This method return true if the given number is prime, otherwise return false.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPrimeNumber(final Integer number) {
		if (number == 2 || number == 3) {
			return true;
		}
		// If the Even number
		if (number % 2 == 0 || number == 1) {
			return false;
		}
		boolean isPrime = true;
		for (int i = 3; i < number; i = i + 2) {
			// System.out.println("isPrimeNumber--i =" + i);
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static Integer getStartIndex(Integer start) {
		return start % 2 == 0 ? start + 1 : start;
	}

	public static Integer getEndIndex(Integer end) {
		return end % 2 == 0 ? end - 1 : end;
	}

	public static void main(String[] args) {
		List<Integer> primes = new ArrayList<>();
		Long strt = System.currentTimeMillis();
		primes.add(2);
		System.out.println("Strt: " + strt);
		for (int i = 1; i < 1000000; i = i + 2) {
			if (isPrimeNumber(i)) {
				primes.add(i);
			}
		}
		Long end = System.currentTimeMillis();
		System.out.println("End: " + end);

		System.out.println("Diff: " + (end - strt));
		System.out.println("Total prime Numbers:" + primes.size());
		/**
		 * Strt: 1516185787248 End: 1516185840263 Diff: 53015 Total prime Numbers:78498
		 */
	}
}
