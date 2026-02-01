import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AuDOpenHashTable extends AuDHashTable{

    private LinkedList<Contact>[] table;

    public AuDOpenHashTable(int capacity){
        super(capacity);
        table = new LinkedList[capacity];
        for (int i= 0; i < capacity; i++){
            table[i] = new LinkedList<Contact>();
        }
    }
    @Override
    public void insert(Contact c){
        int index = hash(c.getEmail());
        table[index].addLast(c);
    }

    @Override
    public void remove(Contact c){
        int index = hash(c.getEmail());
        boolean removed = table[index].remove(c);
        if (!removed){
            throw new NoSuchElementException();
        }
    }
    @Override
    public Contact getContact(String email) {
        int index = hash(email);
        for (Contact c : table [index]) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        throw new NoSuchElementException();
    }

}
