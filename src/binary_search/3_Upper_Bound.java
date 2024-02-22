package binary_search;

import common.Common;

class UpperBound {
    public static void main(String[] args) {
        var arr = new int[] {1,2,3,4,5,5,5,6,7,9,9};
        
        int n = arr.length;

        int upper_bound = Common.upperBound(arr, 0, n-1, 5);

        System.out.println(upper_bound);
    }
}