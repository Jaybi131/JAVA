package Praktikum3;

public class Konto 
{
	
	public int Konto;
	public static long saldo;
	
	public Konto(int Konto, long saldo)
	{
		this.Konto = Konto;
		this.saldo = saldo;
	}
	
	public void setKonto()
	{
		this.Konto = Konto;
	}
	public void setSaldo() 
	{
        this.saldo=saldo;
    }
	public long getSaldo() 
	{
        return saldo;
    }
	public void Einzahlung(double betrag)
	{
		  saldo += betrag;
		//double gewinn;
		//gewinn = saldo + einzahlung;	
		
	}
	public void Auszahlung(double betrag)
	{
		//double reste;
		//reste = saldo - auszahlung;
		saldo -= betrag;
		//if(saldo <= 0)
		//{
		//	System.out.println("Ihre Kontozustand verfügt nicht genug Geldmittel für Transaktion. ");
		//}
		  
	}
	
	public void ueberweisen(Konto empfänger, double betrag)
	{
	        this.Auszahlung(betrag);
	        empfänger.Einzahlung(betrag);
	}
	public String toString()
	{
		return "Konto: " + Konto + " Saldo: " + saldo + "\n"; 
	}
	
}
