package model;

public class Booking implements Comparable<Booking> {

    private String tcode;
    private String ccode;
    private int seat;

    public Booking() {
    }

    public Booking(String tcode, String ccode, int seat) {
        this.tcode = tcode;
        this.ccode = ccode;
        this.seat = seat;
    }

    public String getTcode() {
        return tcode;
    }

    public String getCcode() {
        return ccode;
    }

    public int getSeat() {
        return seat;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking{" + "tcode=" + tcode + ", ccode=" + ccode + ", seat=" + seat + '}';
    }

    public void showInfo() {
        System.out.printf("%10s|%10s|%10d|\n", tcode, ccode, seat);

    }

    // return positive number is higher, negative number if is lower, 0 if equal
    @Override
    public int compareTo(Booking t) {
        if (t.getTcode().compareTo(tcode) != 0) {
            return t.getTcode().compareTo(tcode);
        } else {
            return t.getCcode().compareTo(ccode);
        }
    }

}
