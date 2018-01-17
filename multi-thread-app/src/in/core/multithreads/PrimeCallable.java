/**
 * 
 */
package in.core.multithreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import in.core.multithreads.util.PrimeUtil;

/**
 * @author Prasad Boini
 *
 */
public class PrimeCallable implements Callable<List<Integer>> {

	private final Integer start;
	private final Integer end;

	public PrimeCallable(final Integer start, final Integer end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public List<Integer> call() throws Exception {
//		System.out.println("start:" + start + " end:" + end);
		final List<Integer> primesNumbers = new ArrayList<>();
		final int strt = start % 2 == 0 ? start + 1 : start;
		final int ends = end % 2 == 0 ? end - 1 : end;
		if (start <= 2) {
			primesNumbers.add(2);
		}
		for (int i = strt; i <= ends; i = i + 2) {
			if (PrimeUtil.isPrimeNumber(i)) {
				primesNumbers.add(i);
			}
		}
		return primesNumbers;
	}
}
