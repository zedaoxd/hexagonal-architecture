package br.com.bruno.hexagonalarchitecture.adapter.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean done;
}
