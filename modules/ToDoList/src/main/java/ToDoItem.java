public class ToDoItem {
    private String summary;
    private boolean isDone;

    public ToDoItem(String summary) {
        this.summary = summary;
        this.isDone = false;
    }

    //TODO add setToDo method; refactor so signature do not take parameter
    public void setDone(boolean done) {
        isDone = done;
    }

    public void setSummary(String updatedSummary) {
        summary = updatedSummary;
    }

    //TODO override toString
    public void printTask() {
        System.out.print(this.summary + " | ");
        if (this.isDone) {
            System.out.println("DONE");
        } else {
            System.out.println("TO DO");
        }
    }
}