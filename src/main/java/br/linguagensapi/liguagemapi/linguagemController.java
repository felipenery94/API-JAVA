package br.linguagensapi.liguagemapi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController

public class linguagemController {

    @Autowired

    private repository  repositorio;

    @PostMapping("/linguagem")
    public ResponseEntity<linguagem> cadastrarLinguagem(@RequestBody linguagem linguagem){
       linguagem linguagemSalva = repositorio.save(linguagem);
       return new ResponseEntity<>(linguagemSalva, HttpStatus.CREATED);
        
    }


    @GetMapping("/linguagem")
    public List<linguagem> obterLinguagens(){
        List<linguagem> linguagens = repositorio.findByOrderByRanking();
        return linguagens;
    }

    @GetMapping ("/linguagem/{id}")
    public linguagem obterLinguagemPorId(@PathVariable String id){

        return repositorio.findById(id)
            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/linguagem/{id}")
    public linguagem atualizaLinguagem(@PathVariable String id, @RequestBody linguagem linguagem){
       repositorio.findById(id)
       .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        linguagem.setId(id);
        linguagem linguagemSalva = repositorio.save(linguagem);
            return linguagemSalva;
    }

    
    @DeleteMapping("/linguagem/{id}")
        public void exluirLinguagem(@PathVariable String id){
            repositorio.deleteById(id);
        }
}
