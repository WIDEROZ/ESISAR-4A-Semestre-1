package fr.esisar.in450.gomoku.gamecore.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.esisar.in450.gomoku.gamecore.enums.CellColor;
import fr.esisar.in450.gomoku.gamecore.enums.WinnerState;

/**
 * Modelisation d'un plateau de Gomoku
 * 
 * Un plateau de Gomuku est composé de SIZE * SIZE cellules (cells)
 * 
 * Chaque cellule est soit vide (null) , soit d'une couleur (CellColor)  
 */
public class GomokuBoard 
{
    // Taille du plateau
    public final int SIZE = 15;
    
    // Indice 0 : la ligne 
    // Indice 1 : la colonne
    public CellColor [][] cells;
    
    
    
    

    /**
     * Création d'un plateau de Gomoku vide
     * Toutes les cellules sont vides (null)  
     */
    public GomokuBoard()
    {
        cells = new CellColor[SIZE][SIZE];
    }
    
    /**
     * Permet d'ajouter une pierre sur le plateau 
     * 
     * Pour enlenver une pierre, mettre CellColor à null
     */
	public void setCellColor(int row, int col, CellColor cellColor)
	{
		cells[row][col] = cellColor;
	}
	
	/** 
	 * Permet de connaitre la couleur d'une case du plateau
	 * Retourne null si la case est vide ou out of range
	 */ 
	public CellColor getCellColor(int row, int col)
	{
		if (0 <= row && row < SIZE && 0<= col && col < SIZE) {
			return cells[row][col];
		}
		else {
			System.err.println("Out of range getCellColor");
			return null;
		}
		
	}
	
