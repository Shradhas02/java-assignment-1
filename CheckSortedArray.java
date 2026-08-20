public class CheckSortedArray {

    static String checkSortOrder(int[] arr) {
        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) isAscending = false;
            if (arr[i] < arr[i + 1]) isDescending = false;
        }

        if (isAscending) return "Array is sorted in Ascending order";
        else if (isDescending) return "Array is sorted in Descending order";
        else return "Array is NOT sorted";
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {9, 7, 5, 2};
        int[] arr3 = {3, 1, 4, 2};

        System.out.println(checkSortOrder(arr1));
        System.out.println(checkSortOrder(arr2));
        System.out.println(checkSortOrder(arr3));
    }
}