package model.Stragety;



public class StragetyTest {


    public static void main(String[] args) {
        Context context = new Context(new Strong());
        context.fighting();
        Context weeakContext = new Context(new Weak());
        weeakContext.fighting();
    }

}
