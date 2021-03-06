package sda._200523.DoublyLinkedList;

public class StringList {
    private StringListElement first;
    private StringListElement last;
    private long size;

    public StringList() {

    }

    public StringList(StringList list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    public StringListElement head() {
        return first;
    }

    public StringListElement tail() {
        return last;
    }

    public void add(String value) {
        StringListElement element = new StringListElement(value);
        if (first == null) {
            first = element;
        } else {
            last.setNextElement(element);
            element.setPreviousElement(last);
        }
        last = element;
        size++;

    }

    public long size() {
        return size;
    }

    public String get(long index) {
        if (index > size())
            return "Index out of bounds";
        if (first == null)
            return "List is empty";
        StringListElement element;
        element = first;
        for (int i = 0; i < index; i++) {
            if (element.getNextElement() != null)
                element = element.getNextElement();
        }
        return element.getValue();
    }

    public boolean remove(String value) {
        if (first == null)
            return false;
        StringListElement element;
        element = first;
        if (element.getValue().equals(value)) {
            if (first.getNextElement() != null) {
                first = first.getNextElement();
                first.setPreviousElement(null);
            } else {
                first = null;
            }
            return true;
        }
        while (element != null) {
            if (element.getValue().equals(value)) {
                element.getPreviousElement().setNextElement(element.getNextElement());
                if (element.getNextElement() != null)
                    element.getNextElement().setPreviousElement(element.getPreviousElement());
                else
                    last = element.getPreviousElement();
                size--;
                return true;
            }
            element = element.getNextElement();
        }
        return false;
    }

    public boolean addAt(String value, int index) {
        if (index >= size()) {
            add(value);
            return true;
        }
        StringListElement element = new StringListElement(value);
        if (index == 0) {
            element.setNextElement(first);
            first = element;
            size++;
            return true;
        }
        StringListElement tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNextElement();
        }
        element.setNextElement(tmp);
        element.setPreviousElement(tmp.getPreviousElement());
        tmp.getPreviousElement().setNextElement(element);
        size++;
        return true;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }
}
