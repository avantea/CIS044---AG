public class Main {
    public static void main(String[] args) {
        // Create a new priority queue scheduler
        PriorityQueueScheduler scheduler = new PriorityQueueScheduler();

        // Add some jobs with different priorities
        scheduler.addJob(new Job(1, "Normal task", 5));
        scheduler.addJob(new Job(2, "Urgent task", 10));
        scheduler.addJob(new Job(3, "Low priority task", 1));

        // Show the next job (but do not remove it yet)
        System.out.println("Next job (peek): " + scheduler.peekNextJob());

        // Poll jobs until the scheduler is empty
        System.out.println("Polling jobs in order of priority:");
        while (!scheduler.isEmpty()) {
            System.out.println(scheduler.pollNextJob());
        }
    }
}


