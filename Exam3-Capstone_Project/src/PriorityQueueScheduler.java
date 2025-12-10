import java.util.ArrayList;
import java.util.List;

public class PriorityQueueScheduler {

    // Underlying storage for the heap (array-based binary heap).
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

        // Step 1: store the highest-priority job
        Job root = heap.get(0);

        // Step 2: get the last Job in the heap
        Job last = heap.get(heap.size() - 1);

        // Step 3: move last to the root
        heap.set(0, last);

        // Step 4: remove the extra last slot
        heap.remove(heap.size() - 1);

        // Step 5: restore heap order if not empty
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }

        return root;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = getParentIndex(index);

            Job current = heap.get(index);
            Job parent = heap.get(parentIndex);

            // If current has higher priority than parent, swap them.
            if (current.getPriority() > parent.getPriority()) {
                swap(index, parentIndex);
                index = parentIndex; // continue from parent position
            } else {
                break; // heap is valid
            }
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();

        while (index < size) {
            int left = getLeftChildIndex(index);
            int right = getRightChildIndex(index);
            int largest = index;

            // Check left child
            if (left < size &&
                    heap.get(left).getPriority() > heap.get(largest).getPriority()) {
                largest = left;
            }

            // Check right child
            if (right < size &&
                    heap.get(right).getPriority() > heap.get(largest).getPriority()) {
                largest = right;
            }

            // If one of the children has higher priority, swap and continue
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                // No child is larger → heap property is satisfied
                break;
            }
        }
    }

    // Returns the index of the parent of the node at 'index'
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    // Returns the index of the left child of the node at 'index'
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Returns the index of the right child of the node at 'index'
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Swaps two Jobs in the heap
    private void swap(int i, int j) {
        Job temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
