package in.kumar.controller;

import in.kumar.entity.Demo;
import in.kumar.services.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;

@RestController
@RequestMapping
public class ChatController {

        @Autowired
        private ChatService chatService;


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




}
