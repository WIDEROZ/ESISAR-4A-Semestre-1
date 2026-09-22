package fr.esisar.in450.gomoku.player;

import fr.esisar.in450.gomoku.gamecore.AbstractPlayer;
import fr.esisar.in450.gomoku.gamecore.enums.CellColor;
import fr.esisar.in450.gomoku.gamecore.model.Coords;

public class MinMaxAIPlayer extends AbstractPlayer {

	@Override
	public Coords play() {
		
		return null;
	}
	
	
	
	
	private int eval_plateau() {
		int len = board.SIZE;
		int i,j;
		for(i = 0; i < len; i++) {
			for(j=0; j<len; j++) {
				if(board.getCellColor(i, j) == CellColor.WHITE) {
					
				}
				else if(board.getCellColor(i, j) == CellColor.BLACK){
					
				}
			}
		}
		
		return 0;
	}
	
	
	/**
	 * Retourne true si la cellule i,j est vide et qu'une cellule adjacente contient 
	 * une pierre de la couleur de ce joueur  
	 */
	private boolean isMatching(int i, int j)
	{
		// On verifie si la case est vide 
		if (board.getCellColor(i, j)!=null)
		{
			return false;
		}
				
		// Horizontal
		if (isMyStone(i-1,j)) return true;
		if (isMyStone(i+1,j)) return true;
		
		// Vertical
		if (isMyStone(i,j-1)) return true;
		if (isMyStone(i,j+1)) return true;
		
		// Diagonal
		if (isMyStone(i-1,j-1)) return true;
		if (isMyStone(i-1,j+1)) return true;
		if (isMyStone(i+1,j-1)) return true;
		if (isMyStone(i+1,j+1)) return true;
		
		return false;
	}
	
	/**
	 * Retourne true si i,j sont des coordonnées valides et si 
	 * la cellule i,j contient une pierre de de la couleur de ce joueur  
	 * 
	 */
	private boolean isMyStone(int i, int j)
	{
		if (isValid(i) && isValid(j))
		{
			return board.getCellColor(i, j)==playerColor;
		}
		else
		{
			return false;
		}
	}

	private boolean isValid(int rowOrCol)
	{
		return rowOrCol>=0 && rowOrCol <board.SIZE;
	}

}
