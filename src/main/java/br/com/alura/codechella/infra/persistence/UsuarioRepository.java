package br.com.alura.codechella.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJpa, Long> {
    UsuarioJpa findByCpf(String cpf);
}
