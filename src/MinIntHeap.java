import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;
    int [] items;

    public MinIntHeap(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
    }

    private int getLeftChildIndex(int parentIndex) {return 2 * parentIndex + 1;}
    private int getRightChildIndex(int parentIndex) {return 2 * parentIndex + 2;}
    private int getParentIndex(int childIndex) {return (childIndex - 1)/2;}

    private boolean hashLeftChild(int index) {return getLeftChildIndex(index) < size;}
    private boolean hashRightChild(int index) {return getRightChildIndex(index) < size;}
    private boolean hashParent(int index) {return getParentIndex(index) >=0;}

    private int leftChild(int index) {return items[getLeftChildIndex(index)];}
    private int rightChild(int index) {return items[getRightChildIndex(index)];}
    private int parent(int index) {return items[getParentIndex(index)];}

    private void swap (int indexOne, int indexTwo) {
        int temp = this.items[indexOne];
        this.items[indexOne] = this.items[indexTwo];
        this.items[indexTwo]=temp;
    }

    //扩容
    private void ensureExtraCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, this.capacity * 2);
            this.capacity *= 2;
        }
    }

    public int peek() {
        if(size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll() {
        if(size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size -1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyDown() {
        int index = 0;
        while(hashLeftChild(index)) {
            int smallerIndex = getLeftChildIndex(index);
            if(hashRightChild(index)) {
                smallerIndex = (leftChild(index) > rightChild(index) ?  getRightChildIndex(index) : getLeftChildIndex(index));
            }
            if(this.items[index] <= this.items[smallerIndex]) break;
            swap(index, smallerIndex);
            index = smallerIndex;
        }
    }

    public void heapifyUp() {
        int index = this.size - 1;
        while(hashParent(index) && this.items[index] < parent(index)) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

}
