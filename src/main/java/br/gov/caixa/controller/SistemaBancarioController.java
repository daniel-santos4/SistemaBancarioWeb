package br.gov.caixa.controller;

import br.gov.caixa.dto.request.ClienteRequestDto;
import br.gov.caixa.dto.response.ClienteResponseDto;
import br.gov.caixa.enums.TipoCliente;
import br.gov.caixa.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class SistemaBancarioController {
    final private ClienteService clienteService;

    public SistemaBancarioController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> getCliente(@PathVariable String id) {
        ClienteResponseDto clienteResponseDto = clienteService.getCliente(id);
        if(clienteResponseDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(clienteResponseDto);
    }

    @PostMapping("/cadastrar/{tipo}")
    public ResponseEntity<ClienteResponseDto> cadastrar(@RequestBody ClienteRequestDto clienteRequestDto, @PathVariable TipoCliente tipo) {
        ClienteResponseDto clienteResponseDto = clienteService.cadastrar(clienteRequestDto, tipo);
        if (clienteResponseDto == null) {
            ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.ok(clienteResponseDto);
    }
}
