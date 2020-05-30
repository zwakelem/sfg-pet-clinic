package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by zwakele
 * on 2020/05/30
 **/
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

  @Mock
  OwnerRepository ownerRepository;
  @Mock
  PetRepository petRepository;
  @Mock
  PetTypeRepository petTypeRepository;
  @InjectMocks
  OwnerSDJpaService service;

  private static final String LAST_NAME = "Smith";

  private Owner returnedOwner;

  @BeforeEach void setUp() {
    returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
  }

  @Test void findByLastName() {
    when(ownerRepository.findByLastName(anyString())).thenReturn(returnedOwner);
    Owner owner = service.findByLastName(LAST_NAME);
    assertEquals(LAST_NAME, owner.getLastName());
    verify(ownerRepository, times(1)).findByLastName(anyString());
  }

  @Test void findAll() {
    //given
    Set<Owner> owners = new HashSet<>();
    owners.add(Owner.builder().id(1L).build());
    owners.add(Owner.builder().id(2L).build());
    owners.add(Owner.builder().id(3L).build());
    // when
    when(ownerRepository.findAll()).thenReturn(owners);
    // then
    Set<Owner> returnedOwners = service.findAll();

    assertEquals(returnedOwners.size(), 3);
    verify(ownerRepository, times(1)).findAll();
  }

  @Test void findById() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(returnedOwner));
    Owner owner = service.findById(1L);
    assertNotNull(owner);
  }

  @Test void findByIdNotFound() {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
    Owner owner = service.findById(1L);
    assertNull(owner);
  }

  @Test void save() {
    when(ownerRepository.save(any())).thenReturn(returnedOwner);
    Owner savedOwner = service.save(Owner.builder().id(1L).build());
    assertNotNull(savedOwner);
    assertEquals(Optional.ofNullable(savedOwner.getId()),Optional.of(1L));
    verify(ownerRepository, times(1)).save(any());
  }

  @Test void delete() {
    service.delete(returnedOwner);
    verify(ownerRepository, times(1)).delete(any());
  }

  @Test void deleteById() {
    service.deleteById(1L);
    verify(ownerRepository, times(1)).deleteById(anyLong());
  }
}