public class programmers_타겟넘버_1231 {

	static int count = 0;
	static int[] numberArray;
	static int targetNumber = 0;

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		solution(numbers, 3);
	}

	public static int solution(int[] numbers, int target) {
		numberArray = new int[numbers.length];
		System.arraycopy(numbers, 0, numberArray, 0, numbers.length);
		targetNumber = target;

		for (int i = 0; i < numbers.length; i++) {
			combination(new int[numbers.length], numbers.length, i, 0, 0);
		}
		return count;
	}

	public static void combination(int[] combArr, int n, int r, int index, int target) {
		if (r == 0) {
			int sum = 0, idx = 0;
			boolean isIndexNotZero = (index == 0) ? false : true;
			for (int i = 0; i < numberArray.length; i++) {
				if (isIndexNotZero && i == combArr[idx]) {
					sum -= numberArray[i];
					idx++;
					continue;
				} 
				sum += numberArray[i];
			}
			if (sum == targetNumber) {
				count++;
			}
		} else if (target == n) {
			return;
		} else {
			combArr[index] = target;
			combination(combArr, n, r - 1, index + 1, target + 1);
			combination(combArr, n, r, index, target + 1);
		}
	}
}
