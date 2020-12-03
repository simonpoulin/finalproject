package fpt.java.finalproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.java.finalproject.models.Recipient;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Integer> {
   // Native SQL
   @Query(value = "SELECT * FROM recipients WHERE verification_code = :code" , nativeQuery = true)
   Recipient findRecipientByVerificationCode(@Param("code") String code);
}
