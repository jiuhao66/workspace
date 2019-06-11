package com.bug.java;

import java.util.*;

public class NetWorkFrist {
    // 记录空闲   区号
    public static int index =1;
    // main方法       psvm
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Nc nc=new Nc(0,66);  //内存容量   0- 66

        //保存作业的 要进入内存和执行的顺序
        //   为true的为  代表要执行的   false 代表 要进内存的

       Map<Blocks,Boolean> map= new HashMap<Blocks,Boolean>();

        List<Work> list=new ArrayList<Work>();

        // 存储  work 的初始化  作业
        String name []=new String[10];
        int start []=new int [10];
        int end []=new int [10];
        int size[]=new int [10];

        // 初始化 work
        for (int i = 0; i < 3; i++) {
            name[i]="p"+i;
            System.out.print("请输入作业"+name[i] +"大小:" );
            size[i]=sc.nextInt();
            Work t=new Work(name[i],size[i]);
            list.add(t);
        }
        setBlockAndNc(list,nc);
        showNc(nc);

        String workName ="";
        System.out.println("请输入释放的作业名字:");
        workName=sc.next();
        shiFang(nc,workName);
        showNc(nc);

       // 遇见 true 并且该对象在内存里面 就从头开始  不然就下一个
        // 初始化 作业
    }

    private static void shiFang(Nc nc, String workName) {
        List<Blocks>list=nc.blocks;
        int lenth=list.size();
        for (int i = 0; i <lenth ; i++) {
            Blocks t=list.get(i);
            String name ="";
            if(t.flag==true){
                if(t.work.name.equals(workName)){
                    //释放资源
                    if(i==0){
                        if(list.get(i+1).flag==true){

                            name=index+"";
                            index++;
                            list.get(i).name=name;
                            list.get(i).work=null;
                            list.get(i).flag=false;
                        }else{
                            /**
                             *    public String name ;  // 分区的名字
                             public int start ;
                             public int end;

                             */
                            name =index+"";
                            index++;
                            int start =t.start;
                            int end =list.get(i+1).end;
                            Blocks b=new Blocks(name ,start,end, end-start,null,false);
                            list.remove(i);
                            list.remove(i+1);
                            list.add(i,b);
                        }

                    }else if(i==lenth-1){

                        if(list.get(i-1).flag==true){
                            name=index+"";
                            index++;
                            list.get(i).work=null;
                            list.get(i).flag=false;
                        }else{
                            /**
                             *    public String name ;  // 分区的名字
                             public int start ;
                             public int end;

                             */
                            name =index+"";
                            index++;
                            int start =list.get(i-1).start;
                            int end =t.end;
                            Blocks b=new Blocks(name ,start,end, end-start,null,false);
                            list.remove(i);
                            list.remove(i+1);
                            list.add(i,b);
                        }

                    }else {

                    }



                }
            }
        }
    }

    public static void showNc(Nc nc){
        List<Blocks>list=nc.blocks;
        int lenth =list.size();
        for (int i = 0; i <lenth ; i++) {
            System.out.print( "分区号:"+list.get(i).name +"  分区大小:"+ list.get(i).size+ " 起始位:"+list.get(i).start );
            System.out.print(" 结束位:"+list.get(i).end );
            if(list.get(i).flag){
                System.out.print(" 作业"+list.get(i).work.name +"在该分区");
            }else{
                System.out.print("该分区为空闲分区");
            }
            System.out.println();
        }
    }

    //初始化 block   和 nc
    public  static  void setBlockAndNc(List<Work> list ,Nc nc){
        int lenth =list.size();
        // 从 零开始
        for (int i = 0; i <lenth ; i++) {
            String name ="";
            int start =0;
            int size=0;
            int end =0;
            Work work=new Work();
            boolean flag=false;

            if(i==0){
                name=index +"";
                start=0;
                size=list.get(i).size;
                end=size;
                if(end>nc.end){
                    continue;
                }
                work=list.get(i);
                flag=true;
                index++;
            }else{
                name=index +"";
                start=nc.blocks.get(i-1).end;
                size=list.get(i).size;
                end=start+size;
                // 判断作业的 end位置是否 超出 内存地址
                if(end>nc.end){
                    continue;
                }
                flag=true;
                index++;
            }
            Blocks block=new Blocks(name ,start,end,size,list.get(i),flag);
            nc.blocks.add(block);

            if(i==2){
                if(nc.end>nc.blocks.get(i).end){
                    name=index+"";
                    Blocks t=new Blocks(name ,end,nc.end,nc.end-end,null,false);
                    nc.blocks.add(t);
                    index++;
                }
            }
        }

    }
}
class Nc{
    public int start ;
    public int end ;
    List<Blocks> blocks=new ArrayList<Blocks>();

    public Nc(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

// 如果 Block块中  flag 为true   则work不为  null   否则为null
class  Blocks{
    // 初始值 为 0  和  null
    public String name ;  // 分区的名字
    public int start ;
    public int end;
    public int size;
    public  Work work;
    public  boolean flag;   //  true  为  占有   false 为空闲

    public Blocks(String name, int start, int end, int size, Work work, boolean flag) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.size = size;
        this.work = work;
        this.flag = flag;
    }

    public Blocks() {
    }
    //    public Block(String name, int start, int end, int size) {
//        this.name = name;
//        this.start = start;
//        this.end = end;
//        this.size = size;
//    }
}

class  Work{
    public String name ;
    public  int size;

    public Work(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public Work() {
    }
}
