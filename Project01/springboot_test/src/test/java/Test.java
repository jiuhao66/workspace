import java.util.ArrayList;
import java.util.List;

/**
 * @author LX
 * @date 2019/6/1 - 17:11
 */
public class Test {

    public static void main(String[] args) {

        List<Integer>list = new ArrayList<>();

        list.add(66);
        list.add(99);

        list.forEach((ele)->{

            System.out.println(ele);
        });
    }
}
