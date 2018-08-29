import java.util.Scanner;

public class Homework3 {

	public static void main(String[] args) {
		double n1 = 0, n2, n3;
		Scanner input = new Scanner(System.in);
		// try{

		System.out.println("Enter your numbers: ");
		String numWhol1 = input.nextLine();
		String numWhol2 = numWhol1.trim(); // get rid of space

		int[] operPos = new int[numWhol2.length()]; // Operators' position
		int[] parenPosOpe = new int[numWhol2.length()]; // Parentheses' position
		int[] parenPosClo = new int[numWhol2.length()]; // Parentheses' position
		//char parentOpen[] = { '(' };
		//char parentClose[] = { ')' };
		char operat[] = { '+', '-', '/', '*' };
		int opNum = 0, ParOpeNum = 0, parCloNum = 0;


		for (int i = 0; i < numWhol2.length(); i++) { //find the position of operators & parentheses 
			char myChar = numWhol2.charAt(i);
			for (int j = 0; j <= 3; j++) {
				if (myChar == operat[j]) {
					operPos[opNum] = i;
					opNum++;
				}
					/**if (myChar == parentOpen[0]) {
						parenPosOpe[ParOpeNum] = i;
						ParOpeNum++;
					}		
					if (myChar == parentClose[0]) {
						parenPosClo[parCloNum] = i;
						parCloNum++;
					}*/		
		}
		}
	//	for(int c = 0; c <= numWhol2.length(); c++){
	//	if (((int) (numWhol2.substring(c,c + 1).charAt(0)) == ((int) parenPosOpe[c]))){
			
	//	}
				
		/**	
		int numOfOper, numOfParen = 0;
		for (int c = 0; c < numWhol2.length() - 1; c++) { // count the number of
															// operators & Parentheses
			if (operPos[c] != 0)
				numOfOper++;
			else if (parenPos[c] != 0)
				numOfParen++;
		}
*/
		double[] numbers = new double[opNum + 1];
		for (int l = 0; l < opNum; l++) { // separate numbers and collect them
											// in
											// an array
			if (l == 0) {
				numbers[l] = Double.parseDouble((numWhol2.substring(l, operPos[l])));
				numbers[l + 1] = Double.parseDouble(numWhol2.substring(operPos[l] + 1, operPos[l + 1]));
			} else if (l == (opNum - 1)) {
				numbers[l + 1] = Double.parseDouble((numWhol2.substring(operPos[l] + 1)));
			} else {
				numbers[l + 1] = Double.parseDouble((numWhol2.substring((operPos[l] + 1), operPos[l + 1])));
			}
		}
		char[] oper = new char[opNum];
		for (int k = 0; k < opNum; k++) { // collect operators in an array
			oper[k] = numWhol2.charAt(operPos[k]);
		}
		 n1 = numbers[0]; n2 = numbers[1]; n3 = numbers[2];
		char o1 = oper[0], o2 = oper[1];
		for (int r = 2; r <= (opNum + 1); r++) {
			if ((((int) operFinder(o1, o2)) == (int) o1)) {
				n1 = calcNumb(o1, n1, n2);
				n2 = n3;
				o1 = o2;
				if (r >= opNum){
					n3 = 0;
					o2 = '.';
				}
				else {
				n3 = numbers[r + 1];
				o2 = oper[r];
				}
			} else if ((((int) operFinder(o1, o2)) == (int) o2)) {
				n2 = calcNumb(o2, n2, n3);
				if (r >= opNum){
					n3 = 0;
					o2 = '.';
				}
				else {
				n3 = numbers[r + 1];
				o2 = oper[r];
				}
			}

		}
		//System.out.println(n1);

		}

	}

	// }

	// catch(Exception e)
	// {

	// }
	// }
	public static char operFinder(char a, char b) {
		char result = '+';
		if (((int) a == 42) || ((int) a == 47))
			result = a;
		else if (((int) b == 42) || ((int) b == 47))
			result = b;
		else if ((int) a == 46 )
			result = b;
		else if ((int) b == 46)
			result = a;
		else
			result = a;
		return result;
	}

	public static double calcNumb(char o, double a, double b) {
		double result = 0;
		switch (o) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '/':
			result = a / b;
			break;
		case '*':
			result = a * b;
			break;

		}

		return result;
	}

}
/**
 * for (int i = 0; i < numWhol2.length(); i++) { //find the position of
 * operators & parentheses char myChar = numWhol2.charAt(i); for (int j
 * = 0; j <= 3; j++) { if (myChar == operat[j]) { operPos[opNum] = i;
 * opNum++; }
 * 
 * } } //numWhol = numWhol2; char[] oper = new char[opNum]; for (int k =
 * 0; k < opNum; k++) { // collect operators in an array oper[k] =
 * numWhol2.charAt(operPos[k]); } String myChanc; for(int a = 0; a <=
 * opNum - 2; a++){ if (a == 2){ myChanc
 * =ParenChech(numWhol2.substring(0, operPos[a]));
 * 
 * } myChanc = ParenChech(numWhol2.substring(operPos[a], operPos[a +
 * 1]));
 * 
 * } String firChanc = numWhol2.substring(0, operPos[3]); double n1, n2,
 * n3; char o1 = oper[0], o2 = oper[1]; for(int c = 0; c <=
 * firChanc.length(); c++){ if (((int) (firChanc.substring(c,c +
 * 1).charAt(0)) == ((int) parenPosOpe[0]))){ n1 =
 * Double.parseDouble(firChanc.substring(c + 1, operPos[c])); n2 =
 * Double.parseDouble(firChanc.substring((operPos[c] + 1),operPos[c +
 * 1])); } else if (((int) (firChanc.substring(operPos[c],(operPos[c +
 * 1])).charAt(0)) == ((int) parenPosOpe[0]))){ n1 =
 * Double.parseDouble(firChanc.substring(c, operPos[c])); n2 =
 * Double.parseDouble(firChanc.substring((operPos[c] + 1),operPos[c +
 * 1])); }}
 */
