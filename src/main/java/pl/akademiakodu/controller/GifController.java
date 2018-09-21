package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.data.GifRepository;
import pl.akademiakodu.model.Gif;

import javax.jws.WebParam;
import java.util.List;


@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

   @RequestMapping("/")
  //@ResponseBody
       public String listGifs(ModelMap modelMap) {
       List<Gif> gifs = gifRepository.getAllGifs();
       modelMap.put("gifs", gifs);
       return "home";
    }

    @RequestMapping ("/gif/{name}")
        public String gifDetails(@PathVariable String name, ModelMap modelMap) {
       //Gif gif = new Gif("cowboy-coder", "michalos", true);
         Gif gif = gifRepository.findByName(name);
            modelMap.put("gif",gif);
            return "gif-details";

    }

    @RequestMapping ("/favorites")
    public String getFavorites(ModelMap modelMap) {
       List<Gif> gifs = gifRepository.getFavorites();
       modelMap.put("gifs", gifs);
       return "favorites";


    }

}
