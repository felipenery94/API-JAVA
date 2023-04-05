package br.linguagensapi.liguagemapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "principaisLinguagens")

public class linguagem {

    @Id
    private String id;

    private String title;
    private String image;
    private int ranking;

    public linguagem(){

    }

    
    public linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getid(){
        return id;
    }
    public String gettitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRanking() {
        return ranking;
    }

    public void setId(String id) {
        this.id = id;
    }
}
