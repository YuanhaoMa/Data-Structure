
public class MyLinkedList{
    class Node{
        int val;
        Node prev;
        Node next;
        
        public Node(int val){
          this.val = val;
        }
        
        public void setVal(int val){
          this.val = val;
        }
        
        public int getVal(){
            return this.val;
        }
    }
    
    Node head;
    Node last;
    int size;
    
    public MyLinkedList(){
        head = null;
        last = null;
        size = 0;
    }
    
    public void addFirst(int val){
        if(size == 0){
            head = new Node(val);
            last = head;
        }
        else if (size == 1){
            head = new Node(val);
            head.next = last;
            last.prev = head;
        }
        else{
            Node tmp = new Node(val);
            tmp.next = head;
            head.prev = tmp;
            head = tmp;
        }
        size++;
    }
    
    public void addLast(int val){
         if(size == 0){
             head = new Node(val);
             last = head;
         }
         else if(size == 1){
             last = new Node(val);
             last.prev = head;
             head.next = last;
         }
         else{
             Node tmp = new Node(val);
             tmp.prev = last;
             last.next = tmp;
             last = tmp;
         }
         size++;
    }
    
    public void removeFirst(){
        if(size == 0) return;
        
        if(size == 2){
            head = last;
            last.prev = null;
        }
        else if(size == 1){
            head = null;
            last = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    
    public void removeLast(){
        if(size == 0) return;
        
        if(size == 2){
            last = head;
            head.next = null;
        }
        else if(size == 1){
            head = null;
            last = null;
        }
        else{
            last = last.prev;
            last.next = null;
        }
        size--;
    }
    
    public void insert(int index, int val){
        if(index <= 0){
            addFirst(val);
        }
        else if(index > size){
            addLast(val);
        }
        else{
            int i = 1;
            Node curr = head;
            while(curr != null && i != index){
                curr = curr.next;
                i++;
            }
            Node tmp = new Node(val);
            curr.next.prev = tmp;
            tmp.next = curr.next;
            curr.next = tmp;
            tmp.prev = curr;
            size++;
        }
    }
    
    public void remove(int index){
        if(index < 0 || index > size || size == 0) return;
        if(index == 0){
            removeFirst();
        }
        else if(index == size){
            removeLast();
        }
        else{
          int i = 0;
          Node curr = head;
          while(curr != null && i != index){
              curr = curr.next;
              i++;
          }
          curr.prev.next = curr.next;
          curr.next.prev = curr.prev;
          size--;
        }
    }
    
    // return the first-in value, if not exist return -1
    public int poll(){
        if(size == 0) return -1;
        int ret = head.val;
        removeFirst();
        return ret;
    }
    
    // return last-in value, if not exist return -1
    public int pop(){
        if(size == 0) return -1;
        int ret = last.val;
        removeLast();
        return ret;
    }
    
    public int getFirst(){
        if(size == 0) return -1;
        return head.val;
    }
    
    public int getLast(){
        if(size == 0) return -1;
        return last.val;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int[] toArray(){
        int[] ret = new int[size];
        Node curr = head;
        int i = 0;
        while(i < size && curr != null){
            ret[i++] = curr.val;
            curr = curr.next;
        }
        return ret;
    }
    
    public int indexAt(int index){
        Node ret = getNodeAt(index);
        if(ret == null) return -1;
        return ret.getVal();
    }
    
    public int setVal(int index, int val){
        Node ret = getNodeAt(index);
        if(ret == null) return -1;
        ret.setVal(val);
        return 1;
    }
    
    private Node getNodeAt(int index){
        if(index < 0 || index > size) return null;
        Node curr = head;
        int i = 0;
        while(i != index && curr != null){
             curr = curr.next;
             i++;
        }
        return curr;
    }
}
