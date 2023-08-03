import java.util.Scanner;

public class Fifteen_Puzzle {
	
	// find empty place
	static int emptyi(int mat[][])
	{
		int i, j;
		for ( i=0;i<mat.length-1; i++)
			for ( j=0; j<mat.length-1; j++)
			{
				if (mat[i][j]==0)
					break;
			}
		return i;
	}
	
	static int emptyj(int mat[][])
	{
		int i, j = 0;
		for ( i=0;i<mat.length-1; i++)
			for ( j=0; j<mat.length-1; j++)
			{
				if (mat[i][j]==0)
					break;
			}
		return j;
	}
	
	static void print (int mat[][])
	{
		for (int i=0; i<mat.length; i++)
		{
			for (int j=0; j<mat.length; j++)
			{
				System.out.printf
				("%4d" ,mat[i][j]);
			}
			System.out.println();
		}
	}
	static boolean isOrder (int mat[][])
	{
		int count=1;
		{
			for (int i=0; i<mat.length; i++)
				for (int j=0; j<mat.length; j++)
				{
					if (mat[i][j]!=count)
						return false;
					if (count==15)
						break;
					count++;
				}
		}	
		return true;
	}
	static void move(int puzzle[][])
	{
		int temp=0, end=0, emptyi = 0, emptyj = 0;
		Scanner in=new Scanner(System.in);
		emptyi=emptyi(puzzle);
		emptyj=emptyj(puzzle);
		print(puzzle);
		System.out.println("press 1 for up | 2 for right | 3 for down | 4 for left: ");
		while (end!=1)
		{
			int digit=in.nextInt();

			//go up a line
			if (digit==1 && emptyi!=0)
			{
				temp=puzzle[emptyi-1][emptyj];
				puzzle[emptyi-1][emptyj]=puzzle[emptyi][emptyj];
				puzzle[emptyi][emptyj]=temp;
				emptyi=emptyi-1;
				
			}
			//go to the right
			else if (digit==2 && emptyj!=puzzle.length-1)
			{
				temp=puzzle[emptyi][emptyj+1];
				puzzle[emptyi][emptyj+1]=puzzle[emptyi][emptyj];
				puzzle[emptyi][emptyj]=temp;
				emptyj=emptyj+1;
			}
			//go down a line
			else if (digit==3 && emptyi!=puzzle.length-1)
			{
				temp=puzzle[emptyi+1][emptyj];
				puzzle[emptyi+1][emptyj]=puzzle[emptyi][emptyj];
				puzzle[emptyi][emptyj]=temp;
				emptyi=emptyi+1;
			}
			//go left
			else if (digit==4 && emptyj!=0)
			{
				temp=puzzle[emptyi][emptyj-1];
				puzzle[emptyi][emptyj-1]=puzzle[emptyi][emptyj];
				puzzle[emptyi][emptyj]=temp;
				emptyj=emptyj-1;
			}
			else 
				System.out.println("---not valid. try again---");
			
			if (isOrder(puzzle)==true)
				end=1;
			print(puzzle);
			System.out.println("press 1 for up | 2 for right | 3 for down | 4 for left: ");
		}

		System.out.println("---you did it!!---great job!!---");

	}
	public static void main(String[] args) {

		int[][] puzzle = {{1,2,3,4}, {5,7,6,8},{9,10,11,12},{13,14,15,0}};
		int[][] puzzle1 = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,0}};

		move(puzzle1);
		

	}

}
