import java.util.Scanner;

public class Four_in_a_row {

	static Scanner in=new Scanner(System.in);	
	
	//checks if there is 4 in a row horizontally 
	public static boolean fourRow(int mat[][], int player, int iplayed)
	{
		int i,count=0;
		for (i=0; i<mat.length && count<4; i++)
		{
			if (mat[iplayed][i]==player)
				count++;
			else
				count=0;
				
		}
		if (count==4)
			return true;
		else
			return false;
		
	}
	//checks if there is 4 in a row vertically 
	public static boolean fourColumn (int mat[][], int player, int iplayed, int jplayed)
	{
		int i, count=0;
		
		if (mat.length-iplayed<4)
			return false;
		else
			for (i=mat.length-1; i>=iplayed; i--)
			{
				if (mat[i][jplayed]==player)
					count++;
				else 
					count=0;
			}
		if (count>=4)
			return true;
		else 
			return false;
	}
	
	//checks if there is 4 in a row diagonally 
	public static boolean fourDiagonal(int mat[][], int player, int iplayed, int jplayed)
	{
		int i, newi, newj, count=0, cont=0;
		
		newi=iplayed;
		newj=jplayed;
		
		//checks up right
		while (cont!=1)
		{
			if (newi<mat.length-1 && newj<mat.length-1 && mat[newi-1][newj+1]==mat[newi][newj] && count<4)
			{
				newi--;
				newj++;
				count++;
			}
			else
			{
				newi=iplayed;
				newj=jplayed;
				cont=1;
			}
		}
		
		// checks down left
		while (cont!=0)
		{

			if (newi<mat.length-1 && newj>0 && mat[newi+1][newj-1]==mat[newi][newj] && count<4)
			{
				newi++;
				newj--;
				count++;
			}
			else
			{
				newi=iplayed;
				newj=jplayed;
				cont=0;
			}
		}

			if (count==3)
				return true;

			cont=0;
			count=0;
			
			//checks up left
			while (cont!=1)
			{
				if (newi>0 && newj>0 && mat[newi-1][newj-1]==mat[newi][newj] && count<4)
				{
					newi--;
					newj--;
					count++;
				}
				else
				{
					newi=iplayed;
					newj=jplayed;
					cont=1;
				}
			}
			
			// checks down right
			while (cont!=0)
			{

				if (newi<mat.length-1 && newj<mat.length-1 && mat[newi+1][newj+1]==mat[newi][newj] && count<4)
				{
					newi++;
					newj++;
					count++;
				}
				else
					cont=0;
			}

				if (count==3)
					return true;
				else
					return false;
	}
	static void print (int mat[][])
	{
		for (int i=0; i<mat.length; i++)
		{
			for (int j=0; j<mat.length; j++)
			{
				System.out.printf
				("%3d" ,mat[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static void playGame()
	{
		int player = 1, playCol, line = 0, rightLine=0, go=1, found=0;
		int[][] mat = new int [8][8];
		
		while (go!=0)
		{

			found=0;
			line=mat.length-1;
			System.out.println("player "+player+" turn");
			print(mat);
			
			//player puts in the number of the column he wants to fill
			playCol=in.nextInt()-1;
			
			//finds the lowest empty place
			for (int i=0; i<mat.length && found!=1; i++)
			{
				if (mat[line-i][playCol]==0)
				{
					mat[line-i][playCol]=player;
					rightLine=line-i;
					found=1;
				}
			}
			//chaecks if player did 4 in a row
			if (fourRow(mat,player,rightLine)==true || fourColumn(mat,player,rightLine, playCol)==true || fourDiagonal(mat, player, rightLine, playCol)==true)
			{
				System.out.println("player="+player+"  line="+rightLine);
				System.out.println("wow!!!! player "+player+" won");
				go=0;
			}

			
			//switching players
			else
			{
				if (player==1)
					player=2;
				else 
					player=1;
			}
		}
			
	}
	public static void main(String[] args) {
		playGame();
	}
}
