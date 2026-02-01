public class ContactDatabase {

    public static void main(String[] args){

        Contact a = new Contact("alice@mail.com");
        a.setName("Alice");

        Contact b = new Contact("bob@mail.com");
        b.setName("Bob");

        Contact c = new Contact("charlie@mail.com");
        c.setName("Charlie");

        AuDOpenHashTable open = new AuDOpenHashTable(5);
        open.insert(a);
        open.insert(b);
        open.insert(c);

        System.out.println(open.getContact("bob@mail.com"));

        open.remove(b);

        AuDClosedHashTable closed = new AuDClosedHashTable(5);
        closed.insert(a);
        closed.insert(b);
        closed.insert(c);

        System.out.println(closed.getContact("charlie@mail.com"));

        closed.remove(a);

    }
}
