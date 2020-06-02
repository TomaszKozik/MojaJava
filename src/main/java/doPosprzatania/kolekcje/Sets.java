package doPosprzatania.kolekcje;

import java.util.*;

class SetUtils {

    /**
     * @return symmetric difference between set1 and set2
     */
    public static Set<String> symmetricDifference(Set<String> set1, Set<String> set2) {
        Set<String> set3 = new HashSet<>(set1);
        set1.removeAll(set2);
        set2.removeAll(set3);
        set1.addAll(set2);
        return set1;
    }

}

/* Do not change the code below */
class Main {
    public static void main(String[] args) {
/*
        Set<Integer> a1 = new HashSet<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);

        Set<Integer> a2 = new HashSet<>();
        a2.add(0);
        a2.add(1);
        a2.add(2);

        System.out.println(a1);

        Set<Integer> a3 = new HashSet<>(a1);
        a1.removeAll(a2);
        a2.removeAll(a3);
        System.out.println(a1);
        System.out.println(a2);

        a1.addAll(a2);
        System.out.println(a1);

*/


        Scanner scanner = new Scanner(System.in);

        String strSet1 = scanner.nextLine();
        String strSet2 = scanner.nextLine();

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        if (!Objects.equals(strSet1, "empty")) {
            Collections.addAll(set1, strSet1.split("\\s+"));
        }

        if (!Objects.equals(strSet2, "empty")) {
            Collections.addAll(set2, strSet2.split("\\s+"));
        }

        Set<String> resultSet = SetUtils.symmetricDifference(set1, set2);

        System.out.println(String.join(" ", resultSet));
    }
}