package com.crudexample.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.crudexample.dto.BankSimpledto;
import com.crudexample.dto.Bankdto;
import com.crudexample.entity.Banks;
import com.crudexample.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;
	
	public static final Logger Logger=LoggerFactory.getLogger(BankService.class);

	@Caching(put = @CachePut(cacheNames = "bank", key = "#result.id"),
            evict = @CacheEvict(cacheNames = "banks", allEntries = true))
	public Banks createBank(Bankdto bankdto) {
    	Banks bank=new Banks();
    	BeanUtils.copyProperties(bankdto, bank);
		return bankRepository.saveAndFlush(bank);		
	}

	@Caching(evict = {
			@CacheEvict(value="bank", key="#bank_id"),
            @CacheEvict(cacheNames = "banks", allEntries = true)
    })	
    public boolean deleteBank(Long bank_id) {
    		bankRepository.deleteById(bank_id);
    		return true;    		
	}
	
	@Caching(put = @CachePut(cacheNames = "bank", key = "#bank_id"),
            evict = @CacheEvict(cacheNames = "banks", allEntries = true))
    public Banks updateBank(Bankdto bankdto, Long bank_id)
    {
    	Banks bank=bankRepository.getOne(bank_id);
    	BeanUtils.copyProperties(bankdto, bank);
		return bankRepository.save(bank);
    }

    @Cacheable(cacheNames="allBanks")
    public List<Bankdto> getAllBank()
    {
    	System.out.println("All Bank");
    	List<Banks> banks=bankRepository.findAll();
    	List<Bankdto> banksdto=new ArrayList<Bankdto>();
    	for(Banks bank:banks)
    	{
    		Bankdto bankdto=new Bankdto();
    		BeanUtils.copyProperties(bank,bankdto);
            banksdto.add(bankdto);
    	}
    	return banksdto;
    }
    
    @Cacheable(value="bank", key="#bank_id")
    public BankSimpledto getBank(Long bank_id)
    {
    	Logger.info("logs  span");
    	Banks bank=bankRepository.findById(bank_id).get();
    	BankSimpledto bankSimpledto=new BankSimpledto();
    	BeanUtils.copyProperties(bank,bankSimpledto);
    	return bankSimpledto;
    }

}
