
package Praktikum3;

public class Simulation 
{
	public static void main(String[] args) 
	{

	        Bank[] banken = { new Bank(0, 1, 10000), new Bank(1, 1, 10000), new Bank(2, 1, 10000) };

	        saldenAusgeben("Salden aller Banken vorher: ", banken);


	        Transaktionsbroker broker = new Transaktionsbroker(banken);


	        Thread brokerThread = new Thread(broker);
	        brokerThread.start();

	        for (Bank bank : banken) {
	            bank.setBanken(banken);
	        }

	        Thread[] bankThreads = new Thread[banken.length];
	            for (int i = 0; i < banken.length; i++) {
	                banken[i].setBroker(broker);
	                bankThreads[i] = new Thread(banken[i]);
	                bankThreads[i].start();
	            }

	        // Warte auf Beendigung aller Bank-Threads
	            for (Thread bankThread : bankThreads) {
	                try {
	                    bankThread.join();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	            saldenAusgeben("Salden aller Banken nachher: ", banken);
	        }

	        private static void saldenAusgeben(String info, Bank[] banken) {
	            System.out.println(info);
	            long einlagenSumme = 0;
	            for (Bank bank : banken) {
	                long gesamteinlage = bank.getGesamteinlage();
	                einlagenSumme += gesamteinlage;
	                System.out.printf("BLZ: %d Saldo: %+7d%n", bank.getBLZ(), gesamteinlage);
	            }
	            System.out.printf("Gesamteinlage: %d%n%n", einlagenSumme);

	        }

    
    
}