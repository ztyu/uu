package model.decorator;

public class Test {

    public static void main(String[] args) {
        Person man = new Man();
        IOuter suit = new Suit(man);
        System.out.println(suit.getCloths() + suit.getOuter());
    }

}
