package wzorceProjektowe.decorator;

public class PizzaMaker {

    public static void main(String[] args) {
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));

        System.out.println(basicPizza.getDescription());
        System.out.println(basicPizza.getCost());
    }
}

interface Pizza {
    String getDescription();

    Double getCost();
}

abstract class ToppingDecorator implements Pizza {

    protected Pizza tempPizza;

    public ToppingDecorator(Pizza tempPizza) {
        this.tempPizza = tempPizza;
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription();
    }

    @Override
    public Double getCost() {
        return tempPizza.getCost();
    }
}


class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Thin douhg";
    }

    @Override
    public Double getCost() {
        return 10.00;
    }
}

class Mozzarella extends ToppingDecorator {

    public Mozzarella(Pizza tempPizza) {
        super(tempPizza);

        System.out.println("Adding dough");
        System.out.println("Adding mozarella");
    }

    public String getDescription() {
        return tempPizza.getDescription() + ", + mozarella";
    }

    public Double getCost() {
        return tempPizza.getCost() + 0.50;
    }
}

class TomatoSauce extends ToppingDecorator {

    public TomatoSauce(Pizza tempPizza) {
        super(tempPizza);

        System.out.println("Adding tomato sauce");
    }

    public String getDescription() {
        return tempPizza.getDescription() + ", + tomato souce";
    }

    public Double getCost() {
        return tempPizza.getCost() + 0.20;
    }
}
