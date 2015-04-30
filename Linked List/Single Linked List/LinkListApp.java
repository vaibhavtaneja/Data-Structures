import java.io.*;

class Link
{
	public int iData;
	public double dData;
	public Link next;

	public Link(int id,double dd)
	{
		iData=id;
		dData=dd;
	}

	public void displayLink()
	{
		System.out.print("{"+iData+", "+dData+" } ");
	}
}

class LinkList
{
	private Link first;

	public LinkList()
	{
		first = null;
	}

	public void insertFirst(int id,double dd)
	{
		Link newLink = new Link(id,dd);
		newLink.next= first;
		first = newLink;
	}

	public void displayList()
	{
		Link current = first;
		while (current!=null) 
		{
			current.displayLink();
			current= current.next;
		}
		System.out.println("");
	}

	public Link find(int key){
		Link current = first;
		while(current.iData!=key){
			if(current.next==null){
				return null;
			}
			current = current.next;			
		}
		return current;
	}

	public Link delete(int key){
		Link current = first;
		Link previous = first;

		while(current.iData!=key){
			if(current.next==null){
				return null;
			}
			previous = current;
			current = current.next;	
		}

		if(current.equals(first)){
			first=first.next;
		}
		else{
			previous.next= current.next;
		}
		return current;
	}
}

class LinkListApp
{
	public static void main(String[] args) throws IOException
	{
		LinkList list = new LinkList();
		list.insertFirst(1,20.0);
		list.insertFirst(2,30.0);
		list.insertFirst(3,40.0);
		list.insertFirst(4,50.0);
		list.insertFirst(5,60.0);
		
		list.displayList();
		
		Link find = list.find(2);
		if(find!=null){
			System.out.print("Found key is ");
			find.displayLink();
			System.out.println("");
		}else {
			System.out.println("Could not find it");
		}

		Link del = list.delete(5);

		if(del!= null){
			System.out.print("Deleted Key is ");
			del.displayLink();
			System.out.println("");			
		}
		else{
			System.out.println("Could not delete it");
		}

		list.displayList();
		
		Link del1 = list.delete(3);

		if(del1!= null){
			System.out.print("Deleted Key is ");
			del1.displayLink();
			System.out.println("");			
		}
		else{
			System.out.println("Could not delete it");
		}
		list.displayList();
	}
}




















