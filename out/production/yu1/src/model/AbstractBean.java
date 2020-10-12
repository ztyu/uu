package model;

public class AbstractBean extends AbstractTest{

    public AbstractBean(){}

    @Override
    public void test(String content) {
         System.out.println("AbstractBean:"+content);
    }
}
