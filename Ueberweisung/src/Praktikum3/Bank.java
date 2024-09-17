package Praktikum3;

import java.util.Random;

public class Bank implements Runnable {
	
	
	
	//Attribute
	public int bLZ;
	public Konto[] konten;
	public Transaktionsbroker broker;
	private int ueberweisungsanzahl;
	Bank[] banken;
	
	
	//Getter
	public Konto[] getKonten()
	{
		return konten;
	}
	public synchronized int getBLZ()
	{
		return bLZ;
		
	}
	
	//Setter
	public synchronized void setBroker(Transaktionsbroker broker)
	{
		this.broker = broker;
    }
	public synchronized void setBanken(Bank[] banken)
	{
	    this.banken = banken;
	}
	public synchronized long getGesamteinlage()
	{
	        long gesamteinlage = 0;
	        for (Konto konto : konten)
	        {
	            gesamteinlage += konto.getSaldo();
	        }
	        return gesamteinlage;
	}

	//Konstruktor
	public Bank(int bLZ, int kontenAnzahl)
	{
		this.bLZ = bLZ;
		this.konten = new Konto[kontenAnzahl];
		 this.ueberweisungsanzahl = 0;

		for (int i = 0; i < kontenAnzahl; i++) 
		{
	        konten[i] = new Konto(i, 0);
	    }
	}

	
	public Bank(int blz, int kontenanzahl, int ueberweisungsanzahl) 
	{
        this(blz, kontenanzahl); // Aufruf des anderen Konstruktors
        this.ueberweisungsanzahl = ueberweisungsanzahl;
	}
	
	 public Bank(int blz, int kontenanzahl, int ueberweisungsanzahl, Bank[] banken) 
	 {
	        this(blz, kontenanzahl);
	        this.ueberweisungsanzahl = ueberweisungsanzahl;
	        this.banken = banken;
	 }
	            //int KontonummerQuell = random.nextInt(kontenanzahl);
	        
	         
	            	    
	            	
	            	   
	           // broker.leiteUeberweisungWeiter(ueberweisung)
	
	
	@Override
	public void run() 
	{
		
		if (broker == null)
		{
		    System.err.println("Broker is null");
		    return;
		}
		 	Random random = new Random();
		 	for (int i = 0; i < konten.length; i++)
		 	{
		 		int KontonummerQuell = random.nextInt(konten.length);
		 		int quellBLZ = this.bLZ;
		 		int KontonummerZiel = random.nextInt(konten.length);
	            int zielBLZ = random.nextInt(banken.length);
		 		double betrag = random.nextDouble()*1000;
		 		int priorität = random.nextInt(6);
		 		konten[i].Auszahlung(betrag);
		 		Ueberweisung ueberweisung = new Ueberweisung(KontonummerQuell, quellBLZ, KontonummerZiel, zielBLZ, betrag, priorität); //????
		 		broker.leiteUeberweisungWeiter(ueberweisung);
		 		
		 		//konten[KontonummerQuell], broker.getBanken()[zielBank].getKonten()[KontonummerZiel], betrag, priorität
		 	}
           	    
	}
	
}
