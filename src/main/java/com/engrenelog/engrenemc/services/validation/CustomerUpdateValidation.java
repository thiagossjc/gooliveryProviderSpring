package com.engrenelog.engrenemc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.engrenelog.engrenemc.domains.Customer;
import com.engrenelog.engrenemc.dto.CustomerDTO;
import com.engrenelog.engrenemc.repositorys.CustomerRepository;
import com.engrenelog.engrenemc.resources.exceptions.FieldMessage;

public class CustomerUpdateValidation implements ConstraintValidator<CustomerUpdate, CustomerDTO> {
	
	
	@Autowired
	private HttpServletRequest req; 
	
	@Autowired
	private CustomerRepository repoCust;
	
	@Override
	public void initialize(CustomerUpdate ann) {
	}	

	@Override
	public boolean isValid(CustomerDTO objDto, ConstraintValidatorContext context) {
		
		//buscar o id da requisição
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId =  Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();

		
		Customer aux = repoCust.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
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
