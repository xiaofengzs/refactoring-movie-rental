package cn.xpbootcamp.refactor;

public class Rental {

    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    int getDaysRented() {
        return daysRented;
    }

    public double calculateMoviesAmount() {
        double thisAmount = 0d;
        switch (this.getMovie().getPriceCode()) {
            case Movie.HISTORY:
                thisAmount += 2;
                if (this.getDaysRented() > 2)
                    thisAmount += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += this.getDaysRented() * 3;
                break;
            case Movie.CAMPUS:
                thisAmount += 1.5;
                if (this.getDaysRented() > 3)
                    thisAmount += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
        frequentRenterPoints++;
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    void generateMovieAmount(StringBuilder result, double thisAmount) {
        result.append("\t")
                .append(this.getMovie().getTitle())
                .append("\t")
                .append(thisAmount).append("\n");
    }
}
