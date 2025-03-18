package com.mp.mparm.features.historicoMovimentacao.repository;

import com.mp.mparm.features.historicoMovimentacao.model.entity.HistoricoMovimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoMovimentacaoRepository extends JpaRepository<HistoricoMovimentacao, Long> {
}
