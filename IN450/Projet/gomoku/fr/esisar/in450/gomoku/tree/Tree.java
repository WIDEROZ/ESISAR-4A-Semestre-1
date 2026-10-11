package fr.esisar.in450.gomoku.tree;

import java.util.ArrayList;
import fr.esisar.in450.gomoku.gamecore.enums.CellColor;
import fr.esisar.in450.gomoku.gamecore.model.Coords;


public class Tree {
	private Coords move;
	private int eval;
	private ArrayList<Tree> childrens;
	
	public Tree() {
		move = null;
		eval = 0;
		childrens = new ArrayList<Tree>();
	}
	
	public Tree(Coords move) {
		this.move = move;
		this.eval = 0;
		childrens = new ArrayList<Tree>();
	}
	
	public Tree(Coords move, int eval) {
		this.move = move;
		this.eval = eval;
		childrens = new ArrayList<Tree>();
	}
	
	public Tree(Coords move, int eval, ArrayList<Tree> childrens) {
		this.move = move;
		this.eval = eval;
		this.childrens = childrens;
	}

	public Coords getMove() {
		return move;
	}

	public void setMove(Coords move) {
		this.move = move;
	}
	

	public int getEval() {
		return eval;
	}

	public void setEval(int eval) {
		this.eval = eval;
	}

	public ArrayList<Tree> getChildrens() {
		return childrens;
	}

	public void setChildrens(ArrayList<Tree> childrens) {
		this.childrens = childrens;
	}
	
	
	public void removeChildren(Coords move) {
		Tree node_to_remove = getNextNode(move);
		childrens.remove(node_to_remove);
	}
	
	
	
	public boolean isLeaf() {
		if(childrens == null) {
			return true;
		}
		else {
			if(childrens.isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	/* 
	 * Get the next node of the tree regarding the move
	 */
	public Tree getNextNode(Coords move) {
		if (move == null) {
			System.err.println("getNextNode : move is null");
			return null;
		}
		else if(childrens == null) {
			System.err.println("getNextNode : childrens is null");
			return null;
		}
		else if(childrens.isEmpty()) {
			System.err.println("getNextNode : childrens is empty ");
			return null;
		}
		
		
		for (Tree child : childrens) {
		    if (child != null) {
		    	if(move.equals(child.getMove())) {
		    		return child;
		    	}
		    }
		    else {
				System.err.println("getNextNode : child is null");
			}
		}
		
		return null;
	}
	
	
	public Tree getBestNextNode(CellColor playerColor) {
	    if (childrens == null) {
	        return null;
	    }
	    else if (childrens.isEmpty()) {
	    	return null;
	    }

	    Tree bestNode = null;
	    
	    // Prendre le maximum ou le minimum de la variable eval d'une node
	    boolean maximize;
	    int eval;
	    if(playerColor == CellColor.BLACK) {
	    	maximize = true;
	    	eval = Integer.MIN_VALUE;
	    }
	    else {
	    	maximize = false;
	    	eval = Integer.MAX_VALUE;
	    }
	    
	    // Rechercher le meilleur coup
	    int child_eval;
	    for (Tree child : childrens) {
	    	child_eval = child.getEval();
	    	if(maximize) {
	    		if(eval < child_eval) {
	    			eval = child_eval;
	    			bestNode = child;
	    		}
	    	}
	    	else {
	    		if(eval > child_eval) {
	    			eval = child_eval;
	    			bestNode = child;
	    		}
	    	}
	    }

	    return bestNode;
	}
	
	public void displayTree(int depth) {
	    displayTree("", true, depth);
	}

	private void displayTree(String prefix, boolean isLast, int depth) {
	    if(depth == 0) {
	    	return;
	    }
	    else {
	    	// Afficher le nœud actuel
		    System.out.println(prefix
		            + (isLast ? "└── " : "├── ")
		            + "Tree (move=" + move
		            + ", eval=" + eval + ")");

		    if (childrens == null || childrens.isEmpty()) {
		        return;
		    }

		    // Préparer le préfixe pour les enfants
		    String childPrefix = prefix + (isLast ? "    " : "│   ");

		    for (int i = 0; i < childrens.size(); i++) {
		        Tree child = childrens.get(i);

		        if (child != null) {
		            boolean lastChild = (i == childrens.size() - 1);
		            child.displayTree(childPrefix, lastChild, depth-1);
		        }
		    }
	    }
	}

	
	
}
