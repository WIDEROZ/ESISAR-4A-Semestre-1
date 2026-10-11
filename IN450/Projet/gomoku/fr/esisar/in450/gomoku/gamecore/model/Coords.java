package fr.esisar.in450.gomoku.gamecore.model;

/**
 * Coordonnées sur le plateau de jeu
 * */
public class Coords
{
    // Numéro de ligne depuis le haut à partir de 0
    public int row;
 
    // Numéro de colonne depuis la gauche à partir de 0
    public int col;

    public Coords(){
    	row = -1;
        col = -1;
    }
    
    public Coords(Coords coords){
    	row = coords.row;
        col = coords.col;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (!(obj instanceof Coords)) {
    		return false;
        }
    	else {
    		Coords coords = (Coords) obj;

    	    return row == coords.row && col == coords.col;
    	}
    	
    }
    
    public void main(String[] args) {
    	Coords test1 = new Coords(7, 8);
    	Coords test2 = new Coords(7, 8);
    	System.out.println(test1.equals(test2));
    }

    public Coords(int row, int column)
    {
        this.row = row;
        this.col = column;
    }

    public String toString() {
    	return  "("+(row+1)+"; "+(col+1)+")";
    }
}
