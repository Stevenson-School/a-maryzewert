import java.util.Comparator;


public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c){
        comp = c;
    }

    public MaxArrayDeque(){}

    public T max(){
        if(isEmpty()){
            return null;
        }
        T max = get(first+1);
       for(int i =0;i<size();i++){
            if(comp.compare(get(i),max)>0){
                max = get(i);
            }
        }
        return max;
    }

    public T max(Comparator<T> c){
        if(isEmpty()){
            return null;
        }

       T max = get(first+1);
        for(T item:this){
           if(c.compare(item,max)>0){
               max = item;
            }
        }
        for(int i =1;i<size();i++){
            if(c.compare(get(i),max)>0){
                max = get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Comparator<Double> dc = new Comparator<Double>(){
            @Override
            public int compare(Double o1,Double o2){
                return ((int) (o1-o2));
            }
        };


        MaxArrayDeque<Double> deck = new MaxArrayDeque<>(dc);
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
      // System.out.println(deck);
       System.out.println(deck.toString());

        MaxArrayDeque<Double> deck2 = new MaxArrayDeque<>(dc);
        deck2.addLast(2.3);
        deck2.addLast(0.0);
        deck2.addFirst(4.7);
        deck2.addLast(2.3);
        deck2.addLast(0.0);
        deck2.addLast(5.0);
      //deck2.addFirst(8.0);
       System.out.println(deck2.max());
        System.out.println(deck2);
        System.out.println(deck2.get(2));
    }
}

