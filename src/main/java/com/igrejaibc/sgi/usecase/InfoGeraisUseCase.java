package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.mapper.AniversarianteMapper;
import com.igrejaibc.sgi.model.membro.Membro;
import com.igrejaibc.sgi.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.igrejaibc.sgi.util.Utils.converterDataFormatoBR;

@Component
public class InfoGeraisUseCase {

    private static final Logger LOGGER = Logger.getLogger(InfoGeraisUseCase.class.getName());

    @Autowired
    private MembroService membroService;

    public ResponseEntity aniversariantesMes() {
        LOGGER.log(Level.INFO, "Buscando dados dos membros...");

        try {
            List<Membro> infoMembros = this.membroService.listarMembros();
            List<AniversarianteMapper> aniversantesMes = infoMembros.stream().filter(m -> m.getInfoPessoais().getDataNascimento().getMonthValue() == LocalDate.now().getMonthValue()).map(membro -> {
                return AniversarianteMapper.builder()
                        .nome(membro.getInfoPessoais().getNomeCompleto())
                        .dataNascimento(converterDataFormatoBR(membro.getInfoPessoais()
                                .getDataNascimento().toString()))
                        .whatsapp(membro.getInfoPessoais().getWhatsapp()).build();
            }).collect(Collectors.toList());
            return aniversantesMes.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(aniversantesMes);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
