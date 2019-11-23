public class MyArrayList{
  
  private static final int DEFAULT_SIZE = 16;
 
  int[] list;
  
  int capacity;
  int size;
  
  public MyArrayList(){
    this.size = 0;
    this.capacity = DEFAULT_SIZE;
    list = new int[capacity];
  }
  
  public MyArrayList(int size){
    this.capacity = size;
    this.size = 0;
    list = new int[capacity];
  }
  
  public void add(int val){
    if(size >= capacity){
      int[] tmp = list;
      list = expand();
      arrayCopy(tmp, list);
    }
    list[size++] = val;
  }
  
  public int get(int index){
    if(index >= 0 && index < size){
      return list[index];
    }
    return -1;
  }
  
  public void remove(int index){
    if(index >= 0 && index < size){
      arrayCopy(list, list, index + 1, size, index);
      size--;
    }
  }
  
  public int size(){
    return this.size();
  }
  
  public int[] toArray(){
    int[] tmp = new int[size];
    arrayCopy(list, tmp);
    return tmp;
  }
  
  

  private int[] expand(){
    capacity *= 2;
    return new int[capacity];
  }
  
  private void arrayCopy(int[] from, int[] to){
    arrayCopy(from, to, 0, size, 0);
  }
  
  private void arrayCopy(int[] from, int[] to, int start, int end, int to_begin){
    for(int i = start; i < end; ++i){
      to[to_begin++] = from[i];
    }
  }

}
