// 광물 캐기
class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int N, M;
    static int[] _picks;
    static String[] _minerals;
    
    public void backtrack(int idx, int score, int left) {
        if (idx >= N || left == 0) {
            answer = Math.min(answer, score);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (_picks[i] == 0) continue;
            _picks[i] -= 1;
            int tmp = 0;
            int dia = 0;
            int iron = 0;
            int stn = 0;
            int maxIdx = Math.min(idx + 5, N);
            for (int j = idx; j < maxIdx; j++) {
                if (_minerals[j].equals("diamond")) dia += 1;
                else if (_minerals[j].equals("iron")) iron += 1;
                else stn += 1;
            }
            
            if (i == 0) {
                tmp += (dia + iron + stn);
            } else if (i == 1) {
                tmp += (dia * 5 + iron + stn);
            } else {
                tmp += (dia * 25 + iron * 5 + stn);
            }
            // System.out.println(idx + " " + maxIdx + " " + i);
            // System.out.println(dia + " " + iron + " " + stn);
            backtrack(maxIdx, score + tmp, left - 1);
            _picks[i] += 1;
        }
        
    }
    
    
    public int solution(int[] picks, String[] minerals) {
        N = minerals.length;
        M = 0;
        for (int i = 0; i < 3; i++) {
            M += picks[i];
        }
        _picks = picks;
        _minerals = minerals;
        backtrack(0, 0, M);

        return answer;
    }
}