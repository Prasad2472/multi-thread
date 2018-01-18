/**
 * 
 */
package in.core.multithreads.util;

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

	public static Integer getStartIndex(final Integer start) {
		return start % 2 == 0 ? start + 1 : start;
	}

	public static Integer getEndIndex(final Integer end) {
		return end % 2 == 0 ? end - 1 : end;
	}
}
