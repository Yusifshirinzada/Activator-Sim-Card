package au.com.telstra.simcardactivator.repository;

import au.com.telstra.simcardactivator.record.Record;
import org.springframework.data.repository.CrudRepository;

public interface SimRecord extends CrudRepository<Record,Long> {
}
