package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class WorkintechList<E> extends ArrayList<E> {
    @Override
    public boolean add(E e) {
        // Tekrar eden data eklenmesini engelle
        if (this.contains(e)) {
            System.out.println("Duplicate data: " + e + " eklenmedi.");
            return false;
        }
        boolean added = super.add(e);
        sort();
        return added;
    }

    @Override
    public void add(int index, E element) {
        // Index ile eklemede de kontrol yap
        if (this.contains(element)) {
            System.out.println("Duplicate data: " + element + " eklenmedi.");
            return;
        }
        super.add(index, element);
        sort();
    }

    @Override
    public boolean addAll(java.util.Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (!this.contains(e)) {
                super.add(e);
                changed = true;
            }
        }
        if (changed) sort();
        return changed;
    }

    @Override
    public boolean addAll(int index, java.util.Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (!this.contains(e)) {
                super.add(e);
                changed = true;
            }
        }
        if (changed) sort();
        return changed;
    }

    // sort metodu
    public void sort() {
        // Eğer Comparable değilse sıralama yapılmaz
        if (!this.isEmpty() && this.get(0) instanceof Comparable) {
            Collections.sort((ArrayList<Comparable>) (ArrayList<?>) this);
        }
    }

    // remove metodu override
    @Override
    public boolean remove(Object o) {
        boolean removed = super.remove(o);
        if (removed) {
            sort();
        }
        return removed;
    }

    // remove metodu: index bazlı
    @Override
    public E remove(int index) {
        E removed = super.remove(index);
        sort();
        return removed;
    }
}
