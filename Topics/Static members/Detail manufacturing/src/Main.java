
class ManufacturingController {

    static int numberOfProducts = 0;

    public static String requestProduct(String product) {
        numberOfProducts++;
        return numberOfProducts + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        return numberOfProducts;
    }
}