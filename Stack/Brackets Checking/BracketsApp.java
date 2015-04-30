import java.io.*;
class StackX{
	private int maxSize;
	private char [] stackArray;
	private int top;
	public StackX(int max){
		maxSize = max;
		stackArray = new char[maxSize];
		top = -1;
	}
	public void push(char j){
		stackArray[++top]=j;
	}
	public char pop(){
		return stackArray[top--];
	}
	public char peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
}
class BracketsChecker{
	String input;
	public BracketsChecker(String in){
		input = in;
	}
	public void check(){
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);
		for(int i=0;i<input.length();i++){
			char ch = input.charAt(i);
			switch (ch) {
				case '{':
				case '[':
				case '(':
				theStack.push(ch);
				break;

				case '}':
				case ']':
				case ')':
				if(!theStack.isEmpty()){
					char chx = theStack.pop();
					//System.out.println(theStack.isEmpty());
					//System.out.println(chx +" is chx and ch is "+ch);
					if((ch==')' && chx!='(')||(ch==']' && chx!='[')||(ch=='}' && chx!='{'))
					{
						System.out.println("Error : "+ch+" at "+i);
						return ;
					}
				}
				else {
				 	System.out.println("Error : "+ch+" at "+i);	
					return;
				}
				//System.out.println(theStack.isEmpty()+" "+theStack.peek());
				break;
				default:
				 	break; 
			}
		}
		if(!theStack.isEmpty())
			System.out.println("Error missing right delimiter");
		else
			System.out.println("Right delimiter match");
	}	
}
class BracketsApp{
	public static void main(String [] args)throws IOException{
		String input;
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Enter a String containig delimiter : ");
			input = bs.readLine();
			if(input.equals(""))
				break;

			BracketsChecker theChecker = new BracketsChecker(input);
			theChecker.check();
		}
	}
}