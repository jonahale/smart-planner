package com.jonah.planner.repository;
import com.jonah.planner.domain.Note;
import com.jonah.planner.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByTitleContainingIgnoreCase(String title);
}
