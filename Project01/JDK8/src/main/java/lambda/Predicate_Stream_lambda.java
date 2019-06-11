package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @author LX
 * @date 2019/4/23 - 21:47
 */
public class Predicate_Stream_lambda {

    public static void main(String[] args) {

        User user = new User(30,"李");
        User user1 = new User(30,"李");
        User user2 = new User(70,"乾");

        List<User> list = Arrays.asList(user,user1,user2);

        Predicate_Stream_lambda lambda = new Predicate_Stream_lambda();

//        List<User> userList = lambda.getUserByName("李", list);
//        List<User> userList = lambda.sortUserByNumber(35, list);

        List<User> userList = lambda.distinct(list);
        System.out.println(userList);


    }

    public List<User> getUserByName(String name ,List<User>list){

        return list.stream().filter(user -> user.getName().equals(name)
        ).collect(Collectors.toList());
    }

    public List<User> distinct(List<User> list){

       return list.stream().distinct().collect(Collectors.toList());
    }

    public List<User> sortUserByNumber(double number ,List<User> list){

        BiFunction<Double , List<User>,List<User>> biFunction = (userOfNumber,userList)->{
            return  userList.stream().filter(user -> user.getNumber()>userOfNumber).collect(Collectors.toList());
        };

        return biFunction.apply(number, list);
    }
}
