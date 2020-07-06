import java.util.Collection;
import java.util.HashMap;

public class NoteServiceMapImpl implements NoteService {
    private HashMap<String, Note> noteMap;

    public NoteServiceMapImpl() {
        noteMap = new HashMap<>();
    }

    @Override
    public void addNote(Note note) {
        noteMap.put(note.getId(), note);
    }

    @Override
    public Collection<Note> getNotes() {
        return noteMap.values();
    }
    
//    @Override
//    public Collection<Note> getMatchingNotes(String input) {
//        return noteMap.values();
//    }

    @Override
    public Note getNote(String id) {
        return noteMap.get(id);
    }

    @Override
    public Note editNote(Note forEdit) throws NoteException {
        try {
            if (forEdit.getId() == null)
                throw new NoteException("ID cannot be blank");

            Note toEdit = noteMap.get(forEdit.getId());

            if (toEdit == null)
                throw new NoteException("Note not found");

            
            if (forEdit.getBody() != null) {
                toEdit.setBody(forEdit.getBody());
            }
            if (forEdit.getId() != null) {
                toEdit.setId(forEdit.getId());
            }

            return toEdit;
        } catch (Exception ex) {
            throw new NoteException(ex.getMessage());
        }
    }

    @Override
    public void deleteNote(String id) {
        noteMap.remove(id);
    }

    @Override
    public boolean noteExist(String id) {
        return noteMap.containsKey(id);
    }

}