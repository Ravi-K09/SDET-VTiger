package com.crm.vtiger;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	/**
	 * This class helps to read data from Prop file it has 2 methods
	 *
	 */
	public class FileUtill 
	{
		/**
		 * This method read the data from prop file
		 * @param key
		 * @return value from prop file
		 * @throws IOException
		 */

		public String readDatafromPropfile(String key) throws IOException {
			FileInputStream fis = new FileInputStream(IAutoconstant.propfilepath);

			Properties prop  = new  Properties();
			prop.load(fis);

			return prop.getProperty(key);

		}
		public String readDatafromPropfile(String path,String key) throws IOException {
			FileInputStream fis = new FileInputStream(path);

			Properties prop  = new  Properties();
			prop.load(fis);

			return prop.getProperty(key);

		}


	}

