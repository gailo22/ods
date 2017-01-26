package hello;

public class BinarySearch {
	
	public static <T extends Comparable<? super T>>
			int binarySearch(T[] data, T target) {
		return binarySearch(data, target, 0, data.length - 1);
	}

	private static <T extends Comparable<? super T>>
			int binarySearch(T[] data, T target, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high) / 2;
		int result = target.compareTo(data[mid]);
		if (result == 0) {
			return mid;
		} else if (result > 0) {
			return binarySearch(data, target, low, mid - 1);
		} else {
			return binarySearch(data, target, mid + 1, high);
		}
	}

}
