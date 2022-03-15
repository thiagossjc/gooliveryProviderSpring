package com.engrenelog.engrenemc.domains.enums;

public enum TypeCustomer {
	
	PhisicalPerson(1,"Pessoa Física"),
	LegalPerson(2, "Pessoa Jurídica");
	
			private int id;
			private String description;
			
			private TypeCustomer(int id, String description) {
				this.id= id;
				this.description = description;
			}
			
			public int getID() {
				return id;
			}
			
			public String getDescription() {
				return description;
			}
			
			public static TypeCustomer ToEnum(Integer id) {
				if (id == null) {
					return null;
				}
				
				for (TypeCustomer x : TypeCustomer.values()) {
					if (id.equals(x.getID())) {
						return x;
					}
				}
				throw new IllegalArgumentException("Id inválido "+ id);
			}
}
