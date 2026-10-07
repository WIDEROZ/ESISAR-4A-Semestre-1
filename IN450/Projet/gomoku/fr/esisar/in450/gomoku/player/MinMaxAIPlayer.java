package fr.esisar.in450.gomoku.player;



import fr.esisar.in450.gomoku.gamecore.AbstractPlayer;
import fr.esisar.in450.gomoku.gamecore.enums.CellColor;
import fr.esisar.in450.gomoku.gamecore.model.Coords;
import fr.esisar.in450.gomoku.gamecore.model.GomokuBoard;

import fr.esisar.in450.gomoku.tree.Tree;

public class MinMaxAIPlayer extends AbstractPlayer {
	
	private static final int depth_MINMAX = 2;
	private Tree minmax_tree;
	private boolean premier_coup = true;
	
	public static final double POSITIVE_INFINITY = 1.0 / 0.0;
	public static final double NEGATIVE_INFINITY = -1.0 / 0.0;

	
	

	@Override
	public Coords play() {
		if(premier_coup) { // Si l'adversaire n'as pas encore joué alors on pose une pierre en (7, 7)
			premier_coup = false;
			if(board.isEmpty()) {
				Coords move = new Coords(7, 7);
				minmax_tree = construct_minmax_tree(move, depth_MINMAX, true);
				return move;
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
		
		
		
		
		return null;
	}
	
	
	/*
	 * Create a minmax tree regarding the posSible moves on the board
	 * 
	 */
	private Tree construct_minmax_tree(Coords move, int depth, boolean is_player_turn) {
		if(depth == 0) {
			return new Tree(move);
		}
		else {
			// Détermination de la couleur
			CellColor color;
			if(!is_player_turn) {
				if(playerColor == CellColor.WHITE) {
					color = CellColor.BLACK;
				}
				else {
					color = CellColor.WHITE;
				}
			}
			else {
				color = playerColor;
			}
			// Fin de la détermination de la couleur
			
			
			Tree tree = new Tree(move);
			for(Coords coordonnes : board.empty_cells) {
				board.setCellColor(coordonnes.row, coordonnes.col, color);
				tree.getChildrens().add(construct_minmax_tree(coordonnes, depth-1, !is_player_turn));
				board.removeCellColor(coordonnes.row, coordonnes.col);
			}
			
			return tree;
			
		}
	}
	
	
	
	private int minmax(int depth, boolean max, Tree arbre) {
		if(depth == 0 || arbre.isLeaf()) {
			int eval = board.eval_plateau();
			arbre.setEval(eval);
			return eval;
		}
		else {
			Coords move;
			if(max) { // IA
				arbre.setEval((int) NEGATIVE_INFINITY);
				for(Tree child : arbre.getChildrens()) {
					move = child.getMove();
					board.setCellColor(move.row, move.col, playerColor);
					arbre.setEval(Math.max(arbre.getEval(), minmax(depth-1, false, child)));
					board.removeCellColor(move.row, move.col);
				}
			}
			else { // Adversaire
				CellColor opponent_color;
				if(playerColor == CellColor.WHITE) {
					opponent_color = CellColor.BLACK;
				}
				else {
					opponent_color = CellColor.WHITE;
				}
				arbre.setEval((int) POSITIVE_INFINITY);
				for(Tree child : arbre.getChildrens()) {
					move = child.getMove();
					board.setCellColor(move.row, move.col, opponent_color);
					arbre.setEval(Math.min(arbre.getEval(), minmax(depth-1, true, child)));
					board.removeCellColor(move.row, move.col);
				}
			}
			return arbre.getEval();
		}
		
	}
	
	
	

	
	
	
	
	

}
