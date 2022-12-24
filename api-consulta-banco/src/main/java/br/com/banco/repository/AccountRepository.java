package br.com.banco.repository;

import br.com.banco.domain.AccountEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<AccountEntity, Long> {

}