import java.util.Arrays;

public class ThreeSumFast extends ThreeSum {

    public static int count(int[] a) {
        Arrays.sort(a);
        int n     = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (BinarySearch.indexOf(a, -a[i] - a[j]) > j) count++;
        return count;
    }
}
