public class Main {

    public static void main(String[] args) {

        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment();

        // --- Demo: Small array ---
        System.out.println("=== DEMO: Small Array (10 elements) ===");
        int[] small = sorter.generateRandomArray(10);

        System.out.print("Original: ");
        sorter.printArray(small);

        int[] bubbleArr = small.clone();
        sorter.basicSort(bubbleArr);
        System.out.print("After Bubble Sort: ");
        sorter.printArray(bubbleArr);

        int[] quickArr = small.clone();
        sorter.advancedSort(quickArr);
        System.out.print("After Quick Sort:  ");
        sorter.printArray(quickArr);

        int target = small[0];
        int index = searcher.search(small, target);
        System.out.println("Linear Search for " + target + " -> index: " + index);

        System.out.println();

        // --- Run full experiments ---
        experiment.runAllExperiments();
    }
}