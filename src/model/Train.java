
package model;

import java.io.Serializable;
import java.util.Objects;

public class Train implements Comparable<Train>,Serializable{
    private String tcode;
    private String train_name;
    private int seat;
    private int booked;
    private double depart_time;
    private String depart_place;

    public Train() {
    }

    public Train(String tcode, String train_name, int seat, int booked, double depart_time, String depart_place) {
        this.tcode = tcode;
        this.train_name = train_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.depart_place = depart_place;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(double depart_time) {
        this.depart_time = depart_time;
    }

    public String getDepart_place() {
        return depart_place;
    }

    public void setDepart_place(String depart_place) {
        this.depart_place = depart_place;
    }

    @Override
    public String toString() {
        return "Train{" + "tcode=" + tcode + ", train_name=" + train_name + ", seat=" + seat + ", booked=" + booked + ", depart_time=" + depart_time + ", depart_place=" + depart_place + '}';
    }

    // override equal. Compare 2 Train with tcode
    // return true or false.
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
        final Train other = (Train) obj;
        return Objects.equals(this.tcode, other.tcode);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.tcode);
        return hash;
    }
    
    public void showInfo() {
        int available_seat = seat - booked;
        System.out.printf("%10s|%10s|%10d|%10d|%11f|%12s|%14d|\n", tcode, train_name, seat, booked, depart_time, depart_place, available_seat);

    }

    // Compare 2 train, return 0 if equal, positive if higher, negative if lower
    @Override
    public int compareTo(Train t) {
        return t.getTcode().compareTo(tcode);
    }
}
