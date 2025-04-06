package br.com.apicontructor.infrastructure.repository.location;

import br.com.apicontructor.infrastructure.entity.location.CityEntity;
import br.com.apicontructor.infrastructure.entity.location.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    List<CityEntity> findByStateId(long stateId);
}