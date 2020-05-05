package cn.xpbootcamp.refactor;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    String statement() {
        double totalAmount = 0d;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            double thisAmount = each.calculateMoviesAmount();
            frequentRenterPoints = each.getFrequentRenterPoints(frequentRenterPoints, each);
            each.generateMovieAmount(result, thisAmount);
            totalAmount += thisAmount;
        }
        generateStatement(totalAmount, frequentRenterPoints, result);
        return result.toString();
    }

    private void generateStatement(double totalAmount, int frequentRenterPoints, StringBuilder result) {
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
    }
}
