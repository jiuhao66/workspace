package aopTest.schema_base;

/**
 * @author LX
 * @date 2019/2/1 - 11:51
 */
public class Demo {

    public String demo1(String name ,int number){

        System.out.println("demo1");
        return "返回6666";
    }

    public void demo2() throws Exception{

        int i = 5/0;
        System.out.println("demo2");
    }

    public void demo3(){
        System.out.println("demo3");
    }
}
