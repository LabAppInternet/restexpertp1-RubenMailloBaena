package cat.tecnocampus.notes.application.DTOs;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class UserLabDTO {

    private String username;

    @Size(min=3, message = "It must have a min. of 3 characters")
    @Pattern(regexp = "^[A-Z].*", message = "It has to start with a capital letter")
    private String name;

    @Size(min=3, message = "It must have a min. of 3 characters")
    @Pattern(regexp = "^[A-Z].*", message = "It has to start with a capital letter")
    private String secondName;

    @Email(message = "Not valid email")
    @NotEmpty(message = "can't be empty")
    @NotNull(message = "can't be null")
    private String email;

    private final Map<String, NoteLabDTO> ownedNotes;

    public UserLabDTO() {
        ownedNotes = new HashMap<String, NoteLabDTO>();
    }

    public UserLabDTO(String username, String name, String secondName, String email) {
        ownedNotes = new HashMap<>();

        this.username = username;
        this.name = name;
        this.secondName = secondName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public List<NoteLabDTO> getOwnedNotes() {
        return new ArrayList<NoteLabDTO>(ownedNotes.values());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOwnedNotes(List<NoteLabDTO> ownedNotes) {
        this.ownedNotes.clear();
        ownedNotes.forEach(note -> this.ownedNotes.put(note.getTitle(), note));
    }
}