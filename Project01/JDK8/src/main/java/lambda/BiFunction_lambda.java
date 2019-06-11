package lambda;

import java.util.function.BiFunction;

/**
 * @author LX
 * @date 2019/4/12 - 19:37
 */
public class BiFunction_lambda {

    public static void main(String[] args) {

        System.out.println(biFunction(3, 5, ( a , b ) -> a+b ) );
    }

    public static int biFunction(int a,int b, BiFunction<Integer ,Integer,Integer>biFunction){

        return biFunction.andThen(value->value*2).apply(a, b);
    }
}
