package guru.springframwork.sfgpetclinic.repositories;

import guru.springframwork.sfgpetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zwakele
 * on 2020/05/23
 **/
@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
