package khamit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.Annotation;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                =new ClassPathXmlApplicationContext("Context2.xml");
        AnnotationConfigApplicationContext context1=new AnnotationConfigApplicationContext(SpringConfig.class);
       //Music sb= context.getBean("SpamMusic",khamit.Music.class);
        //PlayMusic pianino=new khamit.PlayMusic(sb);
        PlayMusic playMusic=context1.getBean("playMusic",PlayMusic.class);
        playMusic.playmusic();
        context.close();
        context1.close();
    }
}
