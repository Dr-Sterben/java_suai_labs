package ru.labs.lab04;

import java.util.*;

public class SortedIntegerListEdit {
    private LinkedList<Integer> list;
    private final boolean allowDuplicates;
    private boolean directionOfSort;

    public SortedIntegerListEdit(boolean allowDuplicates, boolean directionOfSort) {
        this.list = new LinkedList<>();
        this.allowDuplicates = allowDuplicates;
        this.directionOfSort = directionOfSort;
    }

    public void add(int value) {
        if (!allowDuplicates && list.contains(value)) {
            return;
        }
        if (directionOfSort == true) {
            ListIterator<Integer> iter = list.listIterator();
            while (iter.hasNext()) {
                if (value < iter.next()) {
                    iter.previous();
                    iter.add(value);
                    return;
                }
            }
        }
        else {
            ListIterator<Integer> iter = list.listIterator();
            while (iter.hasNext()) {
                if (value > iter.next()) {
                    iter.previous();
                    iter.add(value);
                    return;
                }
            }
        }

        list.add(value);
    }

    void reverse() {
        this.directionOfSort = !this.directionOfSort;
        SortedIntegerListEdit n = new SortedIntegerListEdit(this.allowDuplicates, this.directionOfSort);
        ListIterator<Integer> iterN = n.list.listIterator();
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            iterN.add(iter.next());
            iterN.previous();
        }
        this.list = n.list;
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
        if (!(obj instanceof SortedIntegerListEdit)) {
            return false;
        }

        SortedIntegerListEdit other = (SortedIntegerListEdit) obj;

        if (this.allowDuplicates != other.allowDuplicates) {
            return false;
        }

        if (this.directionOfSort != other.directionOfSort){
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