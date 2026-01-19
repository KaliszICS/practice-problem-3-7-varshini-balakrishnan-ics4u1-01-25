public class PracticeProblem {

	public static void main(String args[]) {
	}
	public static int searchMazeMoves(String[][] arr) {
		int curRow = arr.length - 1;
		int curCol = 0;
		int noOfMoves = 0;
		return dfsHelper(arr, curRow, curCol, noOfMoves);
	}
	public static int dfsHelper(String[][] arr, int curRow, int curCol, int noOfMoves) {
		if (curRow < 0 || curRow >= arr.length || curCol < 0 || curCol >= arr[0].length) {
			return -1;
		}
		if (arr[curRow][curCol].equals("*")) {
			return -1;
		}
		if (arr[curRow][curCol].equals("F")) {
			return noOfMoves;
		}
		String temp = arr[curRow][curCol];
		arr[curRow][curCol] = "*";
		int right = dfsHelper(arr, curRow, curCol + 1, noOfMoves + 1);
		int up = dfsHelper(arr, curRow - 1, curCol, noOfMoves + 1);

		int left = dfsHelper(arr, curRow, curCol - 1, noOfMoves + 1);
		int down = dfsHelper(arr, curRow + 1, curCol, noOfMoves + 1);
		arr[curRow][curCol] = temp;
		int min = -1;
		if (right != -1) min = right;
		if (up != -1 && (min == -1 || up < min)) min = up;
		if (left != -1 && (min == -1 || left < min)) min = left;
		if (down != -1 && (min == -1 || down < min)) min = down;
		return min;

	}