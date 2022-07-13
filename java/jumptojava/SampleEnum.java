package jumptojava;

public class SampleEnum {
    enum CoffeeType {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE
    };
    public static void main(String[] args) {
        System.out.println(CoffeeType.AMERICANO);       // AMERICANO
        System.out.println(CoffeeType.ICE_AMERICANO);   // ICE_AMERICANO
        System.out.println(CoffeeType.CAFE_LATTE);      // CAFE_LATTE
        for (CoffeeType type: CoffeeType.values()) {
            System.out.println(type);
        }
    }
}
