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
            if (first.getNextElement() != null)
                first = first.getNextElement();
            else {
                first = null;
            }
            return true;
        }
        while (element.getNextElement() != null) {
            if (element.getNextElement().getValue().equals(value)) {
                element.setNextElement(element.getNextElement().getNextElement());
                return true;
            }
            element = element.getNextElement();
        }
        return false;
    }

    public boolean addAt(String value, int index){
        if(index > size())
            return false;
        if(index == size()){
            add(value);
            return true;
        }
        StringListElement element = new StringListElement(value);
        if(index == 0){
            element.setNextElement(first);
            first = element;
            return true;
        }
        StringListElement tmp = first;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.getNextElement();
        }
        element.setNextElement(tmp.getNextElement());
        tmp.setNextElement(element);
        return true;
    }
}
