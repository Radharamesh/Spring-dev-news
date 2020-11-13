package se.sda.web.proj2devnews.Articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArticleService {

    @Autowired
    private ArticleRepo repo;


    public List<Article> getAll() {
        return repo.findAll();
    }

    public Optional<Article> getById(Long id) {
        return repo.findById(id);
    }

    public Article create(Article newArticle) {
        return repo.save(newArticle);
    }

    public Article update(Article updatedArticle) {
        return repo.save(updatedArticle);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


    public List<Article> getAllByTopicId(Long topicId) {
        return repo.findAllByTopicsId(topicId);
    }
}
