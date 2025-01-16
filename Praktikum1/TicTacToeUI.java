package lecturelab.tictactoeStudierende;

/
public interface TicTacToeUI {
	
	/**
	 * Benutzerschnittstelle
	 * @param aktuelles Spielbrett
	 * @param aktueller Spieler
	 * @return Eingabe des aktuellen Spielers
	 */
	public String getZugeingabe(char[][] spielbrett, char aktuellerSpieler);
}
