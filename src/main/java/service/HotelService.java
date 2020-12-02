package service;

import domain.Quarto;
import dto.QuartoDTO;
import org.springframework.stereotype.Service;
import repository.hotelRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private repository.hotelRepository hotelRepository;

    private HotelService( hotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void save(QuartoDTO quartoDTO){
        String numero = quartoDTO.getNumero();
        Integer id = quartoDTO.getId();
        String tipo = quartoDTO.getTipo();
        boolean limpo = quartoDTO.isLimpo();
        boolean reservado = quartoDTO.isReservado();
        float valor = quartoDTO.getValor();

        Quarto quarto = new Quarto(id, numero, valor, tipo, reservado, limpo);
        this.hotelRepository.saveAndFlush(quarto);
    }
    public QuartoDTO findById(Integer id){
        Optional<Quarto> quarto = hotelRepository.findById(id);
        if(quarto.isPresent()){
            QuartoDTO quartoDTO = criarQuartoDTO(quarto.get());
            return quartoDTO;
        }
        throw new ServiceException("Quarto não encontrado");
    }
    public List<QuartoDTO> findAll() {
        List<QuartoDTO> quartoRetorno = new ArrayList<QuartoDTO>();
        List<Quarto> quartos = hotelRepository.findAll();

        for (Quarto quarto : quartos) {
            QuartoDTO quartoDTO = criarQuartoDTO(quarto);
            quartoRetorno.add(quartoDTO);

        }
        return quartoRetorno;
    }
    private QuartoDTO criarQuartoDTO(Quarto quarto){
        QuartoDTO quartoDTO = new QuartoDTO();
        quartoDTO.setId(quarto.getId());
        quartoDTO.setLimpo(quarto.isLimpo());
        quartoDTO.setNumero(quarto.getNumero());
        quartoDTO.setReservado(quarto.isReservado());
        quarto.setValor(quarto.getValor());
        quarto.setTipo(quarto.getTipo());
        return quartoDTO;
    }
    public void delete(Integer id){
        this.hotelRepository.deleteById(id);
    }
    public void edit(QuartoDTO quartoDTO ){
        Optional<Quarto> quartoParaAtualizar = hotelRepository.findById(quartoDTO.getId());
        if(quartoParaAtualizar.isPresent()){
            Integer id = quartoDTO.getId();
            String numero = quartoDTO.getNumero();
            String tipo = quartoDTO.getTipo();
            float valor = quartoDTO.getValor();
            boolean limpo = quartoDTO.isLimpo();
            boolean reservado = quartoDTO.isReservado();
            hotelRepository.editById(numero, tipo, valor, limpo, reservado, id);
        }
        throw new ServiceException("quarto não encontrado");
    }

}
