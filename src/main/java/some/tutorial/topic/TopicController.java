package some.tutorial.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    // The return of these annotated methods are going to be JSON
    // The key names in the JSON are the property names of the (Topic) class
    // This means that you can query data from a database and return the
    // results as a JSON.
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    // Takes {id} and passes it to the function
    // You can also pass a name: /topics/{foo} and then
    // @PathVariable("foo") String id
    // But that's not recommended
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    //@RequestMapping(value = "/topics", method = RequestMethod.POST)
    @PostMapping(value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @PutMapping(value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
    }
}
