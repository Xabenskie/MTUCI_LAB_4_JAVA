public class ArrayAverage {
	public static void main(String[] args) {
			Object[] arr = {1, 2, 3, 4, 5, "q"};
			double sum = 0;
			int count = 0;

			try {
					for (int i = 0; i < arr.length; i++) {
							if (arr[i] == null) {
									throw new NullPointerException("Array element on the index " + i + " equal to null.");
							}
							if (arr[i] instanceof Number) {
									sum += ((Number) arr[i]).doubleValue();
									count++;
							} else {
									throw new IllegalArgumentException("Array element at index " + i + " is not a number: " + arr[i]);
							}
					}

					if (count == 0) {
							throw new ArithmeticException("There are no numerical elements for calculating the arithmetic mean.");
					}
					double average = sum / count;
					System.out.println("Arithmetic mean: " + average);

			} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Error: Overstepping the bounds of the array.");
					ErrorLogger.logException(e);
			} catch (NullPointerException e) {
					System.out.println("Error: " + e.getMessage());
					ErrorLogger.logException(e);
			} catch (IllegalArgumentException e) {
					System.out.println("Error: " + e.getMessage());
					ErrorLogger.logException(e);
			} catch (ArithmeticException e) {
					System.out.println("Error: " + e.getMessage());
					ErrorLogger.logException(e);
			} catch (Exception e) {
					System.out.println("Unknown error: " + e.getMessage());
					ErrorLogger.logException(e);
			}
	}
}
