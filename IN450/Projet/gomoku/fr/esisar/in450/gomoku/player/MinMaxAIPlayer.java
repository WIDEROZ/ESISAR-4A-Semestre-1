package fr.esisar.in450.gomoku.player;

import java.util.Iterator;

import fr.esisar.in450.gomoku.gamecore.AbstractPlayer;
import fr.esisar.in450.gomoku.gamecore.enums.CellColor;
import fr.esisar.in450.gomoku.gamecore.model.Coords;
import fr.esisar.in450.gomoku.gamecore.model.GomokuBoard;

import fr.esisar.in450.gomoku.tree.Tree;

public class MinMaxAIPlayer extends AbstractPlayer {
	
	private static final int depth_MINMAX = 3;
	private Tree minmax_tree;
	private boolean premier_coup = true;
	
	
	


	@Override
	public Coords play() {
		if(premier_coup) { // Si l'adversaire n'as pas encore joué alors on pose une pierre en (7, 7)
			premier_coup = false;
			if(board.isEmpty()) {
				Coords coup = new Coords(7, 7);
				minmax_tree = new Tree(coup, 0);
				return coup;
			}
		}
		Coords prev_move = board.prev_move;
		
		Tree tmp_tree = minmax_tree.getNextNode(prev_move);
		if(tmp_tree == null) {
			System.err.print("NEXT NODE IS NULL");
		}
		else {
			minmax_tree = tmp_tree;
		}
		
		
		
		minmax(depth_MINMAX, true, board);
		return null;
	}
	
	
	
	private int minmax(int depth, boolean max, GomokuBoard plateau) {
		if(depth == 0) {
			return plateau.eval_plateau();
		}
		else {
			if(max) {
				
			}
			else {
				
			}
		}
		return 0;
	}
	
	
	
	
	
	

}
