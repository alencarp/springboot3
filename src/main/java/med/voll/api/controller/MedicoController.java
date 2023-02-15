package med.voll.api.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao) {
        //return repository.findAll();
        //assim dá erro, pq retorna um Medico, portanto tenho que converter de Medico para
        // DadosListagemMedico. Para isso uso o stream() e o map()!!!!!

        //ordenando o resultado
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        //Optional<Medico> medicoOptional = repository.findById(dados.id());
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id);
        medico.excluir();
    }


}
