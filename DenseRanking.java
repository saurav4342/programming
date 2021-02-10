package project1;

/**
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Akash Pandey
 *
 */
public class DenseRanking {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of players:");
		int noPlayers = Integer.parseInt(br.readLine());

		int[] scoreBoard = new int[noPlayers];
		System.out.println("Enter the scores in descending order:");
		for (int i = 0; i < noPlayers; i++) {
			scoreBoard[i] = Integer.parseInt(br.readLine());
		}

		System.out.println("Enter the number of games Alice played:");
		int noOfGames = Integer.parseInt(br.readLine());

		System.out.println("Enter the Alice's scores in descending order:");
		int[] aliceScoreBoard = new int[noOfGames];
		for (int i = 0; i < noOfGames; i++) {
			aliceScoreBoard[i] = Integer.parseInt(br.readLine());
		}
		
		DenseRanking dr = new DenseRanking();
		int[][] aliceRanks = dr.setAliceRank(aliceScoreBoard, scoreBoard);
		for(int i=0;i<noOfGames;i++) {
			System.out.println(aliceRanks[i][1]);
		}
	}

	private int[][] setRankForMainBoard(int[] scoreBoard) {

		int[][] ranking = new int[scoreBoard.length][2];
		for (int i = 0; i < scoreBoard.length; i++) {
			ranking[i][0] = scoreBoard[i];
		}

		ranking[0][1] = 1;

		for (int i = 1; i < scoreBoard.length; i++) {
			if (ranking[i][0] == ranking[i - 1][0]) {
				ranking[i][1] = ranking[i - 1][1];
			} else if (ranking[i][0] < ranking[i - 1][0]) {
				ranking[i][1] = ranking[i - 1][1] + 1;
			}

		}

		return ranking;
	}
	
	private void insertAliceScore(int[] scoreBoard,int aliceScore) {
		
		int i;
	      for(i=0;i<scoreBoard.length-1;i++){
	        if(scoreBoard[i]<aliceScore)
	          break;
	      }
	      for(int k=scoreBoard.length-2; k>=i; k--){
	    	  scoreBoard[k+1]=scoreBoard[k];            
	      }
	      scoreBoard[i]=aliceScore;

	}

	private int[][] setAliceRank(int[] aliceScoreBoard, int[] scoreBoard) {

		int[][] aliceRanking = new int[aliceScoreBoard.length][2];
		int[][] otherRanking = setRankForMainBoard(scoreBoard);
		for (int i = 0; i < aliceScoreBoard.length; i++) {
			aliceRanking[i][0] = aliceScoreBoard[i];
			System.out.println("Alice score::"+aliceScoreBoard[i]);
			System.out.println("high score::"+otherRanking[0][0]);
			System.out.println("low score::"+otherRanking[scoreBoard.length - 1][0]);
			if (aliceScoreBoard[i] >= otherRanking[0][0]) {
				aliceRanking[i][1] = 1;
			} else if (aliceScoreBoard[i] == otherRanking[scoreBoard.length - 1][0]) {
				aliceRanking[i][1] = otherRanking[scoreBoard.length - 1][1];
			} else if (aliceScoreBoard[i] < otherRanking[scoreBoard.length - 1][0]) {
				aliceRanking[i][1] = otherRanking[scoreBoard.length - 1][1] + 1;
			} else {
				 int[] finalScoreBoardTemp = new int[scoreBoard.length+1];
				 for(int j=0;j<scoreBoard.length;j++) {
					 finalScoreBoardTemp[j] = scoreBoard[j];
				 }
				 
				 insertAliceScore(finalScoreBoardTemp,aliceScoreBoard[i]);
				 for(int j=0;j<finalScoreBoardTemp.length;j++) {
					 System.out.println("score board for alice score:"+finalScoreBoardTemp[j]);
				 }
				 int[][] tempRanking =setRankForMainBoard(finalScoreBoardTemp);
				 
				 for(int k=0;k<finalScoreBoardTemp.length;k++) {
					 System.out.println(tempRanking[k][0]+" "+tempRanking[k][1]);
				 }
				 
					 for(int j=0;j<finalScoreBoardTemp.length;j++) {
						 if(tempRanking[j][0] == aliceScoreBoard[i]) {
							 aliceRanking[i][1] = tempRanking[j][1];
							 System.out.println("Alice rank 1::"+aliceRanking[i][1]);
						 }
					 }
				 
				 
			}
		}
		
		return aliceRanking;
	}
}



