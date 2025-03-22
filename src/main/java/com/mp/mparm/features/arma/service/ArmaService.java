package com.mp.mparm.features.arma.service;

import com.mp.mparm.features.arma.model.dto.ArmaDTO;
import com.mp.mparm.features.arma.model.entity.Arma;
import com.mp.mparm.features.arma.repository.ArmaRepository;
import com.mp.mparm.features.arma.usecase.CadastroArmaUseCase;
import com.mp.mparm.features.arma.usecase.DelecaoArmaUseCase;
import com.mp.mparm.features.arma.usecase.ListagemArmaUseCase;
import com.mp.mparm.features.calibre.repository.CalibreRepository;
import com.mp.mparm.features.fabricante.repository.FabricanteRepository;
import com.mp.mparm.features.modeloArma.repository.ModeloArmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArmaService {

    private final ModeloArmaRepository modeloArmaRepository;
    private final ArmaRepository armaRepository;
    private final CalibreRepository calibreRepository;
    private final FabricanteRepository fabricanteRepository;

    public List<Arma> listar() {
        ListagemArmaUseCase listagemArmaUseCase = new ListagemArmaUseCase(armaRepository);

        return listagemArmaUseCase.executarListagemArmas();
    }

    public Arma buscarPorId(Long id) {
        ListagemArmaUseCase listagemArmaUseCase = new ListagemArmaUseCase(armaRepository);

        return listagemArmaUseCase.pesquisarArmaPorID(id);
    }

    public Arma salvar(ArmaDTO dto) {
        CadastroArmaUseCase cadastroArmaUseCase = new CadastroArmaUseCase(armaRepository, modeloArmaRepository,calibreRepository,fabricanteRepository);

        return cadastroArmaUseCase.executarCriacaoArma(dto);
    }

    public void deletar(Long id) {
        DelecaoArmaUseCase delecaoArmaUseCase = new DelecaoArmaUseCase(armaRepository);

        delecaoArmaUseCase.executarDelecaoArma(id);
    }
}
