package com.engrenelog.engrenemc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.engrenelog.engrenemc.domains.Customer;
import com.engrenelog.engrenemc.domains.enums.TypeCustomer;
import com.engrenelog.engrenemc.dto.ClientNewDTO;
import com.engrenelog.engrenemc.repositorys.CustomerRepository;
import com.engrenelog.engrenemc.resources.exceptions.FieldMessage;
import com.engrenelog.engrenemc.services.validation.utils.ValidationBR;

public class CustomerInsertValidation implements ConstraintValidator<CustomerInsert, ClientNewDTO> {
	
	@Autowired
	private CustomerRepository repoCust;
	
	@Override
	public void initialize(CustomerInsert ann) {
	}	

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTypeC().equals(TypeCustomer.PhisicalPerson.getID()) && !ValidationBR.isValidCPF(objDto.getIdCustmOrIdCompany())) {
			list.add(new FieldMessage("CpfoCNPJ ","CPF inválido!"));
		}
		
		if (objDto.getTypeC().equals(TypeCustomer.LegalPerson.getID()) && !ValidationBR.isValidCNPJ(objDto.getIdCustmOrIdCompany())) {
			list.add(new FieldMessage("CpfoCNPJ ","CPF inválido!"));
		}
		
		Customer aux = repoCust.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("Email","Email já existente!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFildname())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
