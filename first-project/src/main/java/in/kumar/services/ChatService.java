package in.kumar.services;

import in.kumar.entity.Demo;

public interface ChatService {

    //entity type return
    Demo Chat(String query);

    // string type return
    String ChatAi(String query);
}
