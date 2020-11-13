package se.sda.web.proj2devnews.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("")
    public List<Topic> getAll(@RequestParam(required = false) Long articleId) {

        if (articleId == null) {
            return topicService.getAll();
        } else {
            return topicService.getAllByArticleId(articleId);
        }
    }


    //Get a specific task by its id
    @GetMapping("/{id}")
    public Topic getById(@PathVariable Long id) {
        return topicService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Create a task
    @PostMapping("")
    public Topic create(@RequestBody Topic newTopic) {
        return topicService.create(newTopic);
    }

    //Create a task
    @PutMapping("")
    public Topic update(@RequestBody Topic updatedTopic) {
        return topicService.update(updatedTopic);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        topicService.delete(id);
    }
}
