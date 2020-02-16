package ru.kondrashkov.webspring.repository;
import ru.kondrashkov.webspring.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
}
