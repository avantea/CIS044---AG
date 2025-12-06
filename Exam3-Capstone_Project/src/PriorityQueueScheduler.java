import java.util.ArrayList;
import java.util.List;

// Max-heap priority queue
public class PriorityQueueScheduler {

    private List<Job> heap;

    public PriorityQueueScheduler() {
        this.heap = new ArrayList<>();
    }

    public void addJob(Job job) {
        heap.add(job); // add to end
        heapifyUp(heap.size() - 1);
    }

    public Job peekNextJob() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0); // root
    }

    public Job pollNextJob() {
        if (heap.isEmpty()) {
            return null;
        }

        Job root = heap.get(0);
        Job last = heap.get(heap.size() - 1);

        heap.set(0, last);               // move last to root
        heap.remove(heap.size() - 1);    // remove last

        if (!heap.isEmpty()) {
            heapifyDown(0);
        }

        return root;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // ----- heap helper methods -----

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = getParentIndex(index);

            Job current = heap.get(index);
            Job parent = heap.get(parentIndex);


            if (current.getPriority() > parent.getPriority()) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();

        while (index < size) {
            int left = getLeftChildIndex(index);
            int right = getRightChildIndex(index);
            int largest = index;

            if (left < size &&
                    heap.get(left).getPriority() > heap.get(largest).getPriority()) {
                largest = left;
            }

            if (right < size &&
                    heap.get(right).getPriority() > heap.get(largest).getPriority()) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        Job temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

