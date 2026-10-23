package in.kumar.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }



    @Override
    public String Chat(String query) {
   String  response =  chatClient.prompt()
                .user(query) // userPrompt
                .call()
                .content();



        return response;
    }
}
