
import java.util.Collection;


public interface NoteService {
	public void addNote(Note note);
	
	public Collection<Note> getNotes();
	
//	public Collection<Note> getMatchingNotes(String body);
	
	public Note getNote(String id);
	
	public Note editNote(Note note) throws NoteException;
	
	public void deleteNote(String id);
	
	public boolean noteExist(String id);

	
	
}
