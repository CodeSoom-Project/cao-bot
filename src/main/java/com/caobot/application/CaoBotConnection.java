package com.caobot.application;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

@Service
public class CaoBotConnection {
//    private Configuration configuration;

//    public CaoBotConnection(Configuration configuration) {
//        this.configuration = configuration;
//    }

    private static JDA jda;

//    @Value("${user.token}")
//    private void setBotToken(String value) {
//        this.bot_token = value;
//    }

    public static void start() {
        try {
            jda = JDABuilder.createDefault(AccountType.BOT.name())
                    .setToken(getBotTokenFromUser())
                    .addEventListeners(new MessageService())
                    .setActivity(Activity.watching("cao-bot 운영 중!"))
                    .build();

            System.out.println("Finished Building JDA!");
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        jda.shutdown();
        System.out.println("Finished Stopping JDA!");
    }

    private static String getBotTokenFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("token 값을 입력하세요: ");
        String botToken = sc.nextLine();

        return botToken;
    }
}
