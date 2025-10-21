package com.hc.app.repository;

import com.hc.app.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRespository extends JpaRepository<LivroModel, Long> {
}
