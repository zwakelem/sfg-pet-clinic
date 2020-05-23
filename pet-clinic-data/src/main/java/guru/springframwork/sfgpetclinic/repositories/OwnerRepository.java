package guru.springframwork.sfgpetclinic.repositories;

import guru.springframwork.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zwakele
 * on 2020/05/23
 **/
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

  Owner findByLastName(String lastName);
}
