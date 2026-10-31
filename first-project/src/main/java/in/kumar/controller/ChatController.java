package in.kumar.controller;

import in.kumar.entity.Demo;
import in.kumar.services.ChatService;
import in.kumar.services.ChatServiceImpl;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Stack;

@RestController
@RequestMapping
public class ChatController {

        @Autowired
        private ChatService chatService;

        @Autowired
        private ChatServiceImpl  chatServiceImp;


   //type object return
    @GetMapping("/chat")
    public ResponseEntity<Demo> chat(@RequestParam(value = "q", required = true) String query){

       Demo responseAi = chatService.Chat(query);

        return ResponseEntity.ok(responseAi);
    };


  //type String return
    @GetMapping("/chatAi")
    public ResponseEntity<String> chatAi(@RequestParam(value = "q", required = true) String query){

        String responseAi = chatService.ChatAi(query);


        return ResponseEntity.ok(responseAi);
    };

    @GetMapping("/chatT")
    public ResponseEntity<String> chatTem(){

        String responseAi = chatServiceImp.chatTemplate();


        return ResponseEntity.ok(responseAi);
    };

    //.Streaming Responses
    @GetMapping("/chat_Stream")
    public ResponseEntity<Flux<String>> streamChat(@RequestParam("q") String query){

        return ResponseEntity.ok(chatService.streamChat(query));


    }




}
