package V1;
import java.util.Scanner;
public class Briefmarkenautomat {
	
	private static int[] coins = {200, 100, 50, 20, 10, 5};
	private static boolean exit = false; //Служит для остановки программы. Пока он false, метод будет продолжаться
	public static int[] wechselgeldBerechnen(int wechselgeld) // Versuch 1.2
	{
		
		int [] change = new int[6];
		for(int i = 0; i <=5; i++)
			{
				if(wechselgeld == 0)
				{
					break;
				}
				int digit = wechselgeld / coins[i]; //число durch die Münzen geteilt wurde.
				change[i] = digit; // Запись числа в массив
				for(int q = 0; q < digit; q++)
				{
					wechselgeld = wechselgeld - coins[i]; //reste
				}
				
			}
		return change; 
	}
	
	public static int kassieren(int betrag, Scanner enter) //Versuch 1.3
	{
		
		
		int insert = 0; // Сколько монет в автомате на данный момент
		while (betrag > insert) // Пока сумма покупки больше монет в автомате
		{
			System.out.println("You need to insert more: " + (betrag-insert));
			System.out.println("Please, insert the coins! ");
			if(enter.hasNextInt())	
			{
				int tempPay = enter.nextInt(); // Запись в enter
				boolean contains = false; 
				for(int coin : coins) // Каждая монета наминалом 200, 100 и т.д.
				{
					if(coin == tempPay) //Монетки могут быть только наминалом 200-5.
					{
						contains = true; //Автомат принимает монету и останавливает программу. Но цикл начинает её заново
						
						break;
					}
				}
				if(contains == false) // Монета не может быть равна числу не из массива
				{
					System.out.println("Revoked. " + tempPay);
					continue;
					
				}	
				
				insert += tempPay; //Сумма с присваиванием нового значения 
				
			}
			else if(enter.next().contentEquals("a")) //Считываем, если в буффере enter.next() было введено a. 
			//contentEquals возвращает значение true только в том случае, если эта строка представляет собой ту же последовательность символов, которая указана в строке буфера (StringBuffer).
			{
				exit = true;
		        return insert;
			}
		}
		return insert - betrag;
	}
	

    public static void main(String[] args) 
    {
    	Scanner enter = new Scanner(System.in); // Versuch 1.4
        while (true)
        {
            int mass = 0;
            int height = 0;
            Integer number = ReadInt(enter, "Weight of package:"); //Integer - обьектный тип int. На него нужно больше памяти.
           
            if (number == null) 
            {
            	break; 
            }
            mass = number;
            number = ReadInt(enter, "High of package:");//
            if (number == null) 
            {
            	break; 
            }
            
          
            height = number;
            Sendungstyp paket = Sendungstyp.typ(mass, height); //Из  класса Sendungstyp берём данные веса и высоты
            System.out.println("You purchased " + paket.getBezeichnung() + ", that costs " + paket.getPorto() + "cents.");
            
            System.out.print("Please enter, how many packages do you need. Maximal digit is 10: ");
            int number1 = enter.nextInt(); // 
            if (number1 > 10) 
            {
            	number1 = 10;
                System.out.println("This amount is not available. It was automaticly setted on 10. ");
            }
            Sendungstyp[] letter = new Sendungstyp[number1];
            for (int i = 0; i < number1; i++){
                letter[i] = paket;
            }
            int gesamtPorto = CalculatePorto(letter);
            int rest = kassieren(gesamtPorto, enter);//
            if(exit == false){
                System.out.println("You bought: " + number1 + " " + paket.getBezeichnung());
            }
            System.out.println("Your change: ");
            int[] wechselgeld = wechselgeldBerechnen(rest);
            for (int i = 0; i < wechselgeld.length; i++){
                if (wechselgeld[i] == 0)
                {
                	continue; 
                }
                System.out.println(wechselgeld[i]+ " times" + " " + coins[i] + "cents");
            }
        }
        
    }
        
        public static Integer ReadInt(Scanner enter, String message)
        {
            System.out.println(message);
            do {
                if (enter.hasNextInt()) { //Интерация через токен, возвращает true если с потока ввода можно считать целое число
                    return enter.nextInt();
                }
            }
            while (!enter.next().contentEquals("a"));
            return null; //Abbruch
         }
        
        
        
        public static int CalculatePorto(Sendungstyp[] letter)
        {
            int gesamtPorto = 0;
            for (Sendungstyp sendung : letter) 
            {
                gesamtPorto += sendung.getPorto();
            }
            return gesamtPorto;
        }
	}
	

