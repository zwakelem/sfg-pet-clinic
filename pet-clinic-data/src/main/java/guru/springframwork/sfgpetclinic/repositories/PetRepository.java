package guru.springframwork.sfgpetclinic.repositories;

import guru.springframwork.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zwakele
 * on 2020/05/23
 **/
@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
