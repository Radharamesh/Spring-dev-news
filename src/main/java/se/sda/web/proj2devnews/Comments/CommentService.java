package se.sda.web.proj2devnews.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepo repo;


    public List<Comment> getAll() {
        return repo.findAll();
    }

    public Optional<Comment> getById(Long id) {
        return repo.findById(id);
    }

    public Comment create(Comment newComment) {
        return repo.save(newComment);
    }

    public Comment update(Comment updatedComment) {
        return repo.save(updatedComment);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Comment> getAllByArticleId(Long articleId) {
       return repo.findAllByArticleId(articleId);
    }
}
