public class Searcher {

    // Category C: Linear Search - O(n)
    // Checks each element one by one until target is found
    public int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // return index of found element
            }
        }
        return -1; // not found
    }
}