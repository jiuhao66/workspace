package md5;

/**
 * @author LX
 * @date 2019/3/29 - 11:47
 */
public class TSort {

    public static void main(String[] args) {

        //  n的取值  是你所要排序的最大 一个数
        //桶排序
        int  n = 100;

        int arr [] = new int [n];

        int t [] = {2,8,1,0,45,69};

        for(int  i = 0 ; i < t.length ; i++ )
            arr[ t[i] ]++;

        for (int i = 0 ; i < arr.length ; i++ ){

            if(arr[i] != 0)
                for (int j = 0; j < arr[i] ; j++)
                    System.out.println(i);
        }
    }
}
