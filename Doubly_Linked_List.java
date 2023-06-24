package DDL;

public class Doubly_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL dll = new DLL();
        dll.InsertAtHead(4);
        dll.InsertAtHead(8);
        dll.InsertAtHead(0);
        dll.InsertAtTail(5);
        dll.InsertAtIndex(3,0);
        
        dll.print(dll.head);
        System.out.println(dll.GetSize());
        
        dll.DeleteByValue(5);
        System.out.println("New list");
        dll.print(dll.head);
        
        dll.DeleteByIndex(3);
        System.out.println("New list");
        dll.print(dll.head);
	}
}
class Node{
    int data;
    Node prev;
    Node next;
    
    public Node(int data){
        this.data=data;
        prev=null;
        next=null;
    }
}
class DLL{
        Node head;
        
    public void InsertAtHead(int val){
        Node node = new Node(val); 
            
        if(head == null){
              head = node;
        }
        else{
            head.prev = node;
            node.next = head;
            head = node;
        }
    }
    public void InsertAtTail(int val){
        Node newnode = new Node(val);
        
        if(head == null){
            head = newnode;
        }
        else{
            Node node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = newnode;
            newnode.prev = node;
        }
    }
    public void InsertAtIndex(int val, int index){
        Node node = head;
        Node newnode = new Node(val);
        
        int size = GetSize();
        if(index > size){
            System.out.println("Invalid Index");
            return;
        }
        if(index == 0) {
        	InsertAtHead(val);
        	return;
        }
        while(index>1){
            node = node.next;
            index--;
        }
        newnode.next = node.next;
        node.next.prev = newnode;
        node.next = newnode;
        newnode.prev = node;
    }
    public void DeleteByValue(int value){
        Node node = head;

        //if deleting head 
        if(node.data == value){
            head = node.next;
            node.next.prev = null;
            node.next = null;
            System.out.println("deleted value = " + node.data);
        }
        else{
            while(node.next != null && node.next.data != value ){
                node = node.next;
            }
            if(node.next != null){
                System.out.println("deleted value = " + node.next.data);
                Node temp = node.next;
                if(node.next.next != null){
                    node.next.next.prev = node;
                    node.next = node.next.next;
                    temp.next = null;
                    temp.prev = null; 
                }
                else{
                    node.next = node.next.next;
                    temp.prev = null;
                }
            }
            else{
                System.out.println("value not found");
            }
        }
    }
    public void DeleteByIndex(int index){
        int size = GetSize();
        if(index >= size || index < 0){
            System.out.println("invalid index");
            return;
        }

        Node node = head;
        if(index == 0){ // or size 1  
            head = node.next;
            node.next.prev = null;
            node.next = null;
            System.out.println("deleted value = " + node.data);
        }
        else{
            while(index > 1){
                node = node.next;
                index--;
            }
            System.out.println("deleted value = " + node.next.data);
            Node temp = node.next;
            if(node.next.next != null){
                node.next.next.prev = node;
                node.next = node.next.next;
                temp.next = null;
                temp.prev = null; 
            }
            else{
                node.next = node.next.next;
                temp.prev = null;
            }
        }
    }
    public Node Reverse(Node head){
        Node tmp = null;
        Node current = head;

        while(current != null){
            tmp = current.prev;
            current.prev = current.next;
            current.next = tmp;
            current = current.prev;
        }
        return tmp.prev;
    }
    public int GetSize(){
        Node node = head;
        int size = 0;
        while(node != null){
            node = node.next;
            size++;
        }
        return size;
    }
    public void print(Node head){
        if(head == null){
           System.out.println("list underflow");
        }
        else{
            while(head.next != null){
                System.out.print(head.data + "<->");
                head = head.next;
            }
            System.out.print(head.data);
        }
        System.out.println();
    }
}
