public class Main {
    public static void main(String[] args) {
        PriorityQueueScheduler scheduler = new PriorityQueueScheduler();

        scheduler.addJob(new Job(1, "Normal task", 5));
        scheduler.addJob(new Job(2, "Urgent task", 10));
        scheduler.addJob(new Job(3, "Low priority task", 1));

        System.out.println("Next job: " + scheduler.peekNextJob());
        System.out.println("Polling jobs in priority order:");

        while (!scheduler.isEmpty()) {
            System.out.println(scheduler.pollNextJob());
        }
    }
}

