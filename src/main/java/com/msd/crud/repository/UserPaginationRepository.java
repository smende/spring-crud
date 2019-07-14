package com.msd.crud.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.msd.crud.domain.User;

public interface UserPaginationRepository extends PagingAndSortingRepository<User, Long>{

}
