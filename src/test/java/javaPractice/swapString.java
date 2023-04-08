package javaPractice;

public class swapString {
    public static void main(String[] args) {
        String x="Hello";
        String y="World";
        x=x+y;//HelloWorld
        y=x.substring(0,x.length()-y.length());//Hello
        x=x.substring(y.length());
        System.out.println(x+" "+y);
    }
}
