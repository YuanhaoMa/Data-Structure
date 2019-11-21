public class MyHashMap{
    static final int DEFAULT_SIZE = 16;
    static final double DEFAULT_FLOAT = 0.75;
    class Node{
        int key;
        int val;
        Node next;
				
        public Node(int key, int val){
            this.key = key;
            this.val = val;
			this.next = null;
        }
				
				int getVal(){
						return this.val;
				}
				
				int getKey(){
						return this.key;
				}
				
				void setVal(int val){
						this.val = val;
				}
    }
    
		Node[] table;
		int size;
		int capacity;
		
		public MyHashMap(){
				size = 0;
				capacity = DEFAULT_SIZE;
				table = new Node[capacity];
		}
		
		public MyHashMap(int capacity){
				this.size = 0;
				this.capacity = capacity;
				table = new Node[capacity];
		}
		

		
		public void put(int key, int val){
				Node tmp = getNode(key);
				if(tmp != null){
						tmp.setVal(val);
				}
				else{
						tmp = new Node(key, val);
						addNode(tmp);
				}
				
				if(size >= capacity * DEFAULT_FLOAT){
						expand();
				}
		}

		public int get(int key){
				if(size == 0) return -1;
				Node n = getNode(key);
				if(n == null) return -1;
				return n.getVal();
		}
		
		public int size(){
				return size;
		}
		
		public boolean isEmpty(){
				return size == 0;
		}
		
		public int[] keySet(){
				return getSet(true);
		}
		
		public int[] values(){
				return getSet(false);
		}
		
		public boolean containsKey(int key){
				Node curr = getNode(key);
				return curr != null;
		}
				
		public int getOrDefault(int key, int default_val){
				Node n = getNode(key);
				if(n != null) return n.getVal();
				return default_val;
		}
		
		public void remove(int key){
				int pos = getPos(key);
				if(table[pos] != null){
						Node curr = table[pos];
						if(curr.getKey() == key){
								table[pos] = curr.next;
								size--;
								return;
						}
						else{
								while(curr != null && curr.next != null){
										if(curr.next.getKey() == key){
												curr.next = curr.next.next;
												size--;
												return;
										}
								}
						}
				}
		}
		
		private Node getNode(int key){
				int pos = getPos(key);
				if(table[pos] != null){
						Node curr = table[pos];
						while(curr != null){
								if(curr.getKey() == key){
										return curr;
								}
					  }
				}
				return null;
		}
		
		private void expand(){
				capacity *= 2;
				Node[] backup = table;
				table = new Node[capacity];
				size = 0;
				for(int i = 0; i < backup.length; ++i){
						if(backup[i] != null){
								Node curr = backup[i];
								while(curr != null){
										Node tmp = curr.next;
										curr.next = null;
										addNode(curr);
										curr = tmp;
								}
						}
				}
		}
		
		private void addNode(Node n){
				int pos = getPos(n.getKey());
				if(table[pos] == null){
						table[pos] = n;
						size++;
				}
				else{
						n.next = table[pos];
						table[pos] = n;
						size++;
				}
		}
		
		private int getPos(int key){
				return key & (capacity - 1);
		}
		
		private int[] getSet(boolean isKey){
				int[] set = new int[size];
				int index = 0;
				for(int i = 0; i < table.length; ++i){
						if(table[i] != null){
								Node curr = table[i];
								while(curr != null){
										set[index++] = (isKey) ? curr.getKey() : curr.getVal();
										curr = curr.next;
								}
						}
				}
				return set;
		}
		
		
}
