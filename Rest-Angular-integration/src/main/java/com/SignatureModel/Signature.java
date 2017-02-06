package com.SignatureModel;

import java.math.BigInteger;

public class Signature {
		private BigInteger id;
		private String name;
	    private String address;
	    private String email;
	    private String sig;
	   
	    
		@Override
		public String toString() {
			return "Signature [id=" + id + ", address=" + address + ", name=" + name + ", email=" + email +", signature=" + sig + "]";
		}


		public BigInteger getId() {
			return id;
		}


		public void setId(BigInteger id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getSig() {
			return sig;
		}


		public void setSig(String signature) {
			sig = signature;
		}
		
		
		
}