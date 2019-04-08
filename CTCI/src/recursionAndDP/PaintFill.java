package recursionAndDP;

enum Color{Black, White, Red, Yellow, Green};

public class PaintFill {

	public static void paintFill(Color screen[][], int row, int column, Color color)
	{
		if(screen.length==0) return;
		DFS(screen,row,column,screen[row][column],color);
	}
	public static void DFS(Color screen[][], int row, int column, Color currColor, Color newColor)
	{
		if(row<0 || row>=screen.length || column<0 || column>=screen.length)
			return;

		if(screen[row][column]==currColor)
		{
			screen[row][column]=newColor;
			DFS(screen,row-1,column,currColor,newColor);
			DFS(screen,row+1,column,currColor,newColor);
			DFS(screen,row,column-1,currColor,newColor);
			DFS(screen,row,column+1,currColor,newColor);
		}
	}
	public static String PrintColor(Color c) {
		switch(c) {
		case Black:
			return "B";
		case White:
			return "W";
		case Red:
			return "R";
		case Yellow:
			return "Y";
		case Green:
			return "G";
		}
		return "X";
	}
	
	public static void PrintScreen(Color[][] screen) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print(PrintColor(screen[i][j]));
			}
			System.out.println();
		}
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	public static void main(String[] args) {
		int N = 5;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = Color.Black;
			}			
		}
		for (int i = 0; i < 25; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.Green;
		}
		PrintScreen(screen);
		paintFill(screen, 2, 2, Color.White);
		System.out.println();
		PrintScreen(screen);
	}
}
