/**
 * LinkedList Class 
 * -Needs To be able to addNodes to the front + back
 * 
 * 
 * Theodore Preaus & Philip Clarke
 * 
 * CMS 250
 * 
 */
import java.util.ArrayList;

public class LList {
	
	
	private NodePointer head;
	private ArrayList<NodePointer> nodes;
	
	//---------------------------------------
	
	public LList() {
		this.nodes = new ArrayList<NodePointer>();
	}
	
	//---------------------------------------
	
	public LList(NodePointer x) {
		head = x;
		nodes.add(x);
	}
	
	//---------------------------------------
	
	public NodePointer getHead() {
		return head;
	}
	
	//---------------------------------------
	
	public void setHead(NodePointer x) {
		this.head = x;
	}
	
	//---------------------------------------
	
	public void addAtHead(NodePointer x) {
		if (x != null) {
			
			if (this.nodes.size() == 0) {
				this.head = x;
				this.nodes.add(this.head);
			} else {
				x.setNext(head);
				this.head = x;
				this.nodes.add(0, this.head);
			}
		}
	}
	
	//---------------------------------------

	
	public void addAtEnd(NodePointer x) {
		if (x != null) {
			if (this.head == null) {
				this.head = x;
				this.nodes.add(x);
			} else {
				NodePointer temptr = this.head;
				while (temptr.getNext() != null) {
					temptr = temptr.getNext();
				}
				
			temptr.setNext(x);
			this.nodes.add(x);
			
			}
		}
	}
}
