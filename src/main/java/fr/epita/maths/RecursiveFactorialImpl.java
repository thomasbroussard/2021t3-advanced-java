package fr.epita.maths;

public class RecursiveFactorialImpl implements IFactorialService {

	public int getMax_depth() {
		return max_depth;
	}

	public void setMax_depth(int max_depth) {
		this.max_depth = max_depth;
	}

	private int max_depth = 1000 ;

	public int calculateFactorial(int n){
		int result = n;
		for (int i = 1; i < n ; i++){
			result *= i;
		}
		return result;
	}


}
