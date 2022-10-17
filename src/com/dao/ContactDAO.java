package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entity.Employee;
public class ContactDAO {
	private Connection conn;
	public ContactDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean saveEmployee(Employee c) {
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee(name,desg,phno,salary) values(?,?,?,?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getDesg());
			ps.setString(3, c.getPhno());
			ps.setInt(4, c.getSalary());
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean editEmployee(Employee c) {
		boolean flag = false;
		try {
			PreparedStatement ps = conn.prepareStatement("update employee set phno=? where id=?");
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setString(3, c.getDesg());
			ps.setString(4, c.getPhno());
			ps.setInt(5, c.getSalary());			
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean deleteEmployee(int id) {
		boolean flag= false;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from employee where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		Employee obj = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from Employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				obj=new Employee();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhno(rs.getString(3));
				list.add(obj);
			}					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
