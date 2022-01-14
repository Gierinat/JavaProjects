public class ToDoItem {
    private String summary;
    private boolean isDone;

    public ToDoItem(String summary) {
        this.summary = summary;
        this.isDone = false;
    }

    public void setDone() {
        isDone = true;
    }
    public void setToDo() {
        isDone = false;
    }

    public void setSummary(String updatedSummary) {
        summary = updatedSummary;
    }

    public String toString() {
        String out = this.summary + " | ";

        if (this.isDone) {
            out += "DONE";
        } else {
            out += "TO DO";
        }
        return out;
    }
}