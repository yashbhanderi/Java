package binary_search;

import common.Common;

class LowerBound {
    
    public static void main(String[] args) {
        var arr = new int[] {1, 2, 3, 3, 4};
        
        int n = arr.length;
        
        int lower_bound = Common.lowerBound(arr, 0, n-1, 2);

        System.out.println(lower_bound);
    }
}