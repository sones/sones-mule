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

package de.sones.mule.demo.transformers;

import java.util.HashMap;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class PropsToGQLTransformer extends AbstractMessageTransformer 
{

	@Override
	public Object transformMessage(MuleMessage message, String arg1)
			throws TransformerException {

		
		HashMap props = (HashMap) message.getPayload();
		
		String date =  props.get("date").toString();
		String userName = props.get("userName").toString();
		String messageTxt = props.get("message").toString();
	
		String gql = "INSERT INTO messages VALUES ( date = " + date + "," + " userName = '" + userName + "'," + " message = '" + messageTxt +"')"; 
		
		return gql;
	}
}
