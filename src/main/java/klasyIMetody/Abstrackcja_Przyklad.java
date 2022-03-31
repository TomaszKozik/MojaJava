package klasyIMetody;

/**
 * Telefon
 */
class MobilePhone {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * Klasa do zakupu telefonu na podstawie zamówienia
 * Aby móc zakupić telefon potrzebujemy zrobić zamówienie.
 * Stosując w klasie BuyMobilePhone metodę abstrakcyjną zrzutowaną na klasę MobilePhone,
 * wymuszamy zbudowanie klasy do zamówienia OrderMobilePhone, która ma zwrócić obiekt MobilePhone.
 */
abstract class BuyMobilePhone {
    abstract public MobilePhone orderMobilePhone(String cos);

    public void buy(String name) {
        MobilePhone mobilePhone = orderMobilePhone(name);
        System.out.println(mobilePhone.getName());
    }
}

/**
 * Klasa do zamówienia telefonu, której zbudowanie zostało narzucone przez BuyMobilePhone
 * W metodzie orderMobilePhone musimy zaimplementować obiekt do zakupu i określić jego parametry (jeśli są),
 * a następnie go zwrócić. Dzięki temu wiemy co zamawiamy.
 */
class OrderMobilePhone extends BuyMobilePhone {
    @Override
    public MobilePhone orderMobilePhone(String cos) {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.setName(cos);
        return mobilePhone;
    }
}

/**
 * Kupujemy telefon na podstawie złożonego zamówienia
 */
class Abstrackcja_Przyklad {
    public static void main(String[] args) {
        BuyMobilePhone orderMobilePhone = new OrderMobilePhone();
        orderMobilePhone.buy("Nokia");
    }
}