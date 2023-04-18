package com.revature.dao;


import com.revature.model.Allergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class AllergyDao {

    Logger logger = Logger.getLogger(AllergyDao.class.getName());

    AllergyRepository allergyRepository;

    @Autowired
    AllergyDao(AllergyRepository allergyRepository) {
        this.allergyRepository = allergyRepository;
    }

    public List<Allergy> listAllAllergies() throws AllergyDaoException {
        List<Allergy> allergies = new ArrayList<>();
        try {
            this.allergyRepository.findAll().forEach(allergies::add);
        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            throw new AllergyDaoException("Allergies retrival failed.", exception);
        }
        return allergies;
    }

    public Optional<Allergy> listAllergyById(int id) throws AllergyDaoException {
        Optional<Allergy> allergy;
        try {
            allergy = this.allergyRepository.findById(id);
        } catch (Exception exception) {
            logger.log(Level.SEVERE, exception.getMessage());
            throw new AllergyDaoException(String.format("Allergy of id %d retrival failed.", id), exception);
        }
        return allergy;
    }
}
