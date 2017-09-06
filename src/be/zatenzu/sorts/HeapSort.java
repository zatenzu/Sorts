package be.zatenzu.sorts;

public class HeapSort {

    public static void sort(int[] array){
        // Array size
        int n = array.length;

        // Heapify the tree
        // (n/2)-1 = last non-leaf sub node
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(array, n, i);
        }

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root (current largest element) to end
            swapElements(array, 0, i);
            // heapify the reduced array
            heapify(array, i, 0);
        }
    }

    /**
     * Heapify the tree. All nodes are larger than his two sons
     * @param arr The array
     * @param n Heap size
     * @param i Root index
     */
    private static void heapify(int arr[], int n, int i){
        // Initialize largest as root
        int largestElementIndex = i;
        // Initialize left element
        int l = 2*i + 1;
        // Initialize right element
        int r = 2*i + 2;

        // If left child is larger than root
        if (l < n && arr[l] > arr[largestElementIndex]){
            largestElementIndex = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largestElementIndex]){
            largestElementIndex = r;
        }

        // If largest is not root
        if (largestElementIndex != i)
        {
            // Swap root with largest
            swapElements(arr, i, largestElementIndex);
            // Heapify the affected sub-tree
            heapify(arr, n, largestElementIndex);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    private static void swapElements(int[] array, int a, int b){
        int tmp = array[b];
        array[b] = array[a];
        array[a] = tmp;
    }

    public static void main(String args[])
    {
        int arr[] = {7, 5, 11, 13, 6, 12};
        HeapSort.sort(arr);
        printArray(arr);
    }
}
