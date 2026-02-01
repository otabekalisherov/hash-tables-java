import java.util.NoSuchElementException;

public class AuDClosedHashTable extends AuDHashTable{

    private Contact[] table;
    private boolean[] deleted;
    private int counter;

    public AuDClosedHashTable (int capacity) {
        super(capacity);
        table = new Contact[capacity];
        deleted = new boolean[capacity];
        counter = 0;
    }
    public boolean isFull(){
        return counter == capacity;
    }

    protected int hash(String s, int i){
        int base = hash(s);
        int offset = i / 2;

        if (i % 2 == 0){
            return Math.floorMod(base - offset - 1, capacity);
        }else {
            return Math.floorMod(base + offset,capacity);
        }
    }

    @Override
    public void insert (Contact c){
        if (isFull()){
            throw new UnsupportedOperationException();
        }
        int i = 0;
        while (i < capacity){
            int index = hash(c.getEmail(),i);
            if (table[index] == null){
                table [index] = c;
                deleted[index] = false;
                counter++;
                return;
            }
            i++;

        }
    }

    private int getIndexOf(String email){
        int i = 0;

        while (i < capacity) {
            int index = hash(email, i);

            if (table[index] == null && !deleted[index]){
                break;
            }
            if (table[index] != null &&
            table[index].getEmail().equals(email)){
                return index;

            }
            i++;
        }
        throw new NoSuchElementException();
    }
    @Override
    public void remove(Contact c) {
        int index = getIndexOf(c.getEmail());
        table[index] = null;
        deleted[index] = true;
        counter--;
    }

    @Override
    public Contact getContact(String email) {
        int index = getIndexOf(email);
        return table[index];
    }
}
