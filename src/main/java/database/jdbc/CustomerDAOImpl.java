package database.jdbc;

import database.CustomerDAO;
import database.DBException;
import domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static domain.CustomerBuilder.createCustomer;

/**
 * Created by marko on 2017.11.16..
 */
public class CustomerDAOImpl extends DAOImpl implements CustomerDAO {


	@Override
	public Customer saveNewCustomer(Customer customer) throws DBException{
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "insert into CUSTOMERS(customer_id, name, registration_date) values(default, ?, ?)";
			PreparedStatement preparedStatement =
					connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, getTime());

			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()){
				customer.setId(rs.getLong(1));
			}
		} catch (Throwable e) {
			System.out.println("Exception while execute CustomerDAOImpl.saveNewCustomer()");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
		return customer;
	}

	public boolean addLoan(Long customerId, double loanAmount, int passingTerm)throws DBException{
		Connection connection = null;

		try {
			connection = getConnection();
			String sql = "insert into LOANS" +
					"(loans_id," +
					" customer_id," +
					" loan_amount," +
					" passing_term," +
					"loan_extended_state," +
					" take_loan_date) " +
					"values(default, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerId);
			preparedStatement.setDouble(2,loanAmount);
			preparedStatement.setInt(3, passingTerm);
			preparedStatement.setBoolean(4, false);
			preparedStatement.setString(5, getTime());
			preparedStatement.executeUpdate();

			return true;
		} catch (Throwable e) {
			System.out.println("Exception while execute CustomerDAOImpl.addLoan()");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
	}


	@Override
	public Customer searchCustomer(String name) throws DBException{
		Connection connection = null;
		try{
			connection = getConnection();
			String sql = "select * from CUSTOMERS where name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			Customer logInCustomer = null;
			if(resultSet.next()){
				logInCustomer = createCustomer()
						.withId(resultSet.getLong("customer_id"))
						.withName(resultSet.getString("name")).build();
			}
			return logInCustomer;
		}
		catch(Throwable e){
			System.out.println("Exception while execute CustomerDAOImpl.searchCustomer");
			e.printStackTrace();
			throw new DBException(e);
		}finally{
			closeConnection(connection);
		}
	}

	@Override
	public List<Customer> getUserLoans(Long id)throws DBException{
		List<Customer> customerLoans = new ArrayList<>();
		Connection connection = null;
		try{
			connection = getConnection();
			String sql = "select * from CUSTOMERS natural join LOANS where customer_id = ?";
//			String sql = "select * from " +
//					"CUSTOMERS join LOANS join EXTENDED_LOANS on " +
//					"CUSTOMERS.customer_id = ? and " +
//					"LOANS.customer_id = ? or " +
//					"EXTENDED_LOANS.customer_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
//			preparedStatement.setLong(2, id);
//			preparedStatement.setLong(3, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				Customer customer = createCustomer()
						.withName(resultSet.getString("name"))
						.withLoanId(resultSet.getLong("loans_id"))
						.withLoanAmount((resultSet.getDouble("loan_amount")))
						.withPassingTerm(resultSet.getInt("passing_term"))
						.withExtendLoanState(resultSet.getBoolean("loan_extended_state"))
						.withDate(resultSet.getString("take_loan_date")).build();
				customerLoans.add(customer);
			}
		}
		catch(Throwable e){
			System.out.println("Exception while execute CustomerDAOImpl.getUserLoans");
			e.printStackTrace();
			throw new DBException(e);
		}finally{
			closeConnection(connection);
		}
		return customerLoans;
	}

	@Override
	public boolean extendLoan(Long loanToExtendId, double extendLoanAmount, int extendTermWeeks){

		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "insert into EXTENDED_LOANS" +
					"(loans_id," +
					"extended_loan_amount," +
					"extended_passing_term, " +
					"extend_passing_term_date) " +
					"values(default, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, loanToExtendId);
			preparedStatement.setDouble(2,extendLoanAmount);
			preparedStatement.setInt(3, extendTermWeeks);
			preparedStatement.setString(4, getTime());
			preparedStatement.executeUpdate();

			return true;
		} catch (Throwable e) {
			System.out.println("Exception while execute CustomerDAOImpl.extendLoan()");
			e.printStackTrace();
			throw new DBException(e);
		} finally {
			closeConnection(connection);
		}
	}

	@Override
	public String getTime(){
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
}
