package Praktikum3;
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
class Ueberweisung implements Comparable<Ueberweisung> {
    public int KontonummerQuell;
    public int blzQuell;
    public int KontonummerZiel;
    public int blzZiel;
    public double betrag;
    public int priorität;

    public Ueberweisung(int KontonummerQuell, int blzQuell, int KontonummerZiel, int blzZiel, double betrag, int priorität) {
        this.KontonummerQuell = KontonummerQuell;
        this.blzQuell = blzQuell;
        this.KontonummerZiel = KontonummerZiel;
        this.blzZiel = blzZiel;
        this.betrag = betrag;
        this.priorität = priorität;
    }

 

	public int getKontonummerZiel() {
        return KontonummerZiel;
    }

    public int getBlzZiel() {
        return blzZiel;
    }

    public double getBetrag() {
        return betrag;
    }

    @Override
    public int compareTo(Ueberweisung other) {
        return Integer.compare(this.priorität, other.priorität);
    }

    @Override
    public String toString() {
        return "Konto von Absender: " + KontonummerQuell + "\n" +  "BLZ von Absender: " + blzQuell + "\n" + "Konto von Empfänger: " + KontonummerZiel + "\n"
                + "BLZ von Empfänger: " + blzZiel + "\n" + "Betrag: " + betrag + "\n" + "Priorität=" + priorität;
    }
}

