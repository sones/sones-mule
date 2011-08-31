/*
* sones GraphDB Talend Client Library
* Copyright (C) 2007-2011 sones GmbH - http://www.sones.com
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
*/

package de.sones.mule.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;

import sun.net.www.protocol.http.HttpURLConnection;


public class MessageBean {

	private Date date;
	private String userName;
	private String message;
	
	
	/*
	 * Date
	 */
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	/*
	 * User name
	 */
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	/*
	 * Message
	 */
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		
		this.date = new Date();
		this.message = message;
	}
	
	/*
	 * Program logic
	 */
	public String sendMessage()
	{
		System.out.println("Sending message ...");
		
		try
		{
	

		    String data = "date=" + URLEncoder.encode("" + this.date.getTime()) +
		                  "&userName=" + URLEncoder.encode(this.userName) + 
		                  "&message=" + URLEncoder.encode(this.message);

			
			HttpURLConnection con = (HttpURLConnection) new URL("http://localhost:8888/services/messenger").openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
				
			OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
			out.write(data);
			out.flush();			
			out.close();


			//Get Response	
		    InputStream is = con.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    String line;
		    StringBuffer response = new StringBuffer(); 
		      
		    while((line = rd.readLine()) != null) {
		        response.append(line);
		        response.append('\r');
		    }
		    
		    rd.close();
		    
		    con.disconnect();
		     
		    return "";
			
			
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
			
	}	
}
