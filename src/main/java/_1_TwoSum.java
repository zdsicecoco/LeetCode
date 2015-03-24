import java.util.HashMap;

/**
 * Created by wyzhangdongsheng1 on 15-3-19.
 */
public class _1_TwoSum {
    /**
     * O(n^2)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        boolean ok = false;
        int i = 0, j = 0;
        for (i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            for (j = i + 1; j < numbers.length; j++) {
                if (num == numbers[j]) {
                    ok = true;
                    break;
                }
            }
            if (ok) break;
        }
        int[] result = {i + 1, j + 1};
        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {
        quickSort(numbers, 0, numbers.length - 1);
        int i = 0, j = 0;
        for (i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            j = binarySearch(numbers, num, i + 1, numbers.length - 1);
            if (j != -1) break;
        }
        int[] result = {i + 1, j + 1};
        return result;
    }

    public int[] twoSum3(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = 0; i < numbers.length; i++){
            if(hashMap.containsKey(numbers[i])){
                result[0] = hashMap.get(numbers[i]) + 1;
                result[1] = i + 1;
                break;
            }
            else hashMap.put(target - numbers[i], i);
        }
        return result;
    }

    /**
     * 二分查找
     *
     * @param numbers
     * @param target
     * @param low
     * @param high
     * @return
     */
    public int binarySearch(int[] numbers, int target, int low, int high) {
        while (low <= high) {
            int mid = (high + low) / 2;
            if (target > numbers[mid]) low = mid + 1;
            else if (target < numbers[mid]) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    /**
     * 快速排序
     *
     * @param numbers
     * @param low
     * @param high
     */
    public void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int par = partition(numbers, low, high);
            quickSort(numbers, low, par - 1);
            quickSort(numbers, par + 1, high);
        }
    }

    public int partition(int[] numbers, int low, int high) {
        int key = numbers[low];
        int p = low, q = high;
        while (p < q) {
            while (q > p && key <= numbers[q]) q--;
            if (q > p) numbers[p++] = numbers[q];
            while (q > p && key >= numbers[p]) p++;
            if (q > p) numbers[q--] = numbers[p];
        }
        numbers[p] = key;
//        for(int i = 0; i < numbers.length; i++)
//            System.out.print(numbers[i] + "\t");
//        System.out.println();
//        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {
        _1_TwoSum obj = new _1_TwoSum();
        int[] numbers = {3,2,4};
        int[] res = obj.twoSum3(numbers, 6);
        for(int i = 0; i < 2; i++)
            System.out.println(res[i] + "\t");
//
//        System.out.println(new TwoSum_1().binarySearch(numbers, 0, 1, 3));

//        obj.quickSort(numbers, 0, numbers.length - 1);
//        for (int i = 0; i < numbers.length; i++)
//            System.out.print(numbers[i] + "\t");
    }
}
