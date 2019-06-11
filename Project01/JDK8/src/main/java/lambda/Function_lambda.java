package lambda;

import java.util.function.Function;

/**
 * @author LX
 * @date 2019/4/12 - 19:16
 */
public class Function_lambda {

    public static void main(String[] args) {


        System.out.println(functionDemo(1, value->value*2));

        System.out.println(functionDemo(2,value->value*9 ));


        System.out.println(functionDemo1(5, value->value+2));

        System.out.println(functionDemo2(5, value->value+2));

    }

    public static Integer functionDemo(int a , Function<Integer,Integer>function){

        return function.apply(a);
    }

    public static Integer functionDemo1(int a , Function<Integer,Integer>function){

        //   adnThen 方法  是先执行  本身的操作  再去 执行 自带的 function的方法
        return function.andThen(value->value*2).apply(a);
    }


    public static Integer functionDemo2(int a , Function<Integer,Integer>function){

        Function<Integer,Integer>function1 =value->{return  2*value;};
        //   adnThen 方法  是先执行  本身的操作  再去 执行 自带的 function的方法
        return function.compose(function1).apply(a);
    }
}
