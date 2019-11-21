public class MyTrie{
	class Node{
		Node[] child;
		boolean isEnd;
		
		public Node(){
			this.child = new Node[26];
			isEnd = false;
		}
		
		public void setEnd(boolean end){
			isEnd = end;
		}
		
		public Node getChild(char c){
			return child[c - 'a'];
		}
		
		public void setChild(char c){
			child[c - 'a] = new Node();
		}
		
		public boolean isWord(){
			return isEnd;
		}
	}
	
	Node head;
	
	public MyTire(){
		head = new Node();
	}
	
	public void add(String s){
		int index = 0;
		Node curr = head;
		while(index < s.length()){
			char c = s.charAt(index);
			if(curr.getChild(c) == null){
				curr.setChild(c);
			}
			curr = curr.getChild(c);
			index++;
		}
		curr.setEnd(true);
	}
	
	public void remove(String s){
		int index = 0;
		Node curr = head;
		while(index < s.length()){
			char c = s.charAt(index);
			if(curr.getChild(c) == null)
				return;
			}
			curr = curr.getChild(c);
			index++;
		}
		
		if(curr.isWord()){
			curr.setEnd(false);
		}
		
	}
	
}
