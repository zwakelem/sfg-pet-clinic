package guru.springframwork.sfgpetclinic.services.springdatajpa;

import guru.springframwork.sfgpetclinic.model.Specialty;
import guru.springframwork.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframwork.sfgpetclinic.services.SpecialtyService;
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
public class SpecialtySDJpaService implements SpecialtyService {

  private final SpecialtyRepository repository;

  public SpecialtySDJpaService(SpecialtyRepository repository) {
    this.repository = repository;
  }

  @Override
  public Specialty findById(Long aLong) {
    return repository.findById(aLong).orElse(null);
  }

  @Override
  public Specialty save(Specialty specialty) {
    return repository.save(specialty);
  }

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> specialties = new HashSet<>();
    repository.findAll().forEach(specialties::add);
    return specialties;
  }

  @Override
  public void delete(Specialty object) {
    repository.delete(object);
  }

  @Override
  public void deleteById(Long aLong) {
    repository.deleteById(aLong);
  }
}
