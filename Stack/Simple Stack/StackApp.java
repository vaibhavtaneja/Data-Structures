import java.io.*;
class StackX{
	private int maxSize;
	private long [] stackArray;
	private int top;

	public StackX(int m){
		maxSize=m;
		stackArray = new long[m];
		top = -1;
	}
	public void push(long j){
		stackArray[++top]=j;
	}
	public long pop(){
		return stackArray[top--];
	}
	public long peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		return (top==-1);
	}
	public boolean isFull(){
		return (top==maxSize-1);
	}
}
class StackApp{
	public static void main(String[] args)throws IOException {
		StackX theStack = new StackX(10);
		if(!theStack.isFull())
			theStack.push(20);
		else
			System.out.println("Stack is Full");
		if(!theStack.isFull())
			theStack.push(40);
		else
			System.out.println("Stack is Full");
		if(!theStack.isFull())
			theStack.push(60);
		else
			System.out.println("Stack is Full");
		if(!theStack.isFull())
			theStack.push(80);
		else
			System.out.println("Stack is Full");
		System.out.println("Checking top value "+theStack.peek());
		System.out.println("");
		while(!theStack.isEmpty()){
			long value=theStack.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");
	}
}