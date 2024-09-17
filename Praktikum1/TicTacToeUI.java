package lecturelab.tictactoeStudierende;

/**Schnittstelle f�r das User Interface von TicTacToe
 * 
 * @author Prof. Dr. Christian Weidauer (Hochschule Bochum)
 * @author Volker Sch�rmann (Hochschule Bochum)
 * Lehrgebiet Softwaretechnik
 *
 */
public interface TicTacToeUI {
	
	/**
	 * Benutzerschnittstelle
	 * @param aktuelles Spielbrett
	 * @param aktueller Spieler
	 * @return Eingabe des aktuellen Spielers
	 */
	public String getZugeingabe(char[][] spielbrett, char aktuellerSpieler);
}
