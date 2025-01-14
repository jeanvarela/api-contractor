package br.com.apicontructor.infrastructure.repository.location;

import br.com.apicontructor.infrastructure.entity.location.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {
}