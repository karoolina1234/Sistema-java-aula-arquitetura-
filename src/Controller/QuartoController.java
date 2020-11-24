package Controller;

import dto.QuartoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.HotelService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "quarto")
public class QuartoController {
    private HotelService hotelService;

    @Autowired
    public  QuartoController (HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping(value = "/quarto")
    public ResponseEntity<List<QuartoDTO>> obterQuarto(){
        List<QuartoDTO> quartos = hotelService.findAll();
        return  new ResponseEntity<List<QuartoDTO>>(quartos, HttpStatus.OK);
    }

    @GetMapping(value = "/quarto/{id}")
    public ResponseEntity<QuartoDTO> obterQuartoPorId(@PathVariable("id") Integer id){
        QuartoDTO quarto = hotelService.findById(id);
        return new ResponseEntity<QuartoDTO>(quarto, HttpStatus.OK);

    }
    @PostMapping(value = "/quarto")
    public ResponseEntity<?> salvar(@RequestBody @Valid QuartoDTO quartoDTO){
        this.hotelService.save(quartoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "quarto/{id}")
    public ResponseEntity<QuartoDTO> editarQuarto(@PathVariable("id") String id, @RequestBody @Valid QuartoDTO quartoDTO){
        this.hotelService.edit(quartoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/quarto/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id){
        this.hotelService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
