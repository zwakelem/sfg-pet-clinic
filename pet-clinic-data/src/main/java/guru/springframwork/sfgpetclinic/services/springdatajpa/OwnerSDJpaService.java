package guru.springframwork.sfgpetclinic.services.springdatajpa;

import guru.springframwork.sfgpetclinic.model.Owner;
import guru.springframwork.sfgpetclinic.repositories.OwnerRepository;
import guru.springframwork.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zwakele
 * on 2020/05/23
 **/
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

  private final OwnerRepository ownerRepository;

  public OwnerSDJpaService(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public Owner findByLastName(String lastName) {
    return ownerRepository.findByLastName(lastName);
  }

  @Override
  public Owner findById(Long aLong) {
    return ownerRepository.findById(aLong).orElse(null);
  }

  @Override
  public Owner save(Owner owner) {
    return ownerRepository.save(owner);
  }

  @Override
  public Set<Owner> findAll() {
    Set<Owner> owners = new HashSet<>();
    ownerRepository.findAll().forEach(owners::add);
    return owners;
  }

  @Override
  public void delete(Owner object) {
    ownerRepository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    ownerRepository.deleteById(aLong);
  }
}
