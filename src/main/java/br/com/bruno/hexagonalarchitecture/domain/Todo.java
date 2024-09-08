package br.com.bruno.hexagonalarchitecture.domain;

import java.util.Objects;

public class Todo {
    private Long id;
    private String description;
    private boolean done;

    public Todo() {
    }

    public Todo(Long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public static class Builder {
        private Long id;
        private String description;
        private boolean done;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder done(boolean done) {
            this.done = done;
            return this;
        }

        public Todo build() {
            return new Todo(id, description, done);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return done == todo.done && Objects.equals(id, todo.id) && Objects.equals(description, todo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, done);
    }
}
