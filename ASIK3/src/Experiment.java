public class Experiment {

    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    // Measure sorting time in nanoseconds
    public long measureSortTime(int[] arr, String type) {
        int[] copy = arr.clone(); // don't modify original
        long start = System.nanoTime();
        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else if (type.equals("advanced")) {
            sorter.advancedSort(copy);
        }
        long end = System.nanoTime();
        return end - start;
    }

    // Measure search time in nanoseconds
    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    // Run all experiments across different sizes and input types
    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};
        String[] labels = {"Small (10)", "Medium (100)", "Large (1000)"};

        System.out.println("=== SORTING EXPERIMENTS ===");
        System.out.printf("%-15s %-20s %-20s %-20s%n", "Size", "Input Type", "Bubble Sort (ns)", "Quick Sort (ns)");
        System.out.println("-".repeat(75));

        for (int i = 0; i < sizes.length; i++) {
            // Random array
            int[] random = sorter.generateRandomArray(sizes[i]);
            long bubbleRandom = measureSortTime(random, "basic");
            long quickRandom  = measureSortTime(random, "advanced");
            System.out.printf("%-15s %-20s %-20d %-20d%n", labels[i], "Random", bubbleRandom, quickRandom);

            // Sorted array
            int[] sorted = random.clone();
            sorter.advancedSort(sorted); // pre-sort it
            long bubbleSorted = measureSortTime(sorted, "basic");
            long quickSorted  = measureSortTime(sorted, "advanced");
            System.out.printf("%-15s %-20s %-20d %-20d%n", "", "Sorted", bubbleSorted, quickSorted);
        }

        System.out.println("\n=== SEARCH EXPERIMENTS ===");
        System.out.printf("%-15s %-20s %-20s%n", "Size", "Input Type", "Linear Search (ns)");
        System.out.println("-".repeat(55));

        for (int i = 0; i < sizes.length; i++) {
            int[] random = sorter.generateRandomArray(sizes[i]);
            int target = random[sizes[i] / 2]; // pick a middle element as target

            long searchRandom = measureSearchTime(random, target);
            System.out.printf("%-15s %-20s %-20d%n", labels[i], "Random", searchRandom);

            int[] sorted = random.clone();
            sorter.advancedSort(sorted);
            long searchSorted = measureSearchTime(sorted, target);
            System.out.printf("%-15s %-20s %-20d%n", "", "Sorted", searchSorted);
        }
    }
}