package org.ahad.reactive;

import java.util.*;

public class IteratorExercise {

    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<>(Set.of("Messi", "Neymar", "Ronaldo", "Mbappe", "Lamine", "Jude", "Halland"));
        Iterator<String> treeIterator = treeSet.iterator();
        while (treeIterator.hasNext()) {
            System.out.println(treeIterator.next());
        }
        System.out.println();
        ArrayList<String> arrayList = new ArrayList<>(List.of("Messi", "Neymar", "Ronaldo", "Mbappe", "Lamine", "Jude", "Halland"));
        Iterator<String> arrayIterator = arrayList.iterator();
        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }
    }
}
