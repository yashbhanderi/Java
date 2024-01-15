package arrays;

class SubarraySum {
    public static void main(String[] args) {
        var arr = new int[] {1};
        
        int n = arr.length;
        
        int i=0,j=0,sum=0,K=0,cnt=0;
        
        while(j<n) {
            
            if(sum==K) {
                cnt++;
            }
            
            else if(j<n && sum<K) {
                sum+=arr[j];
                j++;
            }
            
            else if(sum >= K && i<j) {
                sum-=arr[i];
                i++;
            }
        }
        
        if(sum==K) cnt++;

        System.out.println(cnt);
    }
}