package quickSort;

/**
 * @author LX
 * @date 2019/3/23 - 18:12
 */
public class QuickSort {

    public static void main(String[] args) {


        System.out.println(66);
    }

    /**
     * 定义方法 ,用于 进行快速排序
     */
    public static void quickSort(int arr[] ,int left ,int right ){

        //进行判断 如果左边索引比右边索引要打 是不合法的 , 直接使用return
        if(left>right){

            return ;
        }
        //定义 变量  基准数
        int base = arr[left];

        //定义 i 指向最左边
        int i = left ;
        //定义j 指向 最右边
        int j = right;

        while (i != j){

            // 向由j从右往左 检索比基准数小的 如果检索到了 就停下
            while (arr[j]>=base && i<j){

                j--;
            }
            while (arr[i]<=base&&i<j){

                i++;
            }

            int temp = arr[i];

            arr[i] = arr[j];

            arr[j] = temp ;
        }
        //  如果上面的while循环条件不成立  代表 i j 相等了
        // 相遇了 就变换 基准数 和 arr[i]
        int temp = arr[i];

        arr[i] = arr[j];

        arr[j] = temp;

    }
}
