package javaPractice;

public class fibonac {
    public static void main(String[] args) {
        int a=0,b=1,c;
        for (int i=1;i<=10;i++){
            System.out.print(a+" ");
            c=a+b;
            a=b;
            b=c;

        }
    }
}
