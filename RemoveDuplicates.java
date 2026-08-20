import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class RemoveDuplicates {

    static int[] removeDuplicatesUsingSet(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) set.add(num);

        int[] result = new int[set.size()];
        int i = 0;
        for (int val : set) result[i++] = val;
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 4, 5, 2, 7};
        System.out.println("Using Set: " + Arrays.toString(removeDuplicatesUsingSet(arr1)));
    }
}