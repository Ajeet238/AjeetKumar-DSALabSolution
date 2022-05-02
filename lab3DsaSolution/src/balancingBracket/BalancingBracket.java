package balancingBracket; 
 
import java.util.Scanner;
import java.util.Stack;

public class BalancingBracket {
  
	public static void balanceBracket(String str) {
		Stack<Character> st = new Stack<>();
		int size = str.length();
		int check = 0;

		for (int i = 0; i < size; i++) {
			char temp = str.charAt(i);
			System.out.println(temp + "temp");
			if (temp == '(' || temp == '{' || temp == '[') {
				st.push(temp);
				check = 1;
			} else {
				char temp2 = st.peek();
				int comp = Character.compare(temp, temp2);
				
// comp will return ASCII code difference 
				if (comp == 2 || comp == 1) {
					st.pop();
					check = 0;
				} else {
					check = 1;
				}
			}
		}

		if (check == 0) {
			System.out.println("The entered String has Balanced Brackets" + "");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets" + "");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.replaceAll("\\s", "");
		balanceBracket(str);

	}

}
