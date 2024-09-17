package V1;

public class Sendungstyp {
	//
	//{
		//Instanzvariablen
		private int maxHoehe;
		private int maxGewicht;
		private int porto;
		private String bezeichnung;
		
		//BriefmarkenautomatTest oOpOose = new BriefmarkenautomatTest();
		//Briefmarkenautomat oOpOOse = new Briefmarkenautomat();
		//Konstruktur - инициализация обьекта,
		public Sendungstyp(int maxHöhe, int maxGew, int pporto, String bez)
		{
			maxHoehe = maxHöhe;
			maxGewicht = maxGew;
			porto = pporto;
			bezeichnung = bez;
		}
	
		
		//Getter
		public int getMaxHoehe()
		{
			return maxHoehe;
		}
		public int getMaxGewicht()
		{
			return maxGewicht;
		}
		public int getPorto()
		{
			return porto;
		}
		public String getBezeichnung()
		{
			return bezeichnung;
		}
		
		//Array
		private static Sendungstyp[] array = 
			{
				new Sendungstyp(0, 0,70, "Postkarte"), //
				new Sendungstyp(5, 20, 85, "Standart"), // Höhe, Gewicht, Preise
				new Sendungstyp(10, 50, 100, "Kompakt"),
				new Sendungstyp(20, 500, 160, "Groß"),
				new Sendungstyp(50, 1000, 275, "Maxi"),
			};
		//Methode 
	public static Sendungstyp typ(int gewicht, int hoehe)
	{
		if(hoehe == 0)
        {
        	return array[0];
        }
		for(int i = 0; i < 5; i++)
		{
			if(gewicht <= array[i].getMaxGewicht() && hoehe <= array[i].getMaxHoehe())
			{
				return array[i];
			}
			
		}
		return null;
	}


}
