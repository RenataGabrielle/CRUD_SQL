package br.com.empresa.vendamais.Controller;


import br.com.empresa.vendamais.model.Cliente;
import br.com.empresa.vendamais.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(
            @PathVariable Long id,
            @RequestBody Cliente clienteBody
    ) {
        return clienteService.buscarPorId(id)
                .map(c -> {
                    c.setNome(clienteBody.getNome());
                    c.setEmail(clienteBody.getEmail());
                    c.setTelefone(clienteBody.getTelefone());
                    Cliente atualizado = clienteService.atualizar(c);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(c -> {
                    clienteService.deletar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

