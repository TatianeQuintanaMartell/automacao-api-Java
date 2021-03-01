package Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"title","description","deadline","done"})
public class CreateTaskModel {

    private String title;
    private String description;
    private String deadline;
    private boolean done;

    public CreateTaskModel() {
        title = "Tarefa1";
        description = "Descricao da tarefa";
        deadline = "2018-08-21 15:00:00";
        done = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
