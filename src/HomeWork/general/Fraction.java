package HomeWork.general;

public class Fraction {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(-1, -3);
        Fraction f3 = new Fraction(0, -3);
        System.out.println(f1.multiply(f2).toString());
        System.out.println(f1.divide(f3));
    }

    private final int nominator;
    private final int denominator;

    public Fraction(int nominator, int denominator) {
        if(denominator == 0){
            throw new IllegalArgumentException("Denominator in fraction can't be 0.");
        }
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public Fraction(int denominator) {
        this(1, denominator);
    }

    //Sum, subtract

    public Fraction divide(Fraction f){
        if(f.nominator == 0){
            throw new IllegalArgumentException("Denominator in fraction can't be 0.");
        }
        Fraction temp = new Fraction(this.nominator*f.denominator, this.denominator*f.nominator);
        return temp;
    }

    public Fraction multiply(Fraction f){
        return new Fraction(this.nominator*f.nominator, this.denominator*f.denominator);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.nominator;
        hash = 59 * hash + this.denominator;
        // add sign logic
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fraction other = (Fraction) obj;
        double sign = Math.signum(nominator)*Math.signum(denominator);
        double signOther = Math.signum(other.nominator)*Math.signum(other.denominator);
        if (Math.abs(this.nominator) != Math.abs(other.nominator)) {
            return false;
        }
        if (Math.abs(this.denominator) != Math.abs(other.denominator)) {
            return false;
        }
        if (sign != signOther) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nominator + " / " + denominator;
    }

    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }


}
