package repository;

import domain.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface hotelRepository extends JpaRepository <Quarto, Integer> {

    @Query("UPDATE Quarto set numero = :numero where id = :id")
    void editById(@Param("numero") String numero, @Param("tipo") String tipo,
                  @Param("valor") float valor, @Param("limpo") boolean limpo,
                  @Param("reservado") boolean reservado,
                  @Param("id") Integer id);
}

