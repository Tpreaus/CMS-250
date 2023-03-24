/**
 * Node Pointer Class
 * - Create the NodePointer objects
 * - Get the next node in the list
 * - Print the data from the node
 * 
 * Theodore Preaus & Philip Clarke
 * 
 * CMS 250
 *
 */
public class NodePointer {
	
	private char data;
	private NodePointer next;
	
	public NodePointer() {
	}
	
	//-------------------------------------------------
	
	public NodePointer(char d, NodePointer n) {
		data = d;
		next = n;
	}
	
	//--------------------------------------------------
	
	public int getData() {
		return data;
	}
	
	public void setData(char x) {
		this.data = x;
	}
	
	public NodePointer getNext() {
		return next;
	}
	
	public void setNext(NodePointer y) {
		this.next = y;
	}
	
	//---------------------------------------------------
	
	public void printData() {
		System.out.print(data);
	}
	
}
