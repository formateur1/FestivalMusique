package com.inti.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

/**
 * @author Hayri ACAR
 * 
 * Implémentation des opérations CRUD
 */

@Service
public class SolisteServiceImpl implements ISolisteService {
	
	@Autowired
	ISolisteRepository isr;

	@Override
	public Soliste save(Soliste soliste) {
		if(soliste != null)
			return isr.save(soliste);
		
		return null;
	}

	@Override
	public List<Soliste> getAllSoliste() {
		return isr.findAll();
	}

	@Override
	public void delete(Long num) {
		
		if(Objects.nonNull(num))
			isr.deleteById(num);
	}

	@Override
	public boolean update(Soliste soliste) {
		if(Objects.nonNull(soliste))
		{
			isr.save(soliste);
			return true;
		}
		
		return false;
	}

	@Override
	public Soliste getSoliste(Long num) {
		if(!Objects.isNull(num))
			return isr.getReferenceById(num);
		
		return null;
	}

}
