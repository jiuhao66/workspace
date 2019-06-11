package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LX
 * @date 2019/4/12 - 19:11
 */
public class List_lambda {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,6,2,3,5,4,9,3,4,8);

//        Collections.sort(list, (n,m) -> n.compareTo(m));

        list = list.stream().sorted((a, b) -> {

                    if (a > b)
                        return 1;
                    else
                        return -1;
                }
        ).collect(Collectors.toList());



        System.out.println(list);

        List<User>list1 = new ArrayList<>();
        list.forEach(item->{

            list1.add(new User(item,"li"+item));
//            System.out.println(item);
        });

        Collections.sort(list1, (n,m)->{
            if(n.getNumber()>m.getNumber())
                return -1;
            else
                return 1;
        });

        list1.forEach(item->{

            System.out.println(item);
        });

        new Thread(()->{
            System.out.println(666);
        }).start();

    }
}
