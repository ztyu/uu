import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Singleton {

    /*private Singleton(){}

    private static  class SingletonHolder{
        private final static Singleton singleton = new Singleton();
    }

    public Singleton getInstance(){
        return SingletonHolder.singleton;
    }*/

    public static void main(String args[]) {
        String e = "Pay_Werixin";
        String f = "Refund_Weinx";
        Matcher matcher= Pattern.compile("P").matcher(e);
        System.out.println(matcher.start());
    }
}
