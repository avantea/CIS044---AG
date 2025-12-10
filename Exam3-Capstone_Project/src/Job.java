public class Job {

    // Unique identifier for the job
    private int id;

    // Quick description of what the job is
    private String description;

    // Priority of this job (higher number means higher priority)
    private int priority;


    public Job(int id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Getter for priority
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{id=" + id +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}