	/**
	 * Retourne true si toutes les cellules sont vides
	 */
	public boolean isEmpty()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				if (cells[i][j]!=null)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Retourne true si au moins une cellule est vide
	 */
	public boolean hasAnEmptyCell()
	{
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				if (cells[i][j]==null)
				{
					return true;
				}
			}
		}
		return false;
	}
	


    /**
     * Obtenir l'état du plateau
     */
    public WinnerState getWinnerState()
    {
    	// Test des lignes 
		for (int i = 0; i < SIZE; i++)
		{
			WinnerState winner = hasWinner(getLine(i));
			if (winner!=null)
			{
				return winner;
			}
		}
		
		// Test des colonnes 
		for (int i = 0; i < SIZE; i++)
		{
			WinnerState winner = hasWinner(getColonne(i));
			if (winner!=null)
			{
				return winner;
			}
		}
		
		// Test des diagonales ↘
		List<String> diags = getAllDiagDesc();
		for (String diag : diags)
		{
			WinnerState winner = hasWinner(diag);
			if (winner!=null)
			{
				return winner;
			}
		}
		
		// Test des diagonales ↗   
		diags = getAllDiagAsc();
		for (String diag : diags)
		{
			WinnerState winner = hasWinner(diag);
			if (winner!=null)
			{
				return winner;
			}
		}

		
		// Test du tie
		if (hasAnEmptyCell()==false)
		{
			return WinnerState.TIE;
		}
		else
		{
			return WinnerState.NONE;	
		}
    }

	private String getLine(int i)
	{
    	StringBuilder sb = new StringBuilder();
		for (int j = 0; j < SIZE; j++)
		{
			sb.append(getCellAsString(i,j));
		}
		return sb.toString();
	}
	
	private String getColonne(int j)
	{
    	StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; i++)
		{
			sb.append(getCellAsString(i,j));
		}
		return sb.toString();
	}
	
	private List<String> getAllDiagDesc()
	{
		List<String> res = new ArrayList<String>(); 
		
		// Les diagonales ↘ partant de l'axe horizontal du haut 
		for (int len = 5; len <= SIZE; len++)
		{
			res.add(getDiag(len, 0, SIZE-len, 1, 1));
		}
		
		// Les diagonales ↘ partant de l'axe vertical de gauche
		for (int len = 5; len <= SIZE-1; len++)
		{
			res.add(getDiag(len, SIZE-len, 0 , 1, 1));
		}

		return res;
	}
	
	private List<String> getAllDiagAsc()
	{
		List<String> res = new ArrayList<String>(); 
		
		// Les diagonales ↗ partant de l'axe horizontal du bas  
		for (int len = 5; len <= SIZE; len++)
		{
			res.add(getDiag(len, SIZE-1, SIZE-len, -1, 1));
		}
		
		// Les diagonales ↗ partant de l'axe vertical de gauche 
		for (int len = 5; len <= SIZE-1; len++)
		{
			res.add(getDiag(len, len-1, 0 , -1, 1));
		}

		return res;
	}

	private String getDiag(int len,int startRow,int startCol,int dx,int dy)
	{
    	StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < len; i++)
		{
			sb.append(getCellAsString(startRow+dx*i,startCol+dy*i));
		}
		return sb.toString();
	}	
	
	
	private String getCellAsString(int i, int j)
	{
		CellColor cellColor = getCellColor(i, j);
		
		if (cellColor==null)
		{
			return " ";
		}
		else if (cellColor==CellColor.BLACK)
		{	
				return "B";
		}
		else if (cellColor==CellColor.WHITE)
		{
			return "W";
		}
		else
		{
			throw new RuntimeException();
		}
	}

	private WinnerState hasWinner(String st)
	{
		if (st.indexOf("WWWWW")!=-1)
		{
			return WinnerState.WHITE;
		}
		
		if (st.indexOf("BBBBB")!=-1)
		{
			return WinnerState.BLACK;
		}
		return null;	
	}
	
	
	
	
	
	
	/**
	 * Fonction d'évaluation du plateau
	 */
	public int eval_plateau() {
		int len = this.SIZE;
		int i,j;
		for(i = 0; i < len; i++) {
			for(j=0; j<len; j++) {
				if(this.getCellColor(i, j) == CellColor.WHITE) {
					
				}
				else if(this.getCellColor(i, j) == CellColor.BLACK){
					
				}	
			}
		}
		
		return 0;
	}
	
	/**
	 * Compte depuis un plateau le nombre de positions de x pions allignés ouvert
	 * Paramètre : 
	 * GomokuBoard plateau : plateau sur lequel trouver les position alignés
	 * 
	 * Renvoie un int[][][]
	 * tab[0][][] : ouvert
	 * tab[1][][] : semi-ouvert
	 * tab[][0][] : Noirs
	 * tab[][1][] : Blancs
	 * tab[][][0] : Nombre de groupes de pions alignés par deux
	 * tab[][][1] : Nombre de groupes de pions alignés par trois
	 * tab[][][2] : Nombre de groupes de pions alignés par quatre
	 * tab[][][3] : Nombre de groupes de pions alignés par cinq
	 * 
	 */
	private int[][][] detect_schema(GomokuBoard plateau) throws Exception{
		int[][][] ret = {{{0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}}};
		
		// Parcours Ligne
		int i;
		String motif;
		for(i = 0; i < SIZE; i++) {
			motif = getLine(i);
			parcours_motif(ret, motif);
		}
		
		
		
		return ret;
	}
	
	public static void main(String[] args) {
		int[][][] ret = {{{0, 0, 0, 0}, {0, 0, 0, 0}}, {{0, 0, 0, 0}, {0, 0, 0, 0}}};
		GomokuBoard bo = new GomokuBoard();
		try {
			bo.parcours_motif(ret, "BB WW BBBB");
		}
		catch (Exception e) {
			System.err.println("Exception : " + e);
		}
		
		
		
		System.out.println("                  Black         White");
		
		
		int i, j, k;
		for(i=0; i<2; i++) {
			if(i == 0) {
				System.out.print("   Ouvert   : ");
			}
			else{
				System.out.print("Semi-ouvert : ");
			}
			for(j=0; j<2; j++) {
				for(k=0; k<4; k++) {
					if (k == 0) {
						System.out.print("[" + ret[i][j][k] + ", ");
					}
					else if(k != 3) {
						System.out.print(ret[i][j][k] + ", ");
					}
					else {
						System.out.print(ret[i][j][k] + "]");
					}
				}
				if(j == 0) {
					System.out.print(", ");
				}
				else {
					System.out.println("");
				}
			}
		}
		
		
	}
	

	
	
	private void parcours_motif(int[][][] ret, String motif) throws Exception{
		char elt, prev_elt;
		int i, count_motif;
		boolean open = false;
		
		int len = motif.length();
		prev_elt = motif.charAt(0);
		
		if(prev_elt == ' ') {
			count_motif = 0;
		}
		else {
			count_motif = 1;
		}
		
		
		for(i = 1; i < len; i++) {
			elt = motif.charAt(i);
			
			if(elt == ' ') {
				if(count_motif > 1) {
					if (prev_elt == 'W') {
						if(open) {
							ret[0][1][count_motif-2]++;
						}
						else {
							ret[1][1][count_motif-2]++;
						}
					}
					else if(prev_elt == 'B') {
						if(open) {
							ret[0][0][count_motif-2]++;
						}
						else {
							ret[1][0][count_motif-2]++;
						}
					}
					else {
						System.err.println("Index : " + i);
						System.err.println("Motif : " + motif);
						throw new Exception("Motif != '...W ' or '...B '");
					}
				}
				count_motif = 0;
				open = true;
			}
			else if(i == len-1) {
				if(elt == 'W') { // "...W"
					if(prev_elt == elt) { // "..WW"
						count_motif++;
						if (open) { // " W..WW"
							ret[1][1][count_motif-2]++;
						}
					}
				}
				else if(elt == 'B') { // "...B"
					if(prev_elt == elt) { // "..BB"
						count_motif++;
						if (open) { // " B..BB"
							ret[1][0][count_motif-2]++;
						}
					}
				}
			}
			else {
				if(elt == 'W') {
					if(prev_elt == elt) { // "..WW"
						count_motif++;
					}
					else if(prev_elt == 'B') { // "..BW"
						if(count_motif > 1) { // "..BBW"
							if (open) { // " B...BBW"
								ret[1][0][count_motif-2]++;
							}
						}
						count_motif = 1;
						open = false;
					}
					else if(prev_elt == ' ') { // " W"
						count_motif = 1;
						open = true;
					}
				}
				else if(elt == 'B') {
					if(prev_elt == elt) { // "..BB"
						count_motif++;
					}
					else if(prev_elt == 'W') { // "..WB"
						if(count_motif > 1) { // "..WWB"
							if (open) {  // " W..WWB"
								ret[1][1][count_motif-2]++;
							}
						}
						count_motif = 1;
						open = false;
					}
					else if(prev_elt == ' ') { // " B"
						count_motif = 1;
						open = true;
					}
				}
			}
			
			
			prev_elt = elt;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
     * Affichage du plateau à l'écran 
     */
    public void print()
    {
    	System.out.print("   ");
		for (int i = 0; i < SIZE; i++)
		{
			System.out.print(String.format("%02d ", i+1)); // Afficher le numéro des colonnes
		}
		System.out.println();
		for (int i = 0; i < SIZE; i++)
		{
			System.out.print(String.format("%02d ", (i+1))); // Afficher le numéro de la ligne
			for (int j = 0; j < SIZE; j++)
			{
				displayCell(cells[i][j]);
			}
			System.out.println();
		}
    }
    
    
	private void displayCell(CellColor cellColor)
	{			
		if (cellColor==null)
		{
			System.out.print("-  "); //
		}
		else if (cellColor==CellColor.BLACK)
		{	
				System.out.print("B  "); // ■
		}
		else if (cellColor==CellColor.WHITE)
		{
			System.out.print("W  "); // □
		}
		else
		{
			throw new RuntimeException();
		}
	}
	
	
	static public GomokuBoard fromString(String in)
	{
		GomokuBoard board = new GomokuBoard();  
		String[] ls = in.split("\n");
		for (int i = 0; i < ls.length; i++)
		{
			String s = ls[i];
			for (int j = 0; j < s.length(); j++)
			{
				char c = s.charAt(j);
				if (c=='W')
				{
					board.setCellColor(i, j, CellColor.WHITE);
				}
				if (c=='B')
				{
					board.setCellColor(i, j, CellColor.BLACK);
				}
			}
		}
		return board;
	}
}

