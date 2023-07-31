package com.filediarysystem.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.filediarysystem.entities.FileDiary;

public interface FileDiaryRepository extends JpaRepository<FileDiary, Long>
{
	@Query("Select f from FileDiary f where f.user_id= :user_id order by f.cdt desc")
	List<FileDiary> findAllByUserId(@Param("user_id") Long user_id);
	
	@Query("Select f from FileDiary f where f.id= :id")
	FileDiary findByfile_Id(@Param("id") Long id);
	
	@Query("Select f from FileDiary f where f.file_no= :file_no or f.reference_no= :reference_no or f.received_from= :received_from or f.subject= :subject or f.cdt>= :from_date or f.cdt<= :to_date and user_id= :user_id")
	List<FileDiary> searchFileDiary(@Param("file_no") String file_no, @Param("reference_no") String reference_no, @Param("received_from") String received_from, 
			@Param("subject") String subject, @Param("from_date") Date from_date, @Param("to_date") Date to_date, @Param("user_id") Long user_id);

//	@Query(query)
//	Optional<FileDiary> searchFileDiary(String "Select f from FileDiary f where "+query);
	
	
}
