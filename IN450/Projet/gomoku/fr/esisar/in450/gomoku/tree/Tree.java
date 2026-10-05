package fr.esisar.in450.gomoku.tree;

import java.util.ArrayList;
import fr.esisar.in450.gomoku.gamecore.model.Coords;
import fr.esisar.in450.gomoku.gamecore.model.GomokuBoard;


public class Tree {
	private Coords move;
	private int eval;
	private ArrayList<Tree> childrens;
	
	public Tree() {
		move = null;
		eval = 0;
		childrens = null;
	}
	
	public Tree(Coords move) {
		this.move = move;
		this.eval = 0;
		childrens = null;
	}
	
	public Tree(Coords move, int eval) {
		this.move = move;
		this.eval = eval;
		childrens = null;
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
	
	
	
	
	public boolean isLeaf() {
		if(childrens == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* 
	 * Get the next node of the tree regarding the move
	 */
	public Tree getNextNode(Coords move) {
		for(Tree child : childrens) {
			if(!child.isLeaf()) {
				if(child.getMove() == move) {
					return child;
				}
			}
		}
		return null;
	}

	
	
}
