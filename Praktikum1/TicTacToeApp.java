package lecturelab.tictactoeStudierende;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**Applikation und Benutzerschnittstelle von TicTacToe
 * 
 * @author Prof. Dr. Christian Weidauer (Hochschule Bochum)
 * @author Volker Schürmann (Hochschule Bochum)
 * Lehrgebiet Softwaretechnik
 *
 */
public class TicTacToeApp implements TicTacToeUI{

	/**
	 * Start und Auswertung des Spiels
	 * @param args
	 */
	public static void main(String[] args) {

		UIManager.put("OptionPane.messageFont", new Font(Font.MONOSPACED, Font.PLAIN, 15));

		Spielserie:
			do {
				
				TicTacToe ttt = new TicTacToe(new TicTacToeApp());

				switch (ttt.spiel(TicTacToe.getStartSpieler())) {
				case TicTacToe.UNENTSCHIEDEN:
					JOptionPane.showMessageDialog(null, "Gratulation!\n"
							+"Sie haben unentschieden gespielt!");
					break;

				case TicTacToe.ENTSCHIEDEN:
					JOptionPane.showMessageDialog(null, "Herzlichen Glückwunsch!\n" + 
							ttt.getGewinner()+", Sie haben gewonnen!");
					break;
					
				case TicTacToe.ABGEBROCHEN:
					JOptionPane.showMessageDialog(null, "Abbruch!");
					break Spielserie;
				}
			} while (true);
	}

	/**
	 * Grafische Benutzereingabe
	 */
	@Override
	public String getZugeingabe(char[][] spielbrett, char aktuellerSpieler) {
		
		String ausgabe = "+-+-+-+\n";
		for (char[] zeile:spielbrett){
			for (char spielfeld:zeile) {
				ausgabe += "|" + spielfeld;
			}
			ausgabe += "|\n+-+-+-+\n";
		}

		ausgabe += aktuellerSpieler + ", bitte Zug eingeben!"
		+ "\n(Zug: <Zeile><Spalte>)";
		
		String zugEingabe = JOptionPane.showInputDialog(ausgabe);
		
		return zugEingabe;
	}
}













