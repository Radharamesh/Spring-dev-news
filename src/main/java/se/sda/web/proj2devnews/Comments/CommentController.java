package se.sda.web.proj2devnews.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService CommentService;

    @GetMapping("")
    public List<Comment> getAll(@RequestParam(required = false) Long articleId) {
        if (articleId == null) {
            return CommentService.getAll();
        }
        else {
            return CommentService.getAllByArticleId(articleId);
        }

    }

    //Get a specific task by its id
    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id) {
        return CommentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Create a task
    @PostMapping("")
    public Comment create(@RequestBody Comment newComment) {
        return CommentService.create(newComment);
    }

    //Create a task
    @PutMapping("")
    public Comment update(@RequestBody Comment updateComment) {
        return CommentService.update(updateComment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        CommentService.delete(id);
    }
}
