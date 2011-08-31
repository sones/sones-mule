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


import java.util.ArrayList;
import java.util.Date;
import de.sones.GraphDBClient.GraphDBClient;
import de.sones.GraphDBClient.Objects.Property;
import de.sones.GraphDBClient.Objects.Vertex;
import de.sones.GraphDBClient.QueryResult.QueryResult;

public class MessageListBean {

	
	private ArrayList<MessageBean> messages;
	
	
	
	public ArrayList<MessageBean> getMessages() {
	
		System.out.println("Retrieving messages ...");
		
		messages = new ArrayList<MessageBean>();
		
		try
		{
		
			GraphDBClient client = new GraphDBClient("localhost", "test", "test", 9975);
		
			//date, userName, message
			QueryResult result = client.Query("FROM messages SELECT date, userName, message");
			
			//To convert the current vertex into a message
			MessageBean currMessageBean = null;
			
			for (Vertex v : result.getVertexViewList())
			{
				currMessageBean = new MessageBean();
				
				Property userProperty = v.getPropertyByID("userName");
				currMessageBean.setUserName(userProperty.getValue().toString());
				
				Property msgProperty = v.getPropertyByID("message");
				currMessageBean.setMessage(msgProperty.getValue().toString());
				
				Property dateProperty = v.getPropertyByID("date");
				long dateAsLong = (Long) dateProperty.getValue();
				currMessageBean.setDate(new Date(dateAsLong));
				
				this.messages.add(currMessageBean);
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return this.messages;
	}
	
}
