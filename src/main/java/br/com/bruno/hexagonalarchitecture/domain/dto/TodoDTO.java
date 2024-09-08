package br.com.bruno.hexagonalarchitecture.domain.dto;

import br.com.bruno.hexagonalarchitecture.domain.Todo;

public record TodoDTO(
    Long id,
    String description,
    boolean done
) {
    public TodoDTO(Todo todo) {
        this(todo.getId(), todo.getDescription(), todo.isDone());
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

        public TodoDTO build() {
            return new TodoDTO(id, description, done);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
