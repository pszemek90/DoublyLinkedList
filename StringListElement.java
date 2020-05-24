package sda._200523.DoublyLinkedList;

public class StringListElement {
    private String value;
    private StringListElement nextElement;
    private StringListElement previousElement;


    public StringListElement() {

    }

    public StringListElement(String value) {
        this.value = value;
    }

    public StringListElement getPreviousElement() {
        return previousElement;
    }

    public void setPreviousElement(StringListElement previousElement) {
        this.previousElement = previousElement;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringListElement getNextElement() {
        return nextElement;
    }

    public void setNextElement(StringListElement nextElement) {
        this.nextElement = nextElement;
    }
}
