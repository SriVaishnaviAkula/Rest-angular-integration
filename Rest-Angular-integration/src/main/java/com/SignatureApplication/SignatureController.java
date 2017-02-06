package com.SignatureApplication;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SignatureModel.Signature;

@CrossOrigin
@Controller
@RestController
public class SignatureController {
	private static Map<BigInteger, Signature> signatureMap;
	private static BigInteger nextId;

	private static Signature save(Signature sig) {
		if (signatureMap == null) {
			signatureMap = new HashMap<BigInteger, Signature>();
			nextId = BigInteger.ONE;
		}
		System.out.println(sig);
		sig.setId(nextId);
		nextId = nextId.add(BigInteger.ONE);
		signatureMap.put(sig.getId(), sig);
		return sig;
	}

	static {
		Signature sig = new Signature();
		sig.setName("vaishnavi");
		sig.setAddress("123 street");
		sig.setEmail("v@v.com");
		sig.setSig("12355");
		save(sig);
	}

	@RequestMapping(value = "/api/signature", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Signature>> getSignture() {
		Collection<Signature> sig = signatureMap.values();
		return new ResponseEntity<Collection<Signature>>(sig, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/signature", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Signature> createSignture(@RequestBody Signature sig) {
		Signature savedSignature = save(sig);
		return new ResponseEntity<Signature>(savedSignature, HttpStatus.OK);
	}
}
