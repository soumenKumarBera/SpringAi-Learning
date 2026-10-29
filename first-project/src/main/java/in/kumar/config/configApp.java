package in.kumar.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class configApp {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){

        return builder
                .defaultAdvisors(new SimpleLoggerAdvisor(), new SafeGuardAdvisor(List.of("game")))
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("openai/gpt-oss-20b")
                        .temperature(0.3)
                        .maxTokens(200)
                        )
                .build();

    }




}
