package kr.co.shopwizard.dom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MantncRepository extends JpaRepository<Mantnc, Long> {
    @Query("SELECT p FROM Mantnc p ORDER BY p.mantncNo DESC")
    List<Mantnc> findAll();
}
