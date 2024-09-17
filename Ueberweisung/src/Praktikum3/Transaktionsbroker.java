package Praktikum3;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Transaktionsbroker implements Runnable {
	Bank[] banken;
	private Queue<Ueberweisung> ueberweisungen;
	public Transaktionsbroker(Bank[] banken)
	{
		this.banken = banken;
		this.ueberweisungen = new PriorityQueue<>();
	}
	
	public Bank[] getBanken()
	{
		return banken;
	}
	
	 
	public void leiteUeberweisungWeiter(Ueberweisung ueberweisung)
	{
		ueberweisungen.add(ueberweisung);
		
	}
	public void fuehreUeberweisungAus(Ueberweisung ueberweisung)
	{
		Bank zielBank = banken[ueberweisung.getBlzZiel()];
		//zielBank.Einzahlung(ueberweisung.getBetrag());
		//  Bank quelleBank = banken[ueberweisung.getBlzQuell()];
	    //  Bank zielBank = banken[ueberweisung.getBlzZiel()];

	    //  Konto quelleKonto = quelleBank.getKonten()[ueberweisung.getKontonummerQuell()];
	    Konto zielKonto = zielBank.getKonten()[ueberweisung.getKontonummerZiel()];

	    double betrag = ueberweisung.getBetrag();
	     // quelleKonto.Auszahlung(betrag);
	    zielKonto.Einzahlung(betrag);

	     // System.out.println("Überweisung ausgeführt: " + ueberweisung.toString());
	        
	      Thread transactionThread = new Thread(this);
	      transactionThread.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 long zeitLetzteUeberweisung = System.currentTimeMillis();
		 while (System.currentTimeMillis() - zeitLetzteUeberweisung < 1000) 
		 {
	            Ueberweisung ueberweisung = ueberweisungen.poll();
	            if (ueberweisung != null) 
	            {
	            	 fuehreUeberweisungAus(ueberweisung);
		             zeitLetzteUeberweisung = System.currentTimeMillis();
	            }
	            else
	            {    	
		         	try 
	            	{
	                    Thread.sleep(100);
	                } 
	            	catch (InterruptedException e)
	            	{
	                    e.printStackTrace();
	                }
	            }
	
		 }
	}
	
}
