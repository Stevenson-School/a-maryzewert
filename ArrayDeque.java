import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDeque<T> implements Deque<T>,Iterable<T> {
    private T[] arr;
    private int size;
    protected int first;
    protected int last;
    private double RATIO = 0.25;

    public ArrayDeque(){
        arr = (T[]) new Object[8];
        first = 0;
        last = 1;
        size = 0;
    }

    public void addFirst(T item){
        if(size==arr.length) {
            resize(2);
        }

        arr[first] = item;
        first = Math.floorMod(first-1,arr.length);
        size++;
    }

    public void addLast(T item){
        if(size==arr.length) {
            resize(2);
        }

        arr[last] = item;
        last = (last+arr.length+1) % arr.length;

        size++;
    }
// don't resize with arraycopy
    public void resize(int refactor){
        T[] newArr =(T[]) new Object[arr.length * refactor];
        for(int i =0;i<size;i++){
            newArr[i+1] = get(i);
        }
        first = 0;
        last = first+size+1;
        arr = newArr;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }
//for remove methods resize later in method

    public T removeFirst(){
       first = (first+1)%arr.length;
       T firstplace = arr[first];
       arr[first] = null;
        if((double)size/arr.length< RATIO){
            resize(1/2);
        }
        size--;
        return firstplace;
    }

    public T removeLast(){
        last = (last+arr.length-1)%arr.length;
        T lastplace = arr[last];
        arr[last] = null;
        if((double)size/arr.length< RATIO){
            resize(1/2);
        }
        size--;
        return lastplace;
    }

    public T get(int index){
        return arr[(first+1+index)%arr.length];
    }

    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i));
        }
        System.out.println();
    }

    public List<T> toList(){
        ArrayList<T> list = new ArrayList<>();
        for(int i = 0; i<arr.length;i++){
            list.add(get(i));
        }
        return list;
    }

    @Override
    public String toString(){
        String ret = "";
        for(int i = 0;i<size();i++){
            ret += get(i) + " ";
        }
        return ret;
    }

    @Override
    public boolean equals(Object other){
        ArrayDeque obj = (ArrayDeque) other;
        if(arr.size()!=other.size()){
            return false;
        }
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!=other.get(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }

    public class ArrayDequeIterator implements Iterator<T>{
        int pos;
        public ArrayDequeIterator(){
            pos = 0;
        }

        public T next(){
            return (pos<size());
        }

        public T hasNext(){
            return arr[pos++];
        }
    }



    public static void main(String[] args) {
        ArrayDeque<Double> deck = new ArrayDeque<>();
        deck.addLast(2.3);
        deck.addLast(0.0);
        deck.addFirst(4.7);
        deck.addLast(2.3);
        deck.addLast(0.0);
        deck.addFirst(4.7);
        deck.addLast(2.3);
        deck.addLast(0.0);
        deck.resize(2);
        deck.addFirst(4.7);
        System.out.println(deck);
        System.out.println(deck.toString());
    }

    }


