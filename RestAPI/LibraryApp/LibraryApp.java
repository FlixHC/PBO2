import static spark.Spark.*;
import com.google.gson.Gson;
public class Library {

    public static void main(String[] args) {
        port(4567);
        Gson gson = new Gson();
        bookservice bookService= new bookservice();
        
        path("/api", ()->{
            get("/books", (req, res)->{
                res.type("application/json");
                return bookService.getAll();
            }, gson::toJson);
            
            get("/books/:id", (req, res)->{
                res.type("application/json");
                long id = Long.parseLong(req.params("id"));
                book book = bookService.get(id);
                if (book == null){
                    res.status(404);
                    return "Book not found";
                }
                return book;
            }, gson::toJson);
            
            post("/books", (req, res)->{
                res.type("application/json");
                book book = gson.fromJson (req.body(), book.class);
                return bookService.add(book);
            }, gson::toJson);
            
            put("/books/:id", (req, res)->{
                res.type("application/json");
                long id = Long.parseLong(req.params("id"));
                book book = gson.fromJson (req.body(), book.class);
                return bookService.update(id, book);
            }, gson::toJson);
            
            delete("/books/:id", (req, res)->{
                long id = Long.parseLong(req.params("id"));
                if (bookService.delete(id)){
                    res.status(204);
                    return "";
                } else{
                    res.status(404);
                    return "Book not Found";
                }
            });
        });
    }
}
