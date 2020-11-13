package se.sda.web.proj2devnews.Articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

     @GetMapping("")
    public List<Article> getAll(@RequestParam(required = false) Long topicId){
         if(topicId == null){
             return articleService.getAll();
         }
         else {
             return articleService.getAllByTopicId(topicId);
         }
     }


    //Get a specific task by its id
    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Create a task
    @PostMapping("")
    public Article create(@RequestBody Article newArticle) {
        return articleService.create(newArticle);
    }

    //Create a task
    @PutMapping("")
    public Article update(@RequestBody Article newArticle) {
        return articleService.update(newArticle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}
