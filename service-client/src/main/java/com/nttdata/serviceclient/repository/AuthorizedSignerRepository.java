package com.nttdata.serviceclient.repository;

import com.nttdata.serviceclient.entity.AuthorizedSigner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizedSignerRepository extends JpaRepository<AuthorizedSigner,Long> {
}
