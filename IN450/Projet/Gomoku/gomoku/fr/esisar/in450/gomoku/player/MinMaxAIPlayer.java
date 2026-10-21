package fr.esisar.in450.gomoku.player;



import fr.esisar.in450.gomoku.gamecore.AbstractPlayer;
import fr.esisar.in450.gomoku.gamecore.enums.*;
import fr.esisar.in450.gomoku.gamecore.model.Coords;

import fr.esisar.in450.gomoku.tree.Tree;

import java.util.ArrayList;


public class MinMaxAIPlayer extends AbstractPlayer {
	
	private static final int depth_MINMAX = 5; // Profondeur de l'arbre Min Max
	private Tree minmax_tree; // Arbre Min Max
	private boolean premier_coup = true; // Variable qui représente le premier coup

	
	

	@Override
	public Coords play() {
		if(premier_coup) { // Jouer le premier coup
			return playPremierCoup();
		}
		

		// Obtenir le noeud joué par le joueur adverse
		Coords prev_move = new Coords(board.prev_move);
		System.out.println("Coup précédent : " + prev_move);
		

		// Avancer dans l'arbre minmax suivant le dernier coup joué par l'adversaire
		Tree tmp_tree = minmax_tree.getNextNode(prev_move);
		if(tmp_tree == null) { // Si l'enfant est null alors on reconstruit l'arbre
			minmax_tree = construct_minmax_tree(prev_move, depth_MINMAX, playerColor);
		}
		else {
			minmax_tree = tmp_tree;
		}
		
		// Afficher l'abre
		//minmax_tree.displayTree(3);
		
		
		// Touver la couleur du jouteur adverse
		CellColor opponentColor = (playerColor == CellColor.WHITE) ? CellColor.BLACK : CellColor.WHITE;
		
		
		// Etendre l'arbre à la profondeur souhaité
		extend_minmax_tree(minmax_tree, depth_MINMAX, opponentColor);
		// On applique l'algorithme minmax
		elagage_minmax(depth_MINMAX, true, minmax_tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		
		// L'IA choisit le meilleur coup
		minmax_tree = minmax_tree.getBestNextNode(playerColor);
		
		
		// Gestion de la remise à la valeur initiale de la variable premier_coup (true)
		Coords move = minmax_tree.getMove();
		board.setCellColor(move.row, move.col, playerColor);
		if(board.getWinnerState() != WinnerState.NONE) {
			premier_coup = true;
		}
		board.removeCellColor(move.row, move.col);
		
		
		return move;
	}
	
	
	/*
	 * Gestion du premier coup
	 */
	private Coords playPremierCoup() {
		premier_coup = false;
		if(board.isEmpty()) { // L'adversaire n'a pas encore joué
			// Le joueur pose une case en (8, 8)
			Coords move = new Coords(7, 7);
			board.setCellColor(7, 7, playerColor);
			
			// Calcul de la couleur de l'adversaire
			CellColor opponentColor = (playerColor == CellColor.WHITE) ? CellColor.BLACK : CellColor.WHITE;
			
			// Construction de l'arbre minmax
			minmax_tree = construct_minmax_tree(move, depth_MINMAX, opponentColor);
			board.removeCellColor(7, 7);
			return move;
		}
		else { // L'adversaire à déjà joué
			// On prend conaissance du coup précédent
			Coords prev_move = new Coords(board.prev_move);
			System.out.println("Coup précédent : " + prev_move);
			
			// Construction de l'arbre minmax à partir du coup de l'adversaire : 
			minmax_tree = construct_minmax_tree(prev_move, depth_MINMAX, playerColor);
			
			// Algorithme minmax sur l'arbre créé : 
			elagage_minmax(depth_MINMAX, true, minmax_tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
			
			// Obtenir le coup qui maximise la fonction d'évaluation pour le joueur
			Tree best_node = minmax_tree.getBestNextNode(playerColor);
			minmax_tree = best_node;
			return minmax_tree.getMove();
		}
	}
	
	
	/*
	 * Construction d'un arbre Min Max
	 * 
	 */
	private Tree construct_minmax_tree(Coords move, int depth, CellColor node_color) {
		if(depth == 0) { // Condition d'arrêt de l'algorithme récursif
			return new Tree(move);
		}
		else {
			// Détermination de la prochaine couleur
			CellColor nextColor = (node_color == CellColor.BLACK) ? CellColor.WHITE : CellColor.BLACK;
			
			// Parcours des cellules vides autour des cellules présentes sur le plateau
			Tree tree = new Tree(move);
			for(Coords coordonnes : new ArrayList<>(board.empty_cells)) {
				board.setCellColor(coordonnes.row, coordonnes.col, node_color);
				tree.getChildrens().add(construct_minmax_tree(coordonnes, depth-1, nextColor));
				board.removeCellColor(coordonnes.row, coordonnes.col);
			}
			
			return tree;
			
		}
	}
	
	
	/*
	 * Extention d'un arbre Min Max
	 */
	private void extend_minmax_tree(Tree tree, int depth, CellColor node_color){
	    // Si on atteint la profondeur maximale, on arrête
	    if (depth == 0) {
	        return;
	    }
	    
	 // Calculer la couleur du prochain joueur
	    CellColor next_color;
        if (node_color == CellColor.WHITE) {
        	next_color = CellColor.BLACK;
        } else {
        	next_color = CellColor.WHITE;
        }
	    
	    // Si ce nœud est une feuille mais qu'on n'a pas atteint la profondeur max, on doit l'étendre (sauf fi c'est une fin de jeu)
        if(tree.getEval() == Integer.MAX_VALUE || tree.getEval() == Integer.MIN_VALUE) { // eval = valeure max ou min
        	return;
        }
        else if (tree.isLeaf()) { // Le noeud est une feuille : on l'étend
	        ArrayList<Tree> newChildren = new ArrayList<>();

	        
	        // Générer tous les coups possibles à partir de ce nœud
	        for (Coords coordonnes : new ArrayList<>(board.empty_cells)) {
	            // Jouer virtuellement le coup
	            board.setCellColor(coordonnes.row, coordonnes.col, node_color);
	            
	            // Créer l'enfant avec le nouveau coup
	            Tree child = new Tree(coordonnes);
	            
	            // Récursivement étendre cet enfant
	            extend_minmax_tree(child, depth - 1, next_color);
	            
	            // Ajouter à la liste des enfants
	            newChildren.add(child);
	            
	            // Annuler le coup
	            board.removeCellColor(coordonnes.row, coordonnes.col);
	        }
	        
	        // Assigner les enfants au nœud courant
	        tree.setChildrens(newChildren);
	    }
	    else { // Ce nœud a déjà des enfants, les étendre récursivement
	    	ArrayList<Tree> childrens = tree.getChildrens();
	        if (childrens != null) {
	            for (Tree child : childrens) {
	                // Passer au niveau suivant
	            	board.setCellColor(child.getMove().row, child.getMove().col, node_color);
	                extend_minmax_tree(child, depth - 1, next_color);
	                board.removeCellColor(child.getMove().row, child.getMove().col);
	            }
	        }
	    }
	}
	
	
	
	/*
	 * Implémentation de l'algorithme Min Max
	 * max = true si c'est au joueur de placer une pièce (false sinon)
	 * */
	private int minmax(int depth, boolean max, Tree arbre) {
		if(depth == 0 || arbre.isLeaf()) {
			int eval = board.eval_plateau();
			arbre.setEval(eval);
			return eval;
		}
		else {
			Coords move;
			if(max) { // IA
				arbre.setEval(Integer.MIN_VALUE);
				for(Tree child : arbre.getChildrens()) {
					move = child.getMove();
					board.setCellColor(move.row, move.col, playerColor);
					arbre.setEval(Math.max(arbre.getEval(), minmax(depth-1, false, child)));
					board.removeCellColor(move.row, move.col);
				}
			}
			else { // Adversaire
				CellColor opponentColor = (playerColor == CellColor.WHITE) ? CellColor.BLACK : CellColor.WHITE;
				
				arbre.setEval(Integer.MAX_VALUE);
				for(Tree child : arbre.getChildrens()) {
					move = child.getMove();
					board.setCellColor(move.row, move.col, opponentColor);
					arbre.setEval(Math.min(arbre.getEval(), minmax(depth-1, true, child)));
					board.removeCellColor(move.row, move.col);
				}
			}
			return arbre.getEval();
		}
		
	}
	
	
	/*
	 * Implémentation de l'algoritme Min Max avec élagage alpha beta
	 */
	private int elagage_minmax(int depth, boolean max, Tree arbre, int alpha, int beta) {
	    if (depth == 0 || arbre.isLeaf()) {
	        int eval = board.eval_plateau();
	        arbre.setEval(eval);
	        return eval;
	    }

	    CellColor opponentColor = (playerColor == CellColor.WHITE) ? CellColor.BLACK : CellColor.WHITE;

	    if (max) { // L'IA
	        arbre.setEval(Integer.MIN_VALUE);

	        for (Tree child : arbre.getChildrens()) {
	            Coords move = child.getMove();

	            // Jouer le coup de l'IA
	            board.setCellColor(move.row, move.col, playerColor);

	            int eval = elagage_minmax(depth - 1, false, child, alpha, beta);

	            // Annuler le coup simulé
	            board.removeCellColor(move.row, move.col);

	            arbre.setEval(Math.max(arbre.getEval(), eval));

	            // Mettre à jour alpha
	            alpha = Math.max(alpha, arbre.getEval());

	            // Élagage
	            if (alpha >= beta) {
	                break;
	            }
	        }
	    } else { // Adversaire
	        arbre.setEval(Integer.MAX_VALUE);

	        for (Tree child : arbre.getChildrens()) {
	            Coords move = child.getMove();

	            // Jouer le coup de l'adversaire
	            board.setCellColor(move.row, move.col, opponentColor);

	            int eval = elagage_minmax(depth - 1, true, child, alpha, beta);

	            // Annuler le coup simulé
	            board.removeCellColor(move.row, move.col);

	            arbre.setEval(Math.min(arbre.getEval(), eval));

	            // Mettre à jour beta
	            beta = Math.min(beta, arbre.getEval());

	            // Élagage
	            if (alpha >= beta) {
	                break;
	            }
	        }
	    }

	    return arbre.getEval();
	}
	
	
	

	
	
	
	
	

}
