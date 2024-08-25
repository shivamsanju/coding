package DynamicArray;

public class ArrayList {
    private int[] array;
    public int size;
    public int capacity;

    public ArrayList(int capacity) {
        array = new int[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void push(int n) {
        if (size == capacity) {
            increaseSize();
        }
        array[size] = n;
        size++;
    }

    public void pop() {
        size--;
    }

    public void increaseSize() {
        int[] newArray = new int[capacity * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        capacity *= 2;
    }

}
