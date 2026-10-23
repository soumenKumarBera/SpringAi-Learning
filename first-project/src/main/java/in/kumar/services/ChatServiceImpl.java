package in.kumar.services;

import in.kumar.entity.Demo;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }



    @Override
    public Demo Chat(String query) {


   Demo  demo =  chatClient.prompt()
                .user(query) // userPrompt
                .call()
                .entity(Demo.class);



        return demo;
    }
}
