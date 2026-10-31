package in.kumar.services;

import in.kumar.entity.Demo;
import org.jspecify.annotations.Nullable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatClient chatClient;

    @Value("${classpath:/propatice/user-message.st}")
    private Resource  userMes;





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

    //.Streaming Responses
    @Override
    public Flux<String> streamChat(String query) {

        return chatClient
                .prompt()
                .user(query)
                .stream()
                .content();

    }

    public String chatTemplate(){

//        PromptTemplate strTemplate = PromptTemplate.builder().template("what is {techName}? tell me example {example}").build();
//        String renderMessage = strTemplate.render(Map.of(
//                "techName", "Spring",
//                "example", "SpringBoot"
//        ));
//
//       Prompt prompt = new Prompt(renderMessage);

      var content = chatClient.prompt()
              .system(system -> system.text("Your are helpinng codinng asistennt"))
              .user(u -> u.text(userMes).param("concept", "spring"))
               .call()
               .content();

      return content;
    }

}
