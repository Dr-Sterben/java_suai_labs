package ru.labs.lab04;

import java.util.*;

public class SortedIntegerList {
    private final LinkedList<Integer> list;
    private final boolean allowDuplicates;

    public SortedIntegerList(boolean allowDuplicates) {
        this.list = new LinkedList<>();
        this.allowDuplicates = allowDuplicates;
    }

    public void add(int value) {
        if (!allowDuplicates && list.contains(value)) {
            return;
        }

        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            if (value < iter.next()) {
                iter.previous();
                iter.add(value);
                return;
            }
        }

        list.add(value);
    }

    public void remove(int value) {
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            if (iter.next() == value) {
                iter.remove();
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SortedIntegerList)) {
            return false;
        }

        SortedIntegerList other = (SortedIntegerList) obj;

        if (this.allowDuplicates != other.allowDuplicates) {
            return false;
        }

        if (this.list.size() != other.list.size()) {
            return false;
        }

        Iterator<Integer> thisIter = this.list.iterator();
        Iterator<Integer> otherIter = other.list.iterator();

        while (thisIter.hasNext() && otherIter.hasNext()) {
            if (!thisIter.next().equals(otherIter.next())) {
                return false;
            }
        }

        return true;
    }
}