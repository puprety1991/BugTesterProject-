package javaPractice;

public class primeP {
    public static void main(String[] args) {
        int a=11;
        boolean number=true;
        if (a>1){
            for (int i=2;i<a;i++){
                if(a%i==0){
                    number=false;
                    break;
                }
            }
        } else {
            number=false;
        }
        System.out.println(" the given number "+ a+" is prime "+number );
    }
}
