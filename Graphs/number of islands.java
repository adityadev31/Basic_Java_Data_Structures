import java.util.*;

public class Main {
    
    private static int R;
    private static int C;
    
    private static void DFS(int[][] arr, int a, int b) {
        int[] diri = {-1,-1,-1,0,0,1,1,1};
        int[] dirj = {-1,0,1,-1,1,-1,0,1};
        Stack<String> st = new Stack<>();
        arr[a][b] = 0;
        st.push(new String(a+","+b));
        while(!st.empty()) {
            String x = st.pop();
            int i = Integer.parseInt(x.split(",")[0]);
            int j = Integer.parseInt(x.split(",")[1]);
            for(int k=0; k<8; k++) {
                int i_ = i+diri[k];
                int j_ = j+dirj[k];
                if((i_>=0 && i_<R && j_>=0 && j_<C) && (arr[i_][j_] == 1)) {
                    arr[i_][j_] = 0;
                    st.push(new String(i_+","+j_));
                }
            }
        }
    }
    
    public static int noOfIslands(int[][] arr) {
        R = arr.length;
        C = arr[0].length;
        int cnt = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] == 1) {
                    cnt++;
                    DFS(arr, i, j);
                }
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) throws Exception {
        int[][] arr = {
            {1,1,0,0,1},
            {1,1,0,1,1},
            {1,0,0,0,0},
            {0,0,0,1,1},
        };
        
        System.out.println(noOfIslands(arr));
    }
}


// =========== output ==========

//  ans: 3
