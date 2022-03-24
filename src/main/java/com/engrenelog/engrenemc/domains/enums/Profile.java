package com.engrenelog.engrenemc.domains.enums;

public enum Profile {
	//ROLE_ADMIN é exigencia do frameword SPRING SECURITY
	Admin(1,"ROLE_ADMIN"),
	Customer(2, "ROLE_CUSTOMER"),
	Supplier(3,"ROLE_SUPPLIER");
	
			private Integer id;
			private String description;
			
			private Profile(int id, String description) {
				this.id= id;
				this.description = description;
			}
			
			public Integer getID() {
				return id;
			}
			
			public String getDescription() {
				return description;
			}
			
			public static Profile ToEnum(Integer id) {
				if (id == null) {
					return null;
				}
				
				for (Profile x : Profile.values()) {
					if (id.equals(x.getID())) {
						return x;
					}
				}
				throw new IllegalArgumentException("Id inválido "+ id);
			}
}