import java.util.*;

interface IntNumber{
    void ins(int item);
    int delt();
}

class H implements IntNumber{
    private int stck[];
    private int pos;

    H(int size){
        stck = new int[size];
        pos = -1;
    }

    public void ins(int item){
        if(pos == stck.length-1){
            System.out.println("Overflow");
        }
        else{
            stck[++pos] = item;
        }
    }

    public int delt(){
        if(pos < 0){
            System.out.println("Underflow");
            return 0;

        }
        else{
            return stck[pos--];
        }
    }
}

public class Test {
    public static void main(String[] args) {
        H obj = new H(3);
        for(int i = 0; i < 4; i++) obj.ins(i);
        for(int i = 0; i <= 3; i++)
            System.out.println(obj.delt());
    }
}
