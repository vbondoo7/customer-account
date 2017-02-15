package com.cox.bis.customer.comments.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("datasource") 
public class DataSources {
	
	private Xhastage xhastage = new Xhastage();
	private Pstage pstage = new Pstage();
	private Icoms icoms = new Icoms();
	private Serviceability serviceability = new Serviceability();
	
	public static class Serviceability {
		private String url;
		private String username;
		private String password;
		private String driverClassName;
		
		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public javax.sql.DataSource primaryDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driverClassName);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);

	        return dataSource; 
		}
	}
	
	public static class Icoms {
		private String url;
		private String username;
		private String password;
		private String driverClassName;
		
		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public javax.sql.DataSource primaryDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(driverClassName);
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);

	        return dataSource; 
		}
	}
	
	public static class Xhastage {
		private String url;
		private String username;
		private String password;
		private String driverClassName;
		
		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public javax.sql.DataSource primaryDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);

	        return dataSource; 
		}
	}
	
	public Serviceability getServiceability() {
		return serviceability;
	}

	public void setServiceability(Serviceability serviceability) {
		this.serviceability = serviceability;
	}

	public Xhastage getXhastage() {
		return xhastage;
	}

	public void setXhastage(Xhastage xhastage) {
		this.xhastage = xhastage;
	}

	public Icoms getIcoms() {
		return icoms;
	}

	public void setIcoms(Icoms icoms) {
		this.icoms = icoms;
	}
	
	public static class Pstage {
		private String url;
		private String username;
		private String password;
		private String driverClassName;
		
		public String getDriverClassName() {
			return driverClassName;
		}
		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		public javax.sql.DataSource primaryDataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.postgresql.Driver");
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);

	        return dataSource; 
		}
	}
	
	public Pstage getPstage() {
		return pstage;
	}

	public void setPstage(Pstage pstage) {
		this.pstage = pstage;
	}
}