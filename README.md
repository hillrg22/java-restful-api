# java-restful-api

## Setup
- After cloning this database, open the project in an IDE (Eclipse, IntelliJ, etc...) and run the NotesRestAPI.java class. (Alternatively, you can compile and run it in your terminal)
- The server should be up and running at this point on localhost:4567

## Testing Routes
- Using Postman or another tool of your choice, run the following:
 1. Post   http://localhost:4567/api/notes  {"body": "Walk the Dog", "id": 1}
 2. Post   http://localhost:4567/api/notes  {"body": "Fold and put away clothes", "id": 2}
- Now you should have some data in there. Now, go ahead and send a GET request for all the notes, or for just ONE note. Here you should see the complete list of notes, then just the note with an id of 2.:
1. Get http://localhost:4567/api/notes
2. Get http://localhost:4567/api/notes/2
- Now, let's delete one of the notes, then we will check the list of all notes to ensure that the note with id:2 is gone:
1. Delete http://localhost:4567/api/notes/2
2. Get http://localhost:4567/api/notes




## To-Do
[x] Create API with POST, GET, GET All, PUT(update), DELETE paths
[ ] Pass in optional query parameter allowing user to search notes by their bodies
[ ] Automatically add in serialized id to each entry, without having to manually enter it in POST request
