import java.util.Comparator;

public class MaxArrayDeque<T> implements Deque<T>,Comparable<T>{
    private T[] arr =  (T[]) new Object[8];
    private int size;
    protected int first;
    protected int last;

    public MaxArrayDeque(Comparator<T> c){
        arr = new
      size = 0;
    }

    public void addFirst(T item){

    }
    public void addLast(T item){

    }
    public boolean isEmpty(){
      return size ==0;
    }
    public int size(){
      return size;
    }
    public T removeFirst(){

    }
    public T removeLast(){

    }
    public T get(int index){

    }
    public void printDeque(){

    }
    public T max(){

    }

    public T max(Comparator<T> c){

    }
}
