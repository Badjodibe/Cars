package com.carsdatabase.carsdatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.carsdatabase.carsdatabase.domain.Owner;
import com.carsdatabase.carsdatabase.domain.OwnerRepository;

@DataJpaTest
public interface OwnerRepositoryTest {

	private OwnerRepository repository;
	@Test
	default
	void saveOwner() {
		repository.save(new Owner("Lucy", "Smith"));
		assertThat(repository.findByFirstname
		("Lucy").isPresent())
		.isTrue();
	}
	
	@Test
	default
	void deleteOwners() {
		repository.save(new Owner("Lisa", "Morrison"));
		repository.deleteAll();
		assertThat(repository.count()).isEqualTo(0);
	}
}
