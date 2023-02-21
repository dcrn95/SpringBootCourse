package com.ntt.esercitazione.repository;

import com.ntt.esercitazione.domain.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
}