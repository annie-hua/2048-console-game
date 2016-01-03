/******************************************************************************
 *
 * Filename :     game2048.java.
 * Author:        Annie Hua
 * Date:          10/9/2015
 * Description:   Play the 2048 game on the console and move the tiles with the key 'w','s','a', and 'd'
 *
 ******************************************************************************/
import java.util.Scanner;
import java.util.Random;

//'w', 's', 'a', 'd' are keys to move the tiles
public class game2048 {
	//add  new Static Scanner named scan
	//add  String array tilein
	//add  String array array tile
	//add  int i, j, k, l, twoorfour1, twoorfour2
	//add  Random named ran
	static Scanner scan = new Scanner(System.in);
	static String [] tilein;
	static String [][] tile;
	static game2048 op = new game2048();
	static int i,j,k,l,twoorfour1,twoorfour2;
	static Random ran;
	
	//method to print the board by loop(have to put the String array array )
	public void board(String[][]bo){
		System.out.println(" ______ ______ ______ ______");
		for(int i = 0; i<4; i++){
			System.out.println("|      |      |      |      |");
			for(int j = 0; j<4; j++ ){
				//the loop will make i=0 and j run up from 0 to 3 then add i+1 until i=3 and j=3 
				System.out.print("|"+bo[i][j]);
			}
			System.out.print("|");
			System.out.println();
			System.out.println("|______|______|______|______|");
		}

	}
	//method to move left, right, up, and down. use loop to run up the tile and use the other loop to run back(check) if can 	//move the tile
	//method move left
	public void moveleft (){
		for (int x=0; x<4;x++){
			for (int y= 1; y<4&&y>-1; y++){
				i=x;
				j=y;	
				int a = 0;
				//loop for check back
				for(int z=0;j>0&&z==0;j--){
					if(tile[i][j-1]==tilein[0]&&tile[i][j]!=tilein[0]){
						tile[i][j-1]=tile[i][j];
						tile[i][j]=tilein[0];
					}
					else if(tile[i][j-1]==tile[i][j]&&tile[i][j]!=tilein[0]){
						a = indexOf(tilein,tile[i][j]);
						tile[i][j-1]=tilein[a+1];
						tile[i][j]=tilein[0];
						z=1;
					}
					else if(tile[i][j-1]!=tilein[0]&&tile[i][j]!=tile[i][j-1]&&tile[i][j]!=tilein[0]){
						z=1;
					}

					else if(tile[i][j]==tilein[0]){
						z=1;
					}
				}
			}
		}
				
	}	
	//method move right
	public void moveright (){
		for (int x=0; x<4;x++){
			for (int y= 2; y<3&&y>-1; y--){
				i=x;
				j=y;	
				int a = 0;
				//loop for check back
				for(int z=0;j>-1&&z==0&&j<3;j++){
					if(tile[i][j+1]==tilein[0]&&tile[i][j]!=tilein[0]){
						tile[i][j+1]=tile[i][j];
						tile[i][j]=tilein[0];
					}
					else if(tile[i][j+1]==tile[i][j]&&tile[i][j]!=tilein[0]){
						a = indexOf(tilein,tile[i][j]);
						tile[i][j+1]=tilein[a+1];
						tile[i][j]=tilein[0];
						z=1;
					}
					else if(tile[i][j+1]!=tilein[0]&&tile[i][j]!=tile[i][j+1]&&tile[i][j]!=tilein[0]){
						z=1;
					}

					else if(tile[i][j]==tilein[0]){
						z=1;
					}
				}
			}
		}
				
	}	
	//method moveup
	public void moveup (){
		for (int y=0; y<4;y++){
			for (int x= 1; x<4&&x>-1; x++){
				i=x;
				j=y;	
				int a = 0;
				//loop for check back
				for(int z=0;i>0&&z==0;i--){
					if(tile[i-1][j]==tilein[0]&&tile[i][j]!=tilein[0]){
						tile[i-1][j]=tile[i][j];
						tile[i][j]=tilein[0];
					}
					else if(tile[i-1][j]==tile[i][j]&&tile[i][j]!=tilein[0]){
						a = indexOf(tilein,tile[i][j]);
						tile[i-1][j]=tilein[a+1];
						tile[i][j]=tilein[0];
						z=1;
					}
					else if(tile[i-1][j]!=tilein[0]&&tile[i][j]!=tile[i-1][j]&&tile[i][j]!=tilein[0]){
						z=1;
					}

					else if(tile[i][j]==tilein[0]){
						z=1;
					}
				}
			}
		}
				
	}	
	//method move down
	public void movedown (){
		for (int y=3; y>-1;y--){
			for (int x= 2; x>-1; x--){
				i=x;
				j=y;	
				int a = 0;
				//loop for check back
				for(int z=0;i<3&&z==0;i++){
					if(tile[i+1][j]==tilein[0]&&tile[i][j]!=tilein[0]){
						tile[i+1][j]=tile[i][j];
						tile[i][j]=tilein[0];
					}
					else if(tile[i+1][j]==tile[i][j]&&tile[i][j]!=tilein[0]){
						a = indexOf(tilein,tile[i][j]);
						tile[i+1][j]=tilein[a+1];
						tile[i][j]=tilein[0];
						z=1;
					}
					else if(tile[i+1][j]!=tilein[0]&&tile[i][j]!=tile[i+1][j]&&tile[i][j]!=tilein[0]){
						z=1;
					}

					else if(tile[i][j]==tilein[0]){
						z=1;
					}
				}
			}
		}
				
	}	
	//method to run up the int from 0 and return the value when it was same with the String array
	public int indexOf(String[] array, String element){
		for(int i=0;i<array.length;i++){
			if(array[i].equals(element)){
				return i;
			}
		}
		return 0;
	}
	//method to add the random tile
	public void addrandom(){
		ran = new Random();
		i=ran.nextInt(4);
		j=ran.nextInt(4);
		boolean x=false;
		//use loop to check if random on the tile that already have a number will random the new one
		while(x==false){	
			if(tile[i][j]!=tilein[0]){
				i=ran.nextInt(4);
				j=ran.nextInt(4);		
			}
			else{
			x=true;}
			
			}
		// this random us for the chance 80% to get2 20% to get 4 
		//create the value from0-3
		twoorfour1=ran.nextInt(4);
		twoorfour2=ran.nextInt(4);
		//when this condition the new tile will be 2
		if(twoorfour1<3){
			tile[i][j]=tilein[1];
		}
		//when this condition the new tile will be 4
		else if(twoorfour1==3){
			tile[i][j]=tilein[2];
		}
		}
	//loop for check if the board full use the boolean to check it use break for skip to the new one if the condition was true
	public void boardfull(){
	boolean nospace = true;
	boolean column = true;
	boolean row = true;
	//check for space left
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				if(tile[i][j]==tilein[0]){
					nospace = false;
					break;
				}
			}
			}
		
	//check for column
		for(i=0;i<4;i++){
			for(j=0;j<3;j++){
				if(tile[i][j]==tile[i][j+1]){
					column = false;
					break;
				}
			}
			}
	//check for  row	
		for(i=0;i<3;i++){
			for(j=0;j<4;j++){
				if(tile[i][j]==tile[i+1][j]){
					row = false;
					break;
				}
			}
			}
	// check if nospace left can't cobined the tile in column or row then print You Lose	
	if(nospace&&column&&row==true){
		System.out.println("You Lose");
	}
	}
	// use this one to connect the method moveleft,right,up,down with console by input 'w' for move up 's' for movedown 'a' for moveleft 'd' formovrright
	public void movement(char move){
		if(move=='w'){
			op.moveup();
		}
		else if(move=='s'){
			op.movedown();
		}
		else if(move=='a'){
			op.moveleft();
		}
		else if(move=='d'){
			op.moveright();
		}
	}
	//main
	public static void main(String[] args){
		//asked for start the game
		System.out.println(" ___________________________");
		System.out.println("|     2 0 4 8   G A M E     |");
		System.out.println(" ---------------------------");
		System.out.println(" ______ ______ ______ ______");
		System.out.println("|      |      |      |      |");
		System.out.println("|  2   |  0   |  4   |  8   |");
		System.out.println("|______|______|______|______|");
		System.out.println("|      |      |      |      |");
		System.out.println("|  0   |      |      |  4   |");
		System.out.println("|______|______|______|______|");
		System.out.println("|      |      |      |      |");
		System.out.println("|  4   |      |      |  0   |");
		System.out.println("|______|______|______|______|");
		System.out.println("|      |      |      |      |");
		System.out.println("|  8   |  4   |  0   |  2   |");
		System.out.println("|______|______|______|______|");
		System.out.println("To Start press 1 other exit");
		int u =scan.nextInt();
		//if scan u and u=1 start the game
		while(u==1){
		//new Random named ran
		ran = new Random();
		//random int i, j, k, l, twoorfour 1 and twoorfour2 the value was 0-3
		i=ran.nextInt(4);
		j=ran.nextInt(4);
		k=ran.nextInt(4);
		l=ran.nextInt(4);
		twoorfour1=ran.nextInt(4);
		twoorfour2=ran.nextInt(4);
		// this loop use to random new set of [i][j]and[k][l] if the value just the same
		for(int x=0;x==0;){	
			if(i==k&&j==l){
				i=ran.nextInt(4);
				j=ran.nextInt(4);
				k=ran.nextInt(4);
				l=ran.nextInt(4);
			}
			else{
				x=1;
			}
		}
		//the value of tilein
		tilein = new String [12];
		tilein[0] = "      ";
		tilein[1] = " "+" 2  "+" ";
		tilein[2] = " "+" 4  "+" ";
		tilein[3] = " "+" 8  "+" ";
		tilein[4] = "  16 "+" "; 
		tilein[5] = "  32 "+" ";
		tilein[6] = "  64 "+" ";
		tilein[7] = "  128 ";
		tilein[8] = "  256 ";
		
		tilein[9] = "  512 ";
		tilein[10] = " 1024 ";
		tilein[11] = " 2048 ";

		tile = new String[4][4];
		//this loop start all tile empty
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				tile[i][j] = tilein[0];
			}
		}
		//this one use to change the 2 tiles to be 2 or 4 by80:20 chance
		if(twoorfour1<3){
			tile[i][j]=tilein[1];
		}
		else if(twoorfour1==3){
			tile[i][j]=tilein[2];
		}
		if(twoorfour2<3){
			tile[k][l]=tilein[1];
		}
		else if(twoorfour2==3){
			tile[k][l]=tilein[2];
		}
		//print board
		op.board(tile);
		//if game still run
		while(u==1){
		// create new char = next scan	
		char moving = scan.next(".").charAt(0);
		//move the tile
		op.movement(moving);
		//respawn new number
		op.addrandom();
		//print board
		op.board(tile);
		//check if board full
		op.boardfull();
		}
		// when board full ask to change the value of u to restart or exit
		System.out.println("play again press 1 other exit");
		u =scan.nextInt();
	}

}
}
