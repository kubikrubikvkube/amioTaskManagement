package com.github.kubikrubikvkube.amioTaskManagement.service;

import com.github.kubikrubikvkube.amioTaskManagement.entity.Task;
import com.github.kubikrubikvkube.amioTaskManagement.entity.TeamMember;
import com.github.kubikrubikvkube.amioTaskManagement.repository.TaskRepository;
import com.github.kubikrubikvkube.amioTaskManagement.repository.TeamMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.github.kubikrubikvkube.amioTaskManagement.entity.TaskProgressStatus.IN_PROGRESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.collection;

@SpringBootTest
public class TaskAssigmentTest {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TeamMemberRepository teamMemberRepository;

    @Test
    @DisplayName("Задачи ассайнятся на членов команды и сохраняются в репозиторий")
    public void test_task_assigment() {

        assertThat(taskRepository.count()).isEqualTo(0);
        assertThat(teamMemberRepository.count()).isEqualTo(0);

        Task task = new Task();
        task.setName("test");
        task.setProgressStatus(IN_PROGRESS);

        TeamMember teamMember = new TeamMember();
        teamMember.setName("test");
        teamMember.setTasks(List.of(task));
        var savedTeamMember = teamMemberRepository.save(teamMember);

        assertThat(teamMemberRepository.count()).isEqualTo(1);
        assertThat(taskRepository.count()).isEqualTo(1);

        assertThat(savedTeamMember)
                .isNotNull()
                .extracting("tasks")
                .asInstanceOf(collection(Task.class))
                .hasSize(1)
                .allMatch(e -> e.getId() != null);
    }
}
