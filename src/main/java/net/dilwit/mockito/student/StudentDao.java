package net.dilwit.mockito.student;

import net.dilwit.mockito.database.DatabaseException;

/**
 * 
 * @author Dilusha Withanage
 *
 */
public interface StudentDao {

	void updateStudent(Student student) throws DatabaseException;

}
