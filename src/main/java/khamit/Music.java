package khamit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Music {
    public void  getSong();
}
@Component
@Scope("singleton")
class  ClassicMusic implements  Music{
    @PostConstruct
    public void doMyInit(){
        System.out.println("Privet");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Poka");
    }

    @Override
    public void getSong() {
        System.out.println("Classic music");
    }
}
@Component
class  RockMusic implements  Music{
    @Override
    public void getSong() {
        System.out.println("Rock music");
    }
}
@Component
@Scope("singleton")
class PlayMusic{
    private List<Music> music =new ArrayList<>();
    private khamit.Music musical;
    @Value("${PlayMusic.name}")
    private String name;

    public PlayMusic(RockMusic rockMusic, ClassicMusic classicMusic) {
        music.add(rockMusic);
        musical=classicMusic;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public void setMusical( @Qualifier("classicMusic") Music musical) {

        this.musical = musical;
    }

    @Autowired
    PlayMusic(List<Music> music){
        this.music=music;

    }
    PlayMusic(){
    }
    @Autowired
    public void setMusic(List<Music> music) {
        this.music = music;
    }

    public void playmusic(){

        for(Music o:music){
            o.getSong();
        }
        musical.getSong();
        System.out.println(name);
    }
    public String playMusic1() {

        Random random = new Random();

        return "Playing: " + music.get(random.nextInt(music.size())).getSong()
                + " with volume " ;
    }

}
