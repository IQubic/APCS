import java.util.ArrayList;

public class Reverse {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
        reverse(list);
        System.out.println(list);
    }

    public static void reverse(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return;
        }

        int first = list.remove(0);
        reverse(list);
        list.add(first);
    }
}
