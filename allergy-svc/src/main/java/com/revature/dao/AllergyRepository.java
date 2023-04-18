package com.revature.dao;


import com.revature.model.Allergy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AllergyRepository extends CrudRepository<Allergy, Integer> {

}
