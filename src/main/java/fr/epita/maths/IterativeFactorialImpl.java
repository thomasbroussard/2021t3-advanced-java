package fr.epita.maths;

public class IterativeFactorialImpl implements IFactorialService {

	public int calculateFactorial(int n){
		int result = n;
		for (int i = 1; i < n ; i++){
			result *= i;
		}
		return result;
	}
}
