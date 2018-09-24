import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//Marco Austria 

public class SortingAnalysis {

	public static void main(String[] args) throws IOException {

		System.out.println("Time is in Milliseconds\n");

		System.out.println("Selection Sort Ascending 5k: " + selectionSort(new File("asc5k.txt")));
		System.out.println("Insertion Sort Ascending 5k: " + insertionSort(new File("asc5k.txt")));
		System.out.println("Selection Sort Ascending 10k: " + selectionSort(new File("asc10k.txt")));
		System.out.println("Insertion Sort Ascending 10k: " + insertionSort(new File("asc10k.txt")));
		System.out.println("Selection Sort Ascending 20k: " + selectionSort(new File("asc20k.txt")));
		System.out.println("Insertion Sort Ascending 20k: " + insertionSort(new File("asc20k.txt")));
		System.out.println("Selection Sort Ascending 50k: " + selectionSort(new File("asc50k.txt")));
		System.out.println("Insertion Sort Ascending 50k: " + insertionSort(new File("asc50k.txt")));

		System.out.println("Selection Sort Descending 5k: " + selectionSort(new File("desc5k.txt")));
		System.out.println("Insertion Sort Descending 5k: " + insertionSort(new File("desc5k.txt")));
		System.out.println("Selection Sort Descending 10k: " + selectionSort(new File("desc10k.txt")));
		System.out.println("Insertion Sort Descending 10k: " + insertionSort(new File("desc10k.txt")));
		System.out.println("Selection Sort Descending 20k: " + selectionSort(new File("desc20k.txt")));
		System.out.println("Insertion Sort Descending 20k: " + insertionSort(new File("desc20k.txt")));
		System.out.println("Selection Sort Descending 50k: " + selectionSort(new File("desc50k.txt")));
		System.out.println("Insertion Sort Descending 50k: " + insertionSort(new File("desc50k.txt")));

		System.out.println("Selection Sort Random 5k: " + selectionSort(new File("rand5k.txt")));
		System.out.println("Insertion Sort Random 5k: " + insertionSort(new File("rand5k.txt")));
		System.out.println("Selection Sort Random 10k: " + selectionSort(new File("rand10k.txt")));
		System.out.println("Insertion Sort Random 10k: " + insertionSort(new File("rand10k.txt")));
		System.out.println("Selection Sort Random 20k: " + selectionSort(new File("rand20k.txt")));
		System.out.println("Insertion Sort Random 20k: " + insertionSort(new File("rand20k.txt")));
		System.out.println("Selection Sort Random 50k: " + selectionSort(new File("rand50k.txt")));
		System.out.println("Insertion Sort Random 50k: " + insertionSort(new File("rand50k.txt")));

	}

	public static double selectionSort(File file) throws IOException {

		ArrayList<Integer> list = new ArrayList<Integer>();

		//read file
		BufferedReader br = new BufferedReader(new FileReader(file));

		try {

			String line = "";
			while ((line = br.readLine()) != null)
				list.add(Integer.parseInt(line));

		} finally {
			br.close();
		}

		int indexSmallest;
		int temp;
		long start;
		long end;
		
		int listSize=list.size();

		// start stopwatch
		start = System.nanoTime();

		//selection sort algorithm
		for (int i = 0; i < listSize; ++i) {

			// Find index of smallest remaining element
			indexSmallest = i;
			for (int j = i + 1; j < listSize; ++j) {

				if (list.get(j) < list.get(indexSmallest)) {
					indexSmallest = j;
				}
			}

			// Swap list[i] and list[indexSmallest]
			temp = list.get(i);
			list.set(i, list.get(indexSmallest));
			list.set(indexSmallest, temp);
		} // for

		end = System.nanoTime();

		double timeTotal = TimeUnit.NANOSECONDS.toMillis(end - start);

		return timeTotal;
	}// selection sort

	public static double insertionSort(File file) throws NumberFormatException, IOException {

		ArrayList<Integer> list = new ArrayList<Integer>();

		//read file
		BufferedReader br = new BufferedReader(new FileReader(file));

		try {
			String line = "";
			while ((line = br.readLine()) != null)
				list.add(Integer.parseInt(line));

		} finally {
			br.close();
		}

		int temp;
		long start;
		long end;
		
		int listSize=list.size();

		int j;
		
		// start stopwatch
		start = System.nanoTime();

		//insertion sort algorithm
		for (int i = 1; i < listSize; ++i) {
			j = i;
			// Insert numbers[i] into sorted part
			// stopping once numbers[i] in correct position
			while (j > 0 && list.get(j) < list.get(j - 1)) {

				// Swap numbers[j] and numbers[j - 1]
				temp = list.get(j);
				list.set(j, list.get(j - 1));
				list.set(j - 1, temp);
				--j;
			} // while
		} // for

		end = System.nanoTime();

		double timeTotal = TimeUnit.NANOSECONDS.toMillis(end - start);

		return timeTotal;
	}// insertion sort

}// class
