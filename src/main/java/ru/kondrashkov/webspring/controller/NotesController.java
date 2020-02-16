package ru.kondrashkov.webspring.controller;
import ru.kondrashkov.webspring.ResourceNotFoundException;
import ru.kondrashkov.webspring.entity.Notes;
import ru.kondrashkov.webspring.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class NotesController {
    @Autowired
    private NotesRepository notesRepository;

    @GetMapping("/notes")
    public List<Notes> getNotes() {
        return notesRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Notes getNotesById(@PathVariable Long id) {
        Optional<Notes> notes = notesRepository.findById(id);
        return notes.orElseThrow(() -> new ResourceNotFoundException("Notes not found.Id = " + id));
    }

    @PostMapping("/notes")
    public Notes createNotes(@Valid @RequestBody Notes notes) {
        return notesRepository.save(notes);
    }

    @PutMapping("/notes{notesId}")
    public Notes updateNotes(@PathVariable Long notesId, @Valid @RequestBody Notes notesRequest) throws ParseException {

        return notesRepository.findById(notesId)
                .map(notes -> {
                    notes.setHeader(notesRequest.getHeader());
                    notes.setNote(notesRequest.getNote());
                    return notesRepository.save(notes);
                }).orElseThrow(() -> new ResourceNotFoundException("Notes not found with id " +
                        notesId));
    }

    @DeleteMapping("/notes/{notesId}")
    public ResponseEntity<?> deleteNotes(@PathVariable Long notesId) {
        return notesRepository.findById(notesId)
                .map(notes -> {
                    notesRepository.delete(notes);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Notes not found with id " +
                        notesId));
    }
}
