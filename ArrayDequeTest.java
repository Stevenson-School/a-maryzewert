import static org.junit.Assert.*;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

public class ArrayDequeTest {

    @Test
    public void testAddFirst(){
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addFirst(10);
        input.addFirst(5);
        input.addFirst(7);
        input.addFirst(13);
        List<Integer> expected = Arrays.asList(13,7,5,10, null, null, null, null);
        List<Integer> actual = input.toList();
        assertEquals(expected,actual);
    }

    @Test
    public void testAddLast(){
       ArrayDeque<Integer> input = new ArrayDeque<>();
       input.addLast(10);
        input.addLast(5);
        input.addLast(7);
        input.addLast(13);
       List<Integer> expected = Arrays.asList(10,5,7,13, null, null, null, null);
       List<Integer> actual = input.toList();
       assertEquals(expected,actual);
    }

    @Test
    public void testIsEmpty(){
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(10);
        input.addLast(5);
        input.addLast(7);
        input.addLast(13);
        boolean actual = input.isEmpty();
        boolean expected = false;
        assertEquals(expected,actual);
        ArrayDeque<Integer> input2 = new ArrayDeque<>();
        boolean actual2 = input2.isEmpty();
        boolean expected2 = true;
        assertEquals(expected2,actual2);
    }

    @Test
    public void testSize(){
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(10);
        input.addLast(5);
        input.addLast(7);
        input.addLast(13);
        int expected = 4;
        int actual = input.size();
        assertEquals(expected,actual);
    }

    @Test
    public void testRemoveFirst(){
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(10);
        input.addLast(5);
        input.addLast(7);
        input.addLast(13);
        int expected = 10;
        int actual = input.removeFirst();
        assertEquals(expected,actual);
    }
//remove more
    @Test
    public void testRemoveLast(){
       ArrayDeque<Integer> input = new ArrayDeque<>();
       input.addFirst(10);
       input.addFirst(5);
       input.addFirst(7);
       input.addFirst(13);
       int actual = input.removeLast();
       int expected = 10;
       assertEquals(expected,actual);
    }
    //to test resize
    @Test
    public void testRemove(){
        ArrayDeque<Integer> input = new ArrayDeque<>();
        for(int i = 0;i<8;i++){
            input.addLast(i);
        }
        input.removeFirst();
        input.removeLast();
        input.removeFirst();
        input.removeLast();
        input.removeFirst();
        input.removeLast();
        assertEquals(2,input.size());
    }
    @Test
    public void testGet(){
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(10);
        input.addLast(5);
        input.addLast(7);
        input.addLast(13);
        int expected = 7;
        int actual = input.get(2);
        assertEquals(expected,actual);
    }

    @Test
    public void testResize(){
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(10);
        input.addLast(5);
        input.addLast(7);
        input.addLast(13);
        input.addLast(3);
        input.addLast(4);
        input.addLast(5);
        input.addLast(6);
        input.resize(2);
        input.addLast(7);
        List<Integer> expected = Arrays.asList(10,5,7,13,3,4,5,6,7,null,null,null,null,null,null,null);
        List<Integer> actual = input.toList();
        assertEquals(expected,actual);

    }

    @Test
    public void testEquals() {
        ArrayDeque<Integer> input = new ArrayDeque<>();
        input.addLast(10);
        input.addLast(5);
        input.addLast(7);
        input.addLast(13);
        input.addLast(3);
        input.addLast(4);
        input.addLast(5);
        input.addLast(6);
        ArrayDeque<Integer> input2 = new ArrayDeque<>();
        input2.addLast(10);
        input2.addLast(5);
        input2.addLast(7);
        input2.addLast(13);
        input2.addLast(3);
        input2.addLast(4);
        input2.addLast(5);
        input2.addLast(6);
        boolean actual = input.equals(input2);
       boolean expected = true;
       assertEquals(expected,actual);
    }


}
