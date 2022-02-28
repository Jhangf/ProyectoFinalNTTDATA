package com.nttdata.serviceclient.repository;

import com.nttdata.serviceclient.entity.PersonalClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalClientRepository extends JpaRepository<PersonalClient,Long> {

}
