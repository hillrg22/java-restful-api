
import static spark.Spark.*;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;
import static spark.Spark.put;

import com.google.gson.Gson;

public class NotesRestAPI {
	public static void main(String[] args) {
		final NoteService noteService = new NoteServiceMapImpl();
		
		get("/hello", (req, res) -> "Hello to the World!");
		
		post("/notes", (req, res) -> {
			res.type("application/json");
			
			Note note = new Gson().fromJson(req.body(), Note.class);
			noteService.addNote(note);
			
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
		});
		
		get("/notes", (req, res) ->{
			res.type("application/json");
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(noteService.getNotes())));
			
		});
		
		get("/notes/:id", (req, res) -> {
			res.type("application/json");
			
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(noteService.getNote(req.params(":id")))));
			
		});
		
		put("/notes/:id", (req, res) -> {
			res.type("application/json");
			
			Note toEdit = new Gson().fromJson(req.body(), Note.class);
			Note editedNote = noteService.editNote(toEdit);
			
			if (editedNote != null) {
				return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedNote)));
			} else {
				return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("Note not found or error in edit")));
				
			}
			
		});
		
		delete("/notes/:id", (req, res) -> {
			res.type("application/json");
			
			noteService.deleteNote(req.params(":id"));
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,"note deleted" ));
			
			
		});
		
		options("/notes/:id", (req, res) -> {
			res.type("application/json");
			
			return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, (noteService.noteExist(req.params(":id"))) ? "Note exists" : "Note does not exist."));
		});
		
	}
}
