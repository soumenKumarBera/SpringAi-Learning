package in.kumar.services;

import in.kumar.entity.Demo;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatClient chatClient;





    @Override
    public Demo Chat(String query) {
   Demo  demo =  chatClient.prompt()
                .user(query) // userPrompt
                .call()
                .entity(Demo.class);

        return demo;
    }

    @Override
    public String ChatAi(String query) {

       String response =  chatClient.prompt()
                .user(query)
                .call()
                .content();
        return response;
    }


}
