package jpa73.repository;

import jpa73.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PagingClientRepository<T> extends PagingAndSortingRepository<Client, Long> {

    //select * from clients where fullName='' order by age desc
    Page<Client> findAllByFullNameOrderByAgeDesc(String fullName, Pageable pageable);

    List<T> findByFullName(String fullName, Class<T> classParam);

    @Query("select c from Client c where fullName like %:partOfName%")
    List<Client> findByFullNameLike(String partOfName);

    @Query("select new jpa73.repository.Phone(c.fullName, c.phone) from Client c")
    List<Phone> findAllPhoneNumbers();

}
