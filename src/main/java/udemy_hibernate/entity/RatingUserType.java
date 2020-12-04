package udemy_hibernate.entity;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;


//we can use this class both Hibernate and JPA
public class RatingUserType implements UserType {

	@Override
	public int[] sqlTypes() {
		
		return new int[] {Types.INTEGER};
	}

	@Override
	public Class returnedClass() {

		return Rating.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		
		return x==y;
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		
		return x!=null?x.hashCode():0;
	}

	
	//This method is to convert the value that we read from Database,  to the Rating Enum info value (name).
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		Integer value = rs.getInt(names[0]);  // we use Integer instead of int because we should check the null situation.
		if(value == null) return null;
		if(value == 100) return Rating.STANDART;
		else return Rating.PREMIUM;
	}

	// This method is to convert setted Enum info value (name or ordinary)  to the  value in Database
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		if(value == null) {
			st.setObject(index, null);
			
		}else {
			st.setInt(index, ((Rating)value).getValue());
		}

	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		
		return value;
	}

	@Override
	public boolean isMutable() {
		
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
	
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {

		return original;
	}

}
