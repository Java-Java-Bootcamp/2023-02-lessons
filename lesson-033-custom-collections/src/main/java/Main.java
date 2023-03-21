import ru.otus.ArrayList;
import ru.otus.Iterator;
import ru.otus.LinkedList;
import ru.otus.List;

public class Main {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();

        populateList(arrayList);
        populateList(linkedList);

        System.out.println(arrayList.get(3));
        System.out.println(linkedList.get(3));

        for (Object item : arrayList) {
            // java iterable + iterator behind the scene
        }

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object item = iterator.next();
            // some logic on item here
        }
    }

    private static void populateList(List myList) {
        for (int i = 1; i < 5; i++) {
            myList.add(i);
        }
    }
}
