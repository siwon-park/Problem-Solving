// 스도쿠 (2239번)
import java.io.*;

public class Main {
	
	static String[] sudoku = new String[9];
	static boolean isFinish = false;
	static int[][] answer = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	
	static void backtrack(int r, int c) {
		if (isFinish) {
			return;
		}
		if (r >= 9) {
			isFinish = true;
	        for (int i = 0; i < 9; i++) {
	        	for (int j = 0; j < 9; j++) {
	        		sb.append(answer[i][j]);
	        	}
	        	sb.append("\n");
	        }
			return;
		}
		
		if (answer[r][c] == 0) {
			for (int k = 1; k < 10; k++) {
				if (check(r, c, k) && !isFinish) {
					answer[r][c] = k;
					backtrack(r + ((c + 1) / 9), (c + 1) % 9); // 다음 행, 열을 탐색
					answer[r][c] = 0;					
				}
			}							
		} else if (!isFinish) {
			backtrack(r + ((c + 1) / 9), (c + 1) % 9); // 다음 행, 열을 탐색
		}
	}
	
	static boolean check(int r, int c, int num) {
		// 행과 열 체크
		for (int i = 0; i < 9; i++) {
			if (answer[r][i] == num) return false;
			if (answer[i][c] == num) return false;
		}

		// 3x3 그리드 체크
		int gr = (r / 3) * 3;
		int gc = (c / 3) * 3;
		for (int i = gr; i < gr + 3; i++) {
			for (int j = gc; j < gc + 3; j++) {
				if (answer[i][j] == num) return false;
			}
		}
		
		return true;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int i = 0; i < 9; i++) {
        	sudoku[i] = br.readLine();
        	for (int j = 0; j < 9; j++) {
        		answer[i][j] = sudoku[i].charAt(j) - '0';
        	}
        }
        
        backtrack(0, 0);
       
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
