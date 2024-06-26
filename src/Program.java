import java.util.ArrayList;
import java.util.Collections;

public class Program {
    public static void main(String[] args) {
        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);

        var ans = Collections.binarySearch(list, 1);

        System.out.println(ans);
    }
}
