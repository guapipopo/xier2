import java.util.Scanner;

public class homework2 extends Thread {



    public static void main(String[] args) {

        homework2 aa=new homework2();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的邮箱");
        String email =sc.nextLine();
        System.out.println( aa.isEmail(email));
        System.out.println("请用逗号隔开数字");
        System.out.println("请输入数组1");
        String[]num1=sc.nextLine().split(",");
        int[]num11=new  int[num1.length];
        System.out.println("请输入数组2");
        String[]num2=sc.nextLine().split(",");
        int[]num12=new  int[num2.length];
        for(int i=0;i<num1.length;i++){
            num11[i]=Integer.parseInt(num1[i]);
        }
        for(int i=0;i<num2.length;i++){
            num12[i]=Integer.parseInt(num2[i]);
        }

        aa.Alternateoutput(num11,num12);


    }

    public void Alternateoutput(int[]a,int[]b) {
     new Thread(){
         @Override
         public void run() {
             synchronized (homework2.class) {
             for (int a1:a) {

                     System.out.println(Thread.currentThread().getName()+":"+  a1);

                     try {
                         homework2.class.notify();
                         homework2.class.wait();

                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }
     }.start();


        new Thread(){
            @Override
            public void run() {
                synchronized (homework2.class) {
                    for (int b2:b){
                        System.out.println(Thread.currentThread().getName()+":"+  b2);

                        try {
                            homework2.class.notify();
                            homework2.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }.start();




    }

    public  boolean isEmail(String email){
        if(email.matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$")){
            return  true;
        }else {
            return false;
        }
    }

}
