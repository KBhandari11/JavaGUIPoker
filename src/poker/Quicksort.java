package poker;

import java.util.Arrays;


public class Quicksort {

	
    public <T extends Comparable<T>> T[] quickSort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * Helper method for swapping places in array
     * @param array The array which elements we want to swap
     * @param idx index of the first element
     * @param idy index of the second element
     */
    static <T> boolean swap(T[] array, int idx, int idy){
        T swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }


    /**
     * This method checks if first element is less then the other element
     * @param v first element
     * @param w second element
     * @return true if the first element is less then the second element
     */
    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    /**
     * The sorting process
     *
     * @param left The first index of an array
     * @param right The last index of an array
     * @param array The array to be sorted
     *
     **/

    private static <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot , right);
        }
    }

    /**
     * This method finds the partition index for an array
     *
     * @param array The array to be sorted
     * @param left The first index of an array
     * @param right The last index of an array
     * Finds the partition index of an array
     **/

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) / 2;
        T pivot = array[mid];

        while(left <= right) {
            while(less(array[left], pivot)){
                ++left;
            }
            while(less(pivot, array[right])) {
                --right;
            }
            if(left <= right) {
                swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    // Driver Program
    public static void main(String[] args) {

        // For integer input
        Integer[] array =  {3, 4, 1, 32, 0, 1, 5, 12 ,2, 5 ,7 ,8 ,9, 2, 44, 111, 5};

        Quicksort quickSort = new Quicksort();
        System.out.println("Before sorting the array elements : " +Arrays.toString(array));
        quickSort.quickSort(array);
        System.out.println("After sorting the array elements : " + Arrays.toString(array));

        
        String[] stringArray =  {"c", "a", "e", "b", "d"};
        System.out.println("Before sorting the array elements : " +Arrays.toString(stringArray));
        quickSort.quickSort(stringArray);
        System.out.println("After sorting the array elements : " + Arrays.toString(stringArray));
    }
}
