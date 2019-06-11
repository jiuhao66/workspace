package singleton.pojo;

/**
 * @author LX
 * @date 2019/3/1 - 19:54
 */
public class User
{
    private static User user;

    private User(){

    }


    /**
     *  设计单例 模式的  时候 需要考虑 多线程的   并发性
     * @return
     */
    public static  User getInstance(){

        if(user == null){

            /**
             *    防止两个线程同时进来  然后进行  实例化
             */
            synchronized (User.class){

                if(user == null){

                    user = new User();
                }

            }
        }
        return  user ;
    }
}
