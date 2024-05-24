package br.gov.caixa.service;

import br.gov.caixa.dto.request.ClienteRequestDto;
import br.gov.caixa.dto.response.ClienteResponseDto;
import br.gov.caixa.entity.Cliente;
import br.gov.caixa.entity.ContaCorrente;
import br.gov.caixa.enums.TipoCliente;
import br.gov.caixa.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static br.gov.caixa.enums.Situacao.ATIVO;

@Service
public class ClienteService {
    final private ClienteRepository clienteRepository;
    final private ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    public ClienteResponseDto getCliente(String id) {
        Optional cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            return null;
        }
        return modelMapper.map(cliente.get(), ClienteResponseDto.class);
    }

    public ClienteResponseDto cadastrar(ClienteRequestDto clienteRequestDto, TipoCliente tipo) {
        ClienteResponseDto clienteResponseDto = getCliente(clienteRequestDto.getId());
        if (clienteResponseDto != null) {
            return null;
        }
        Cliente cliente = modelMapper.map(clienteRequestDto, Cliente.class);
        cliente.setDataCadastro(LocalDate.now());
        cliente.setStatus(ATIVO);
        cliente.setTipo(tipo);
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(cliente);
        contaCorrente.setDataCadastro(LocalDate.now());
        contaCorrente.setStatus(ATIVO);
        cliente.setContas(new ArrayList<>());
        cliente.getContas().add(contaCorrente);
        clienteRepository.save(cliente);
        return modelMapper.map(cliente, ClienteResponseDto.class);
    }
}
