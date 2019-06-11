package aopTest.apectj;

/**
 * @author LX
 * @date 2019/2/2 - 10:14
 */
public class Demo {

    public void demo1(){
        System.out.println("demo1");
    }

    public void demo2() throws Exception{

        int i = 5/0;
        System.out.println("demo2");
    }

    public void demo3(int number1 , String name1){
        System.out.println("demo3");
    }
}
