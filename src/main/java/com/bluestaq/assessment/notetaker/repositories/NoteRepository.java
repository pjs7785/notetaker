package com.bluestaq.assessment.notetaker.repositories;

import com.bluestaq.assessment.notetaker.data.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByUserUserName(String username);
}
