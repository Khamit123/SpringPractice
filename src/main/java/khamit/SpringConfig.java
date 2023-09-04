package khamit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayers.properties")
@ComponentScan("khamit")
public class SpringConfig {
    @Bean
    public ClassicMusic classicMusic(){
        return  new ClassicMusic();
    }
    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
    @Bean
    public List<Music> musicList(){
        return Arrays.asList(rockMusic(),classicMusic());
    }



    @Bean PlayMusic playMusic(){
        return new PlayMusic(musicList());
    }

}
