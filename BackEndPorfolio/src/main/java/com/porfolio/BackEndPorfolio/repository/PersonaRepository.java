
package com.porfolio.BackEndPorfolio.repository;

import com.porfolio.BackEndPorfolio.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author GabrielPc
 */
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
