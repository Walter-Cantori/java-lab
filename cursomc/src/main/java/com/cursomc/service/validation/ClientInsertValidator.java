package com.cursomc.service.validation;

import java.util.ArrayList; 
import java.util.List;
import javax.validation.ConstraintValidator; 
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cursomc.DTO.ClienteNewDTO;
import com.cursomc.domain.Cliente;
import com.cursomc.domain.enuns.TipoCliente;
import com.cursomc.repositories.ClienteRepository;
import com.cursomc.service.exceptions.FieldMessage;
import com.cursomc.service.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClienteNewDTO> { 
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClientInsert ann) { }

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
		}
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ invalido"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já cadastrado"));
		}
		
		for (FieldMessage e : list) { 
			context.disableDefaultConstraintViolation(); 
			context.buildConstraintViolationWithTemplate(e.getMessage()) 
			.addPropertyNode(e.getFieldName()).addConstraintViolation();
	}
	return list.isEmpty(); }
}
