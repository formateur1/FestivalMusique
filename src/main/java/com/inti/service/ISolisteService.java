package com.inti.service;

import java.util.List;

import com.inti.model.Soliste;

/**
 * @author Hayri ACAR
 * 
 * Les opérations CRUD
 */

public interface ISolisteService {
	
	public Soliste save(Soliste soliste);
	public List<Soliste> getAllSoliste();
	public void delete(Long num);
	public boolean update(Soliste soliste);
	public Soliste getSoliste(Long num);

}
