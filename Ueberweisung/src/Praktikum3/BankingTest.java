package Praktikum3;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.lang.Comparable;

public class BankingTest {
    public static void main(String[] args) {
        testUeberweisungSortieren();
        testPriorityQueue();
        testeBankUndKonto();
        }

    public static void testUeberweisungSortieren() {
        Ueberweisung[] ueberweisungen = new Ueberweisung[6];
        ueberweisungen[0] = new Ueberweisung(958838343, 198383, 298918294, 647738, 1500.0, 2);
        ueberweisungen[1] = new Ueberweisung(234252234, 283998, 837287823, 567849, 200.0, 1);
        ueberweisungen[2] = new Ueberweisung(782934787, 378990, 237488909, 498984, 50000.0, 3);
        ueberweisungen[3] = new Ueberweisung(103948733, 883782, 129380984, 762733, 150.0, 0);
        ueberweisungen[4] = new Ueberweisung(405908985, 939883, 321928398, 373647, 39999.99, 4);
        ueberweisungen[5] = new Ueberweisung(656889853, 545654, 456556756, 835635, 51500.99, 5);

        System.out.println("Vor der Sortierung:");
        System.out.println(Arrays.toString(ueberweisungen));
        System.out.println("\n");

        Arrays.sort(ueberweisungen);

        System.out.println("Nach der Sortierung:");
        System.out.println(Arrays.toString(ueberweisungen));
        System.out.println("\n");
    }
    
    public static void testeBankUndKonto()
	{
		 Bank[] banken = {new Bank(0, 5), new Bank(1, 3)};
	       banken[0].getKonten()[0].Einzahlung(1000);
	       banken[0].getKonten()[1].Einzahlung(200);
	       banken[0].getKonten()[0].Auszahlung(50);
	       
	       banken[0].getKonten()[0].Einzahlung(300);
	       banken[1].getKonten()[1].Einzahlung(400);
	       banken[1].getKonten()[2].Auszahlung(150);
	       
	       for (Bank bank : banken) 
	       {
	    	   
	           System.out.println("Bank-Informationen:");
	           System.out.println("BLZ: " + bank.getBLZ());
	           System.out.println("Gesamteinlage: " + bank.getGesamteinlage());
	           System.out.println("Kontodaten: " + Arrays.toString(bank.getKonten()));
	          
	       }
	}

    public static void testPriorityQueue() {
        Queue<Ueberweisung> ueberweisungen = new PriorityQueue<>();

        ueberweisungen.add(new Ueberweisung(958838343, 198383, 298918294, 647738, 1500.0, 2));
        ueberweisungen.add(new Ueberweisung(234252234, 283998, 837287823, 567849, 200.0, 1));
        ueberweisungen.add(new Ueberweisung(782934787, 378990, 237488909, 498984, 50000.0, 3));
        ueberweisungen.add(new Ueberweisung(103948733, 883782, 129380984, 762733, 150.0, 0));
        ueberweisungen.add(new Ueberweisung(405908985, 939883, 321928398, 373647, 39999.99, 4));
        ueberweisungen.add(new Ueberweisung(656889853, 545654, 456556756, 835635, 51500.99, 5));


        System.out.println("Inhalt der PriorityQueue (vor der Entnahme):");
        
        while (!ueberweisungen.isEmpty()) {
            System.out.println(ueberweisungen.poll());
            System.out.println("Erfolgreich!");
        }
    }
}
