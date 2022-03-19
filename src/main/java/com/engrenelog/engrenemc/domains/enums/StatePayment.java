package com.engrenelog.engrenemc.domains.enums;

public enum StatePayment {
	
	Pendente(1,"Pendente"),
	Settled(2, "Quitado"),
	Canceled(3,"Cancelado");
	
			private Integer id;
			private String description;
			
			private StatePayment(int id, String description) {
				this.id= id;
				this.description = description;
			}
			
			public Integer getID() {
				return id;
			}
			
			public String getDescription() {
				return description;
			}
			
			public static StatePayment ToEnum(Integer id) {
				if (id == null) {
					return null;
				}
				
				for (StatePayment x : StatePayment.values()) {
					if (id.equals(x.getID())) {
						return x;
					}
				}
				throw new IllegalArgumentException("Id inválido "+ id);
			}
}