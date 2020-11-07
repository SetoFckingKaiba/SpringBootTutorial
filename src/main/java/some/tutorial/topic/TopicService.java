package some.tutorial.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    // Services are Singletons. Spring automatically creates a singleton of
    // this class and injects that singleton everywhere it is referenced using
    // the annotation @Autowired

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "Artur", "dArtur"),
            new Topic("2", "Artur2", "dArtur2")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {

    }
}
