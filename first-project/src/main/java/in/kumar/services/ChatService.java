package in.kumar.services;

import in.kumar.entity.Demo;
import org.jspecify.annotations.Nullable;
import reactor.core.publisher.Flux;

public interface ChatService {

    //entity type return
    Demo Chat(String query);

    // string type return
    String ChatAi(String query);

    @Nullable Flux<String> streamChat(String query);
}
