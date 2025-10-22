
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    
    static int r;
    static int c;
    
    static int num;
    
    static int[][] notebook;
    static int[][] stickerNew;
    
    static boolean compareSticker(int row, int col, int i, int j)
    {
        for (int k = 0; k < row; ++k)
        {
        	for (int l = 0; l < col; ++l)
        	{
        		if (stickerNew[k][l] == 1)
        		{
        			if (notebook[i + k][j + l] == 1)
        				return false;
        			else
        				continue;
        		}
        	}
        }
        return true;
    }
    
    static boolean bruteforce(int row, int col) {
        for (int i = 0; i < N - row + 1; ++i)
        {
            for (int j = 0; j < M - col + 1; ++j)
            {
            	if (compareSticker(row, col, i, j))
            	{
            		for (int k = 0; k < row; ++k)
            		{
            			for (int l = 0; l < col; ++l)
            			{
            				if(stickerNew[k][l] == 1)
            				{
	            				notebook[i + k][j + l] = stickerNew[k][l];
	            				if (notebook[i + k][j + l] == 1)
	            					num ++;
            				}
            			}
            		}
            		
            		return true;
            	}
            }
        }
        return false;
    }
    
    static boolean matching(int[][] sticker, int d) {
        switch (d) {
        case 0: // 0
        {
            stickerNew = sticker;
            return bruteforce(r, c);
        }
        case 1: // 90
        {
            stickerNew = new int[c][r];
            for (int i = 0; i < c; ++i)
                for (int j = 0; j < r; ++j)
                    stickerNew[i][j] = sticker[r - 1 - j][i];
            return bruteforce(c, r);
        }
        case 2: // 180
        {
            stickerNew = new int[r][c];
            for (int i = 0; i < r; ++i)
                for (int j = 0; j < c; ++j)
                    stickerNew[i][j] = sticker[r - 1 - i][c - 1 - j];
            return bruteforce(r, c);
        }
        case 3: // 270
        {
            stickerNew = new int[c][r];
            for (int i = 0; i < c; ++i)
                for (int j = 0; j < r; ++j)
                    stickerNew[i][j] = sticker[j][c - 1 - i];
            return bruteforce(c, r);
        }
        default:
            return false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        notebook = new int[N][M];
        
        for (int k = 0; k < K; ++k) // 스티커 개수
        {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            int[][] sticker = new int[r][c];
            
            for (int i = 0; i < r; ++i)
            {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; ++j)
                {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int d = 0; d < 4; ++d)
            {
                if (matching(sticker, d))
                    break;
            }
        }
        
        System.out.println(num);
    }
}
