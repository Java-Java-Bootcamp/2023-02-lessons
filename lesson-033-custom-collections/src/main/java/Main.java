import ru.otus.ArrayList;
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
    }

    private static void populateList(List myList) {
        for (int i = 1; i < 5; i++) {
            myList.add(i);
        }
    }
}
