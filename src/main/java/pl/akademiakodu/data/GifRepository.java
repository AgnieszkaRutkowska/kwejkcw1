package pl.akademiakodu.data;

import org.springframework.stereotype.Component;
import pl.akademiakodu.model.Gif;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList (
        new Gif("android-explosion", "michalos", true),
        new Gif("ben-and-mike", "mike", true),
        new Gif("book-dominos", "ola", true),
        new Gif("compiler-bot", "bot", true),
        new Gif("cowboy-coder", "coder", true),
        new Gif("infinite-andrew", "andrew", true)
        );

    public Gif findByName(String name) {

        for(Gif gif : ALL_GIFS) {

            if (gif.getName().equals(name)) {
                return gif;
               }
            }
            return null;
        }
        public List<Gif> getAllGifs(){
          return ALL_GIFS;


        }


}
