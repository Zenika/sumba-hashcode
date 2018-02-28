package hashcode;

public class Solution {

	public static void resolve(Pizza pizza) {
		for(int row = 0 ; row < pizza.rows ; row++) {
			for (int startCol = 0; startCol < pizza.columns ; ) {
				boolean hasSolution = false;
				int sliceSize;
				for(sliceSize = Math.min(pizza.columns - startCol, pizza.max) ; sliceSize > 0 ; sliceSize--) {
					if (Solution.isValid(pizza, row, startCol, row, startCol + sliceSize - 1)) {
						Slice slice = new Slice();
						slice.c1 = startCol;
						slice.c2 = startCol + sliceSize - 1;
						slice.r1 = row;
						slice.r2 = row;
						pizza.slices.add(slice);
						hasSolution = true;
						break;
					}
				}

				if(hasSolution) {
					startCol +=  sliceSize;
				} else {
					startCol++;
				}
			}
		}
	}

	public static boolean isValid(Pizza pizza, int startRow, int startCol, int endRow, int endCol) {
		int t = 0;
		int m =  0;

		for(int row = startRow ; row <= endRow ; row++) {
			for(int col = startCol ; col <= endCol ; col++) {
				if(pizza.cells[row][col]) {
					t++;
				} else {
					m++;
				}
			}
		}

		return t >= pizza.min && m >= pizza.min;
	}
}
