package model.decorator;

public class Suit implements IOuter {

    private Person person;

    Suit(Person person) {
        this.person = person;
    }

    @Override
    public String getCloths() {
        return "suit ";
    }

    @Override
    public String getOuter() {
        return person.getCloths() + "西装";
    }
}
