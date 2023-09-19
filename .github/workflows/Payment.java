public class Payment {
    double getDiscount(double discountPercentage, double fee) {
        double discount;
        discount = fee * discountPercentage;
        return discount;
    }
    double computeDiscount(double price, double discount) {
        return - discount;
    }
}
