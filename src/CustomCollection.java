public class CustomCollection<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CustomCollection() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomCollection(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    public void addElement(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    public void removeElement(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                removeElementAtIndex(i);
                return;
            }
        }
    }

    private void removeElementAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }

        elements[--size] = null;
    }

    public T getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    public boolean containsElement(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public void clearCollection() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public static void main(String[] args) {
        CustomCollection<String> customCollection = new CustomCollection<>();

        customCollection.addElement("Элемент1");
        customCollection.addElement("Элемент2");
        customCollection.addElement("Элемент3");

        for (int i = 0; i < customCollection.size; i++) {
            System.out.println(customCollection.getElement(i));
        }

        System.out.println("Элемент по индексу 1: " + customCollection.getElement(1));

        customCollection.removeElement("Элемент2");

        System.out.println("После удаления:");
        for (int i = 0; i < customCollection.size; i++) {
            System.out.println(customCollection.getElement(i));
        }

        System.out.println("Содержит \"Элемент2\": " + customCollection.containsElement("Элемент2"));
        System.out.println("Содержит \"Элемент3\": " + customCollection.containsElement("Элемент3"));

        customCollection.clearCollection();

        System.out.println("После очистки:");
        for (int i = 0; i < customCollection.size; i++) {
            System.out.println(customCollection.getElement(i));
        }
    }
}
