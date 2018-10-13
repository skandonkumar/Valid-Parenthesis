import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		String[] str = s.split("");
		Stack<String> opening = new Stack<>();
			if(str[0].contains("}")||str[0].contains("]")||str[0].contains(")")) {
				return false;
			}
			for(int i=0;i<str.length;i++) {
				if(str[i].contains("(") || str[i].contains("{") || str[i].contains("[")) {
					opening.push(str[i]);
				}
				else if(str[i].contains(")") || str[i].contains("}") || str[i].contains("]")) {
					String temp = str[i];
					if(temp.contains(")")) {
						try {
							if(opening.lastElement().contains("(")){
								opening.pop();
							}else return false;
						}catch(Exception e) {
							return false;
						}
					}
					else if(temp.contains("}")) {
						try {
							if(opening.lastElement().contains("{")){
								opening.pop();
							}else return false;
						}catch(Exception e) {
							return false;
						}
					}
					else if(temp.contains("]")) {
						try {
							if(opening.lastElement().contains("[")){
								opening.pop();
							}
							else return false;
						}catch(Exception e) {
							return false;
						}
					}		
				}
			}
			if(opening.isEmpty())return true;
			else return false;
		
	}
	
	public static void main(String args[]) {
		Solution sol = new Solution();
		boolean result = sol.isValid("(])");
		System.out.println(result);
	}
}
