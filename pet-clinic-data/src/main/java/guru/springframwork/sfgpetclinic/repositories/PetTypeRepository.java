package guru.springframwork.sfgpetclinic.repositories;

import guru.springframwork.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zwakele
 * on 2020/05/23
 **/
@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
