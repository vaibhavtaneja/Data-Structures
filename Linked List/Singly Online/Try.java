import java.io.*;

class Node{
	protected int data;
	protected Node link;
	public Node(){
		data = 0;
		link = null;	
	}

	public Node(int d, Node l){
		data = d; 
		link=l;
	}
	public void setLink(Node l){
		link = l;
	}
	public void setData(int d){
		data = d;
	}
	public Node getLink(){
		return link;
	}
	public int getData(){
		return data;
	}
}
class linkedList{
	protected Node start;
	protected Node end;
	public int size;
	
	public linkedList(){
		start = null;
		end = null;
		size = 0;
	}
	public boolean isEmpty(){
		return start == null;
	}
	public int size(){
		return size;
	}

	public void insertAtStart(int val){
		Node nptr = new Node(val,null);
		size++;
		if(start==null){
			start = nptr;
			end = nptr;
		}
		else {
			nptr.setLink(start);
			start  = nptr;
		}
	}
	public void insertAtEnd(int val){
		Node nptr = new Node(val, null);
		size++;
		if (start == null) {
			start = nptr;
			end = nptr;
		}
		else{
			end.setLink(nptr);
			end = nptr;
		}
	}
	public void insertAtPos(int val ,int pos){
		Node nptr = new Node(val,null);
		Node ptr = start;
		pos--;
		for(int i = 1;i<size;i++){
			if(i==pos){
				Node tmp = ptr.getLink();
				ptr.setLink(nptr);
				nptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		} 
		size++;
	}

	public void deleteAtPos(int pos){
		if(pos==1){
			start = start.getLink();
			size--;
			return;
		}
		if(pos == size){
			Node s =start;
			Node t = start;
			while(s.getLink()!=null){
				t = s;
				s = s.getLink();
			}
			t.setLink(null);
			end = t;
			size--;
			return;
		}
		Node ptr = start;
		pos = pos -1;
		for (int i=1;i<size-1;i++ ) {
			if(pos==i){
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr=ptr.getLink();
		}
		size--;
	}

	public void display(){
		System.out.print("Singly Linked List = ");
		if(size==0){
			System.out.print("Empty \n");
			return;
		}
		if(start.getLink()==null){
			System.out.print(start.getData()+" \n");
			return;
		}
		Node ptr = start;
		while(ptr.getLink()!=null){
			System.out.print(ptr.getData()+"->");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData()+"\n");
	}
}

public class Try{
	public static void main(String[] args) throws IOException{
		linkedList list = new linkedList();
		list.insertAtStart(8);
		list.display();
		list.insertAtStart(81);
		list.insertAtStart(82);
		list.insertAtStart(83);
		list.insertAtStart(84);
		list.display();
		list.insertAtStart(98);
		list.insertAtStart(98);
		list.insertAtStart(98);
		list.display();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.display();
		list.insertAtPos(5,3);
		list.insertAtPos(6,3);
		list.insertAtPos(7,3);
		list.insertAtPos(8,3);
		list.display();
		list.deleteAtPos(3);
		list.deleteAtPos(3);
		list.deleteAtPos(3);
		list.deleteAtPos(3);
		list.display();
		
	}
}