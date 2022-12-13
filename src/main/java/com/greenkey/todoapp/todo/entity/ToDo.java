package com.greenkey.todoapp.todo.entity;

// 2022.12.12(월) 14h45

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.greenkey.todoapp.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ToDo extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 1000)
    private String title;

    @Column(nullable = true)
    private Integer toDoOrder; // 원시 타입 int에 null이 들어오지 않도록 하든가(우선순위 없는 to-do 항목은 0 입력) vs 이 속성 타입을 Integer로 하고 null이 들어올 수 있도록 한다?

    @Column(nullable = false)
    private boolean completed;

    // 2022.12.13(화) 11h api 테스팅용 추가
    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", toDoOrder=" + toDoOrder +
                ", completed=" + completed +
                '}';
    }
}
